package by.dzhivushko.training.shop.dataaccess.impl;

import org.springframework.stereotype.Repository;

import by.dzhivushko.training.shop.dataaccess.UserCredentialsDao;
import by.dzhivushko.training.shop.datamodel.UserCredentials;

@Repository
public class UserCredentialsDaoImpl extends AbstractDaoImpl<UserCredentials, Long> implements UserCredentialsDao {

    protected UserCredentialsDaoImpl() {
        super(UserCredentials.class);
    }

}
