package by.dzhivushko.training.shop.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.dzhivushko.training.shop.dataaccess.UserCredentialsDao;
import by.dzhivushko.training.shop.dataaccess.UserProfileDao;
import by.dzhivushko.training.shop.dataaccess.filters.UserFilter;
import by.dzhivushko.training.shop.datamodel.UserCredentials;
import by.dzhivushko.training.shop.datamodel.UserProfile;
import by.dzhivushko.training.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    private UserProfileDao userProfileDao;

    @Inject
    private UserCredentialsDao userCredentialsDao;

    @Override
    public void register(UserProfile profile, UserCredentials userCredentials) {

        userCredentialsDao.insert(userCredentials);
        profile.setCredentials(userCredentials);

        profile.setCreated(new Date());
        userProfileDao.insert(profile);

        LOGGER.info("User regirstred: {}", userCredentials);
    }

    @Override
    public UserProfile getProfile(Long id) {
        return userProfileDao.get(id);
    }

    @Override
    public UserCredentials getCredentials(Long id) {
        return userCredentialsDao.get(id);
    }

    @Override
    public void update(UserProfile profile) {
        userProfileDao.update(profile);
    }

    @Override
    public void delete(Long id) {
        userProfileDao.delete(id);
        userCredentialsDao.delete(id);
    }

    @Override
    public List<UserProfile> find(UserFilter filter) {
        return userProfileDao.find(filter);
    }

    @Override
    public List<UserProfile> getAll() {
        return userProfileDao.getAll();
    }
}
