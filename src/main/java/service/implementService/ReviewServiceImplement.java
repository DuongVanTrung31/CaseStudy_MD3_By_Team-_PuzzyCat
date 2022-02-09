package service.implementService;

import dao.implementDAO.ReviewDAOImplement;
import dao.interfaceDAO.IReviewDAO;
import model.Rate;
import model.Review;
import service.interfaceService.IReviewService;

import java.util.List;

public class ReviewServiceImplement implements IReviewService {
    private final IReviewDAO reviewDAO = new ReviewDAOImplement();
    @Override
    public List<Review> getAll() {
        return reviewDAO.getAll();
    }

    @Override
    public boolean add(Review review) {
        return false;
    }

    @Override
    public boolean update(int id, Review review) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return reviewDAO.delete(id);
    }

    @Override
    public Review findById(int id) {
        return null;
    }

    @Override
    public List<Review> findListReviewById(int productId) {
        return reviewDAO.findListReviewById(productId);
    }

    @Override
    public boolean add(Review review, int userId, int productId) {
        return reviewDAO.add(review,userId,productId);
    }
}
