package service.interfaceService;

import model.Order;
import service.IGeneralService;

public interface IOrderService extends IGeneralService<Order> {
    boolean add(Order order, int idUser);
}
