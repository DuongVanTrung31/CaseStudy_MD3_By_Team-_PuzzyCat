package service.implementService;

import dao.interfaceDAO.IProductDAO;
import dao.implementDAO.ProductDAOImplement;
import model.Product;
import service.interfaceService.IProductService;

import java.util.List;

public class ProductServiceImplement implements IProductService {
    private final IProductDAO productDao = new ProductDAOImplement();
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean add(Product product) {
        return productDao.add(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDao.update(id, product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

}
