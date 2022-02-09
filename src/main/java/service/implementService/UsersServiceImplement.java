package service.implementService;

import dao.implementDAO.UsersDaoImplement;
import dao.interfaceDAO.IUsersDao;
import model.Users;
import service.interfaceService.IUsersService;

import java.util.List;

public class UsersServiceImplement implements IUsersService {
    private final IUsersDao usersDao = new UsersDaoImplement();

    @Override
    public List<Users> getAll() {
        return usersDao.getAll();
    }

    @Override
    public boolean add(Users users) {
        return usersDao.add(users);
    }

    @Override
    public boolean update(int id, Users users) {
        return usersDao.update(id,users);
    }

    @Override
    public boolean delete(int id) {
        return usersDao.delete(id);
    }

    @Override
    public Users findById(int id) {
        return usersDao.findById(id);
    }

    @Override
    public String findPassByAccount(String account, String email) {
        return usersDao.findPassByAccount(account,email);
    }

    @Override
    public boolean updateByUser(String account, Users users) {
        return usersDao.updateByUser(account,users);
    }
}
