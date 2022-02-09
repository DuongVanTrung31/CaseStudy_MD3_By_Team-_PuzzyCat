package service;

import model.Users;

public interface IUsersService extends IGeneralService<Users>{
    String findPassByAccount(String account, String email);
    boolean updateByUser(String account,Users users);
}
