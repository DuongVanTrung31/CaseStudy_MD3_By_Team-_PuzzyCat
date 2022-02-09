package service.implementService;

import dao.implementDAO.BrandDAOImplement;
import dao.interfaceDAO.IBrandDAO;
import model.Brand;
import service.interfaceService.IBrandService;

import java.util.List;

public class BrandServiceImplement implements IBrandService {
    private final IBrandDAO brandDAO =  new BrandDAOImplement();
    @Override
    public List<Brand> getAll() {
        return brandDAO.getAll();
    }

    @Override
    public boolean add(Brand brand) {
        return brandDAO.add(brand);
    }

    @Override
    public boolean update(int id, Brand brand) {
        return brandDAO.update(id,brand);
    }

    @Override
    public boolean delete(int id) {
        return brandDAO.delete(id);
    }

    @Override
    public Brand findById(int id) {
        return brandDAO.findById(id);
    }
}
