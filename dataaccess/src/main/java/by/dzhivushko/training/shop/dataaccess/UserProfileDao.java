package by.dzhivushko.training.shop.dataaccess;

import java.util.List;

import by.dzhivushko.training.shop.dataaccess.filters.UserFilter;
import by.dzhivushko.training.shop.datamodel.UserProfile;

public interface UserProfileDao extends AbstractDao<UserProfile, Long> {

    List<UserProfile> find(UserFilter filter);

}
