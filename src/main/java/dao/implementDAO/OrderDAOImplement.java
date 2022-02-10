package dao.implementDAO;

import connection.DBConnection;
import dao.interfaceDAO.IOrderDAO;
import model.Order;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOImplement implements IOrderDAO {
    private final Connection connection = DBConnection.getConnection();
    private static final String QUERY_ALL_ORDER = "SELECT o.id,users.ACCOUNT,o.CREATE,o.DELIVERY,o.STATUS,o.ADDRESS,o.PHONE " +
            "FROM `order` o JOIN users on users.id = o.USER_ID WHERE users.role = \"USER\";";
    private static final String QUERY_INSERT_ORDER_BY_USER = "INSERT INTO `order`(USER_ID,ADDRESS,PHONE) VALUES (?,?,?)";
    private static final String QUERY_UPDATE_ORDER_BY_ADMIN = "UPDATE `order` SET DELIVERY = ?, STATUS = ? WHERE ID = ?";
    private static final String QUERY_DEL_ORDER = "DELETE FROM `order` WHERE ID = ?";
    private static final String QUERY_FIND_ORDER_BY_ID = "SELECT users.ACCOUNT,o.CREATE,o.DELIVERY,o.STATUS,o.ADDRESS,o.PHONE " +
            "FROM `order` o JOIN users on users.id = o.USER_ID WHERE o.ID = ?";

    @Override
    public List<Order> getAll() {
        List<Order> brands = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_ORDER);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String userAccount = rs.getString(2);
                LocalDateTime createDay = LocalDateTime.parse(rs.getString(3));
                LocalDateTime deliveryDay = LocalDateTime.parse(rs.getString(4));
                String status = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);
                brands.add(new Order(id,userAccount,createDay,deliveryDay,status,address,phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }

    @Override
    public boolean add(Order order,int idUser) {
        boolean rowAdd = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_ORDER_BY_USER);
            statement.setInt(1,idUser);
            statement.setString(2,order.getAddress());
            statement.setString(3,order.getPhone());
            rowAdd = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdd;
    }

    @Override
    public boolean update(int id, Order order) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_ORDER_BY_ADMIN);
            statement.setString(1, String.valueOf(order.getDelivery()));
            statement.setString(2, order.getStatus());
            statement.setInt(3, id);
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
            PreparedStatement statement = connection.prepareStatement(QUERY_DEL_ORDER);
            statement.setInt(1,id);
            rowDel = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDel;
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_ORDER_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String account = rs.getString(1);
                LocalDateTime create = LocalDateTime.parse(rs.getString(2));
                LocalDateTime delivery = LocalDateTime.parse(rs.getString(3));
                String status = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                order = new Order(account,create,delivery,status,address,phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
