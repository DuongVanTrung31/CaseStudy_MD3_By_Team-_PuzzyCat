package dao.interfaceDAO;

import dao.IGeneralDAO;
import model.OrderDetail;

import java.util.List;

public interface IOrderDetailDAO extends IGeneralDAO<OrderDetail> {
    List<OrderDetail> getOrderDetailByIdOrder(int idOrder);
}
