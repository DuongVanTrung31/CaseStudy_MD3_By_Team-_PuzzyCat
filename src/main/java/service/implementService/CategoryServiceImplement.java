package service.implementService;

import dao.implementDAO.CategoryDAOImplement;
import dao.interfaceDAO.ICategoryDAO;
import model.Category;
import service.interfaceService.ICategoryService;

import java.util.List;

public class CategoryServiceImplement implements ICategoryService {
    private final ICategoryDAO categoryDao = new CategoryDAOImplement();
    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public boolean add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public boolean update(int id, Category category) {
        return categoryDao.update(id, category);
    }

    @Override
    public boolean delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }
}
