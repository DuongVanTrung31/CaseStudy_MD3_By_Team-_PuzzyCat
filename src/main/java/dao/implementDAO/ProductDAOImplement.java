package dao.implementDAO;

import connection.DBConnection;
import dao.interfaceDAO.IProductDAO;
import model.Product;
import model.enums.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImplement implements IProductDAO {
    private final Connection connection = DBConnection.getConnection();
    private static final String QUERY_ALL_PRODUCT =
            "SELECT product.id,product.serial,product.name,category.name,brand.name,product.price,product.quantity,product.description,product.image " +
                    "FROM product JOIN category ON product.category_id = category.id JOIN brand ON product.brand_id = brand.id " +
                    "WHERE product.status = \"ACTIVE\";";
    private static final String QUERY_INSERT_PRODUCT =
            "INSERT INTO product" +
                    "(serial,name,category_id,brand_id,price,quantity,description,image)" +
                    "VALUES (?,?,?,?,?,?,?,?)";
    private static final String QUERY_FIND_BY_ID =
            "SELECT product.serial,product.name,category.name,brand.name,product.price,product.quantity,product.description,product.image,product.create,product.status " +
                    "FROM product JOIN category ON product.category_id = category.id JOIN brand ON product.brand_id = brand.id " +
                    "WHERE product.id = ?;";
    private static final String QUERY_DEL_PRODUCT = "UPDATE product SET STATUS = \"BLOCKED\" WHERE id = ?";
    private static final String QUERY_UPDATE_PRODUCT = "UPDATE product SET SERIAL = ?,NAME = ?,CATEGORY_ID = ?,BRAND_ID = ?,PRICE = ?,QUANTITY = ?,DESCRIPTION = ?,IMAGE = ? WHERE ID = ?;";
    private static final String QUERY_FIND_BY_KEYWORD = "SELECT product.id,product.serial,product.name,category.name,brand.name,product.price,product.quantity,product.description,product.image FROM product JOIN category ON product.category_id = category.id JOIN brand ON product.brand_id = brand.id WHERE (category.name LIKE ? or product.name LIKE ? or brand.name LIKE ?) AND product.STATUS = \"active\";";
    private static final String QUERY_FILTER_BY_CATE_PRICE_BRAND = "SELECT product.id,product.serial,product.name,category.name,brand.name,product.price,product.quantity,product.description,product.image\n" +
            "FROM product JOIN category ON product.category_id = category.id JOIN brand ON product.brand_id = brand.id WHERE category.NAME LIKE ? and (product.PRICE BETWEEN ? and ? )and brand.NAME LIKE ? AND product.status = \"ACTIVE\";";
    private static final String QUERY_REDUCE_PRODCUT = "UPDATE product SET QUANITY = ? WHERE ID = ?";

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(QUERY_ALL_PRODUCT);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String serial = rs.getString(2);
                String name = rs.getString(3);
                String category = rs.getString(4);
                String brand = rs.getString(5);
                double price = rs.getDouble(6);
                int quantity = rs.getInt(7);
                String description = rs.getString(8);
                String imageURL = rs.getString(9);
                products.add(new Product(id, serial, name, category, brand, price, quantity, description, imageURL));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }


    @Override
    public boolean update(int id, Product product, int categoryID, int brandID) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_PRODUCT);
            statement.setString(1, product.getSerial());
            statement.setString(2, product.getName());
            statement.setInt(3, categoryID);
            statement.setInt(4, brandID);
            statement.setDouble(5, product.getPrice());
            statement.setInt(6, product.getQuantity());
            statement.setString(7, product.getDescription());
            statement.setString(8, product.getImg());
            statement.setInt(9, id);
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDel = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DEL_PRODUCT);
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDel;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String serial = rs.getString(1);
                String name = rs.getString(2);
                String category = rs.getString(3);
                String brand = rs.getString(4);
                double price = rs.getDouble(5);
                int quantity = rs.getInt(6);
                String description = rs.getString(7);
                String imageURL = rs.getString(8);
                Timestamp create = Timestamp.valueOf(rs.getString(9));
                Status status = Status.valueOf(rs.getString(10));
                product = new Product(id, serial, name, category, brand, price, quantity, description, imageURL, create, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByKeyword(String keyword) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BY_KEYWORD);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String serial = rs.getString(2);
                String name = rs.getString(3);
                String category = rs.getString(4);
                String brand = rs.getString(5);
                double price = rs.getDouble(6);
                int quantity = rs.getInt(7);
                String description = rs.getString(8);
                String imageURL = rs.getString(9);
                products.add(new Product(id, serial, name, category, brand, price, quantity, description, imageURL));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean add(Product product, int idCategory, int idBrand) {
        boolean rowAdd = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_PRODUCT);
            statement.setString(1, product.getSerial());
            statement.setString(2, product.getName());
            statement.setInt(3, idCategory);
            statement.setInt(4, idBrand);
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
    public List<Product> filter(String categoryName, double priceLow, double priceHigh, String brandName) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FILTER_BY_CATE_PRICE_BRAND);
            statement.setString(1, categoryName);
            statement.setDouble(2, priceLow);
            statement.setDouble(3, priceHigh);
            statement.setString(4, brandName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String serial = rs.getString(2);
                String name = rs.getString(3);
                String category = rs.getString(4);
                String brand = rs.getString(5);
                double price = rs.getDouble(6);
                int quantity = rs.getInt(7);
                String description = rs.getString(8);
                String imageURL = rs.getString(9);
                products.add(new Product(id, serial, name, category, brand, price, quantity, description, imageURL));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean reduce(int quantity, int idProduct) {
        boolean reduceRow = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_REDUCE_PRODCUT);
            statement.setInt(1, quantity);
            statement.setInt(2, idProduct);
            reduceRow = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reduceRow;
    }
}
