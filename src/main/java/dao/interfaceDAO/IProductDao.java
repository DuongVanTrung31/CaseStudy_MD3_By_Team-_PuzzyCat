package dao.interfaceDAO;

import dao.IGeneralDao;
import model.Product;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<Product> findByName(String keyword);
}
