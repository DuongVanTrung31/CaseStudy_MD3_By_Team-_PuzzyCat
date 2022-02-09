package dao.implementDAO;

import connection.DBConnection;
import dao.interfaceDAO.IBrandDAO;
import model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAOImplement implements IBrandDAO {
    private final Connection connection = DBConnection.getConnection();
    private static final String QUERY_ALL_BRAND = "SELECT * FROM brand ";
    private static final String QUERY_ADD_BRAND = "INSERT INTO brand (`NAME`) VALUES (?);";
    private static final String QUERY_UPDATE_BRAND = "UPDATE brand SET `NAME` = ? WHERE `ID` = ?;";
    private static final String QUERY_DELETE_BRAND = "DELETE FROM brand WHERE (`ID` = ?);";
    private static final String QUERY_FIND_BRAND_BY_ID = "SELECT brand.NAME FROM brand WHERE id = ?;";


    @Override
    public List<Brand> getAll() {
        List<Brand> brands = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_BRAND);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                brands.add(new Brand(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }

    @Override
    public boolean add(Brand brand) {
        boolean rowAdded = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ADD_BRAND);
            statement.setString(1,brand.getName());
            rowAdded = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdded;
    }

    @Override
    public boolean update(int id, Brand brand) {
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_BRAND);
            statement.setString(1, brand.getName());
            statement.setInt(2, brand.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }


    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_BRAND);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public Brand findById(int id) {
        Brand brand = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BRAND_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString(1);
                brand = new Brand(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }
}
