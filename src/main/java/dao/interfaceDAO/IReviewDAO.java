package dao.interfaceDAO;

import dao.IGeneralDAO;

import model.Review;

import java.util.List;

public interface IReviewDAO extends IGeneralDAO<Review> {
    @Override
    default boolean add(Review review){
        return false;
    };
    boolean add(Review review, int userId, int productId);
    List<Review> findListReviewById(int productId);
}
