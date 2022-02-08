package dao.impl;

import connection.DBConnection;
import dao.IProductDao;
import model.Product;
import model.enums.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplement implements IProductDao {
    private final Connection connection = DBConnection.getConnection();
    private static final String QUERY_ALL_PRODUCT = "SELECT product.serial,product.name,category.name,brand.name,product.price,product.quantity,product.description,product.image FROM product JOIN category ON product.category_id = category.id JOIN brand ON product.brand_id = brand.id;";
    private static final String QUERY_INSERT_PRODUCT = "INSERT INTO product" +
            "(serial,p_name,p_category_id,p_brand_id,p_price,p_quantity,p_description,p_image)" +
            "VALUES (?,?,?,?,?,?,?,?)";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM product WHERE p_id = ?";

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(QUERY_ALL_PRODUCT);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String serial = rs.getString(1);
                String name = rs.getString(2);
                String category = rs.getString(3);
                String brand = rs.getString(4);
                double price = rs.getDouble(5);
                int quantity = rs.getInt(6);
                String description = rs.getString(7);
                String imageURL = rs.getString(8);
                products.add(new Product(serial, name, category, brand, price, quantity,description,imageURL));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public boolean add(Product product) {
        boolean rowAdd = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_PRODUCT);
            statement.setString(1, product.getSerial());
            statement.setString(2, product.getName());
//            statement.setInt(3, product.getCategoryId());
//            statement.setInt(4, product.getBrandId());
            statement.setDouble(5, product.getPrice());
            statement.setInt(6, product.getQuantity());
            statement.setString(7, product.getDescription());
            statement.setString(8, product.getImg());
            rowAdd = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdd;
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

    @Override
    public List<Product> findByName(String keyword) {
        return null;
    }

}