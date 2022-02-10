package service.implementService;

import dao.implementDAO.OrderDAOImplement;
import dao.interfaceDAO.IOrderDAO;
import model.Order;
import service.interfaceService.IOrderService;

import java.util.List;

public class OrderServiceImplement implements IOrderService {
    private final IOrderDAO iOrderDAO = new OrderDAOImplement();
    @Override
    public List<Order> getAll() {
        return iOrderDAO.getAll();
    }

    @Override
    public boolean add(Order order) {
        return false;
    }

    @Override
    public boolean update(int id, Order order) {
        return iOrderDAO.update(id, order);
    }

    @Override
    public boolean delete(int id) {
        return iOrderDAO.delete(id);
    }

    @Override
    public Order findById(int id) {
        return iOrderDAO.findById(id);
    }

    @Override
    public boolean add(Order order, int idUser) {
        return iOrderDAO.add(order,idUser);
    }
}
