package by.dzhivushko.training.shop.service;

import java.lang.reflect.Field;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.dzhivushko.training.shop.dataaccess.UserProfileDao;
import by.dzhivushko.training.shop.dataaccess.filters.UserFilter;
import by.dzhivushko.training.shop.dataaccess.impl.AbstractDaoImpl;
import by.dzhivushko.training.shop.datamodel.UserCredentials;
import by.dzhivushko.training.shop.datamodel.UserProfile;
import by.dzhivushko.training.shop.datamodel.UserProfile_;
import by.dzhivushko.training.shop.datamodel.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class UserServiceTest {

    @Inject
    private UserService userService;

    @Inject
    private UserProfileDao userProfileDao;

    @Test
    public void test() {
        Assert.assertNotNull(userService);
    }

    @Test
    public void testEntityManagerInitialization() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field f = AbstractDaoImpl.class.getDeclaredField("entityManager");
        f.setAccessible(true);
        EntityManager em = (EntityManager) f.get(userProfileDao);

        Assert.assertNotNull(em);
    }

    @Test
    public void testRegistration() {
        UserProfile profile = new UserProfile();
        UserCredentials userCredentials = new UserCredentials();

        profile.setFirstName("testFName");
        profile.setLastName("testLName");

        userCredentials.setEmail(System.currentTimeMillis() + "mail@test.by");
        userCredentials.setPassword("pswd");
        userCredentials.setRole(UserRole.admin);
        userService.register(profile, userCredentials);

        UserProfile registredProfile = userService.getProfile(profile.getId());
        UserCredentials registredCredentials = userService.getCredentials(userCredentials.getId());

        Assert.assertNotNull(registredProfile);
        Assert.assertNotNull(registredCredentials);

        String updatedFName = "updatedName";
        profile.setFirstName(updatedFName);
        userService.update(profile);

        Assert.assertEquals(updatedFName, userService.getProfile(profile.getId()).getFirstName());

        userService.delete(profile.getId());

        Assert.assertNull(userService.getProfile(profile.getId()));
        Assert.assertNull(userService.getCredentials(userCredentials.getId()));
    }

    @Test
    public void testSearch() {
        // clean all data from users
        List<UserProfile> all = userService.getAll();
        for (UserProfile userProfile : all) {
            userService.delete(userProfile.getId());
        }

        // start create new data
        int testObjectsCount = 5;
        for (int i = 0; i < testObjectsCount; i++) {
            UserProfile profile = new UserProfile();
            UserCredentials userCredentials = new UserCredentials();

            profile.setFirstName("testFName" + i);
            profile.setLastName("testLName" + i);

            userCredentials.setEmail(i + "mail@test.by");
            userCredentials.setPassword(i + "pswd");
            userCredentials.setRole(UserRole.admin);
            userService.register(profile, userCredentials);
        }

        UserFilter filter = new UserFilter();
        List<UserProfile> result = userService.find(filter);
        Assert.assertEquals(testObjectsCount, result.size());
        // test paging
        filter.setFetchCredentials(true);
        int limit = 3;
        filter.setLimit(limit);
        filter.setOffset(0);
        result = userService.find(filter);
        Assert.assertEquals(limit, result.size());

        // test sort

        filter.setLimit(null);
        filter.setOffset(null);
        filter.setSortOrder(true);
        filter.setSortProperty(UserProfile_.firstName);
        result = userService.find(filter);
        Assert.assertEquals(testObjectsCount, result.size());

    }
}
