package dao.implementDAO;

import connection.DBConnection;
import dao.interfaceDAO.IReviewDAO;
import model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImplement implements IReviewDAO {
    private final Connection connection = DBConnection.getConnection();
    private static final String QUERY_ALL_REVIEWS = "SELECT product.ID , users.ACCOUNT, review.COMMENT" +
            "FROM ((review JOIN product ON review.product_id = product.id) JOIN users ON users.id = review.user_id);";
    private static final String QUERY_INSERT_REVIEW = "INSERT INTO review (`PRODUCT_ID`, `USER_ID`, `COMMENT`) " + "VALUES (?,?,?);";
    private static final String QUERY_DELETE_REVIEW = "DELETE FROM review WHERE (`ID` = ?);";
    private static final String QUERY_FIND_REVIEW_PRODUCT_BY_ID = "SELECT users.ACCOUNT, review.COMMENT " +
            "FROM review JOIN product ON review.product_id = product.id JOIN users ON users.id = review.user_id " +
            "WHERE product.id = ?;";


    @Override
    public List<Review> getAll() {
        List<Review> reviews = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_REVIEWS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String comment = rs.getString(3);
                reviews.add(new Review(id, account, comment));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public boolean add(Review review, int userId, int productId) {
        boolean rowAdded = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_REVIEW);
            statement.setInt(1, productId);
            statement.setInt(2, userId);
            statement.setString(3, review.getComment());
            rowAdded = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdded;
    }
    // tìm tất cả review của sản phẩm theo productID
    @Override
    public List<Review> findListReviewById(int productId) {
        List<Review> reviews = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_REVIEW_PRODUCT_BY_ID);
            statement.setInt(1, productId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String userAccount = rs.getString(1);
                String comment = rs.getString(2);
                reviews.add(new Review(productId, userAccount,comment));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }
    // xóa commt bởi commentID
    @Override
    public boolean delete(int commentId) {
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_REVIEW);
            statement.setInt(1, commentId);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public Review findById(int id) {
        return null;
    }
    @Override
    public boolean update(int id, Review review) {
        return false;
    }
}
