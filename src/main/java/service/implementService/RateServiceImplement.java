package service.implementService;

import connection.DBConnection;
import model.Rate;
import service.interfaceService.IRateService;

import java.sql.Connection;
import java.util.List;

public class RateServiceImplement implements IRateService {

    @Override
    public List<Rate> getAll() {
        return null;
    }

    @Override
    public boolean add(Rate rate) {
        return false;
    }

    @Override
    public boolean update(int id, Rate rate) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Rate findById(int id) {
        return null;
    }
}
