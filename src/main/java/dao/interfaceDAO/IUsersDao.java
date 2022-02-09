package dao.interfaceDAO;

import dao.IGeneralDAO;
import model.Users;

public interface IUsersDao extends IGeneralDAO<Users> {
    String findPassByAccount(String account, String email);
    boolean updateByUser(String account,Users users);
}
