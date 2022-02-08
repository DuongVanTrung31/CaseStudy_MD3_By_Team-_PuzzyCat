package service.impl;

import dao.IProductDao;
import dao.impl.ProductDaoImplement;
import model.Product;
import service.IProductService;

import java.util.List;

public class ProducServiceImplement implements IProductService {
    private final IProductDao productDao = new ProductDaoImplement();
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean add(Product product) {
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

}
