package by.dzhivushko.training.shop.service;

import java.util.List;

import javax.transaction.Transactional;

import by.dzhivushko.training.shop.dataaccess.filters.UserFilter;
import by.dzhivushko.training.shop.datamodel.UserCredentials;
import by.dzhivushko.training.shop.datamodel.UserProfile;

public interface UserService {

    @Transactional
    void register(UserProfile profile, UserCredentials userCredentials);

    UserProfile getProfile(Long id);

    UserCredentials getCredentials(Long id);

    @Transactional
    void update(UserProfile profile);

    @Transactional
    void delete(Long id);

    List<UserProfile> find(UserFilter filter);

    List<UserProfile> getAll();

}
