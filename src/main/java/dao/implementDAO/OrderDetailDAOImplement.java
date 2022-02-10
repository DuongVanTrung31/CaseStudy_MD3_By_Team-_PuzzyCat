package dao.implementDAO;

import connection.DBConnection;
import dao.interfaceDAO.IOrderDetailDAO;
import model.OrderDetail;

import java.sql.Connection;
import java.util.List;

public class OrderDetailDAOImplement implements IOrderDetailDAO {
    private final Connection connection = DBConnection.getConnection();
    private static final String QUERY_INSERT_ORDER_DETAIL = "INSERT INTO order_detail(ORDER_ID,PRODUCT_ID,QUANTITY) VALUES(?,?,?)";
    private static final String QUERY_DEL_ORDER_DETAIL = "DELETE FROM order_detail WHERE PRODUCT_ID = ? AND ORDER_ID = ?";
    private static final String QUERY_GET_LIST_ORDER_BY_ID = "SELECT * FROM";


    @Override
    public List<OrderDetail> getAll() {
        return null;
    }

    @Override
    public boolean add(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean update(int id, OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public OrderDetail findById(int id) {
        return null;
    }

    @Override
    public List<OrderDetail> getOrderDetailByIdOrder(int idOrder) {
        return null;
    }
}
