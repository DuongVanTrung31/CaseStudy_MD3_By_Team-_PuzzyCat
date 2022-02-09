package service.interfaceService;

import model.Users;
import service.IGeneralService;

public interface IUsersService extends IGeneralService<Users> {
    String findPassByAccount(String account, String email);
    boolean updateByUser(String account,Users users);
}
