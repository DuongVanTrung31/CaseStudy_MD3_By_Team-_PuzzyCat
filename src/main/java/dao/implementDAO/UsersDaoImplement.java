package dao.implementDAO;

import connection.DBConnection;
import dao.interfaceDAO.IUsersDao;
import model.Users;
import model.enums.Role;
import model.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersDaoImplement implements IUsersDao {
    private final Connection connection = DBConnection.getConnection();
    private static final String QUERY_ALL_USERS = "SELECT * FROM USERS";
    private static final String QUERY_INSERT_ACCOUNT_BY_ADMIN = "INSERT INTO USERS" +
            "(ACCOUNT,PASSWORD,FIRSTNAME,LASTNAME,ADDRESS,PHONE,EMAIL,BIRTHDAY,ROLE,STATUS)" +
            "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String QUERY_DEL_USERS_BY_ADMIN = "DELETE FROM USERS WHERE ID = ?";
    private static final String QUERY_UPDATE_BY_USER = "UPDATE USERS SET PASSWORD = ?,FIRSTNAME = ?,LASTNAME = ?,ADDRESS = ?,PHONE = ?,EMAIL= ?,BIRTHDAY =?" +
            "WHERE ACCOUNT = ?";
    private static final String QUERY_UPDATE_BY_ADMIN = "UPDATE USERS SET ROLE = ?,STATUS = ?" +
            "WHERE ID = ?";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM USERS WHERE ID = ?";
    private static final String QUERY_FIND_PASS_BY_ACCOUNT = "SELECT PASSWORD FROM USERS WHERE ACCOUNT = ? AND EMAIL = ?";
    private static final String QUERY_FIND_BY_USER = "SELECT ID FROM USERS WHERE ACCOUNT = ? AND PASSWORD = ?";
    @Override
    public List<Users> getAll() {
        List<Users> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_USERS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String address = rs.getString(6);
                String telephone = rs.getString(7);
                String email = rs.getString(8);
                Date birthday = rs.getDate(9);
                Role role = Role.valueOf(rs.getString(10));
                Status status = Status.valueOf(rs.getString(11));
                users.add(new Users(id, username, password, firstname, lastname, address, telephone, email, birthday, role, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean add(Users users) {
        boolean rowAdded = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_ACCOUNT_BY_ADMIN);
            statement.setString(1, users.getAccount());
            statement.setString(2, users.getPassword());
            statement.setString(3, users.getFirstName());
            statement.setString(4, users.getLastName());
            statement.setString(5, users.getAddress());
            statement.setString(6, users.getPhone());
            statement.setString(7, users.getEmail());
            statement.setDate(8, (java.sql.Date) users.getBirthDate());
            statement.setString(9, String.valueOf(users.getRole()));
            statement.setString(10, String.valueOf(users.getStatus()));
            rowAdded = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdded;
    }

    @Override
    public boolean update(int id, Users users) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_BY_ADMIN);
            statement.setString(1, String.valueOf(users.getRole()));
            statement.setString(2,String.valueOf(users.getStatus()));
            statement.setInt(3,id);
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDel = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DEL_USERS_BY_ADMIN);
            statement.setInt(1,id);
            rowDel = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDel;
    }

    @Override
    public Users findById(int id) {
        Users user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String username = rs.getString(2);
                String password = rs.getString(3);
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String address = rs.getString(6);
                String telephone = rs.getString(7);
                String email = rs.getString(8);
                Date birthday = rs.getDate(9);
                Role role = Role.valueOf(rs.getString(10));
                Status status = Status.valueOf(rs.getString(11));
                user = new Users(id,username,password,firstname,lastname,address,telephone,email,birthday,role,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user ;
    }

    @Override
    public String findPassByAccount(String account, String email) {
        String pass = "";
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_PASS_BY_ACCOUNT);
            statement.setString(1,account);
            statement.setString(2,email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String password = rs.getString(1);
                pass = password;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pass;
    }

    @Override
    public boolean updateByUser(String account,Users users) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_BY_USER);
            statement.setString(1, users.getPassword());
            statement.setString(2,users.getFirstName());
            statement.setString(3,users.getLastName());
            statement.setString(4,users.getAddress());
            statement.setString(5,users.getPhone());
            statement.setString(6,users.getEmail());
            statement.setDate(7, (java.sql.Date) users.getBirthDate());
            statement.setString(8,account);
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public int findByUser(Users users) {
        int id = -1;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BY_USER);
            statement.setString(1, users.getAccount());
            statement.setString(2, users.getPassword());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }


}
