package service.interfaceService;

import model.Rate;
import model.Review;
import service.IGeneralService;

import java.util.List;

public interface IReviewService extends IGeneralService<Review> {
    List<Review> findListReviewById(int productId);
    boolean add(Review review, int userId, int productId);
}
