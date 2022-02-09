package dao;

import model.Users;

public interface IUsersDao extends IGeneralDao<Users>{
    String findPassByAccount(String account, String email);
    boolean updateByUser(String account,Users users);
}
