package removier.mvc.controller;

import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
import removier.mvc.service.ReviewService;
import removier.mvc.util.ViewUtil;

import java.sql.SQLException;

public class ReviewController {
    private static ReviewService reviewService = new ReviewService();

    public static User createReview(Review newReview) {
        User user = null;
        try {
            user = reviewService.createReview(newReview);
        } catch (Exception e) {
            ViewUtil.errorMessage(e.getMessage());
        }
        return user;
    }

    public static void updateReview(Review updateReview) {
        try {
            reviewService.updateReview(updateReview);
        } catch (SQLException e) {
            ViewUtil.errorMessage(e.getMessage());
        }
    }

    public static void deleteReview(User user, Movie movie) {
        try {
            reviewService.deleteReview(user, movie);
            ViewUtil.printMessage("삭제가 완료되었습니다.");
        } catch (SQLException e) {
            ViewUtil.errorMessage(e.getMessage());
        }
    }

}
