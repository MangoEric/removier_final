package removier.mvc.controller;

import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
import removier.mvc.service.ReviewService;
import removier.mvc.util.ViewUtil;

import java.sql.SQLException;

public class ReviewController {
    private static ReviewService reviewService = new ReviewService();


    /**
     * 리뷰 생성
     * */
    public static void createReview(Review newReview) {
        try {
            reviewService.createReview(newReview);
        } catch (Exception e) {
            ViewUtil.errorMessage(e.getMessage());
        }
    }

    /**
     * 리뷰 수정
     * */
    public static void updateReview(Review updateReview) {
        try {
            reviewService.updateReview(updateReview);
        } catch (SQLException e) {
            ViewUtil.errorMessage(e.getMessage());
        }
    }

    /**
     * 리뷰 삭제
     * */
    public static void deleteReview(User user, Movie movie) {
        try {
            reviewService.deleteReview(user, movie);
            ViewUtil.printMessage("삭제가 완료되었습니다.");
        } catch (SQLException e) {
            ViewUtil.errorMessage(e.getMessage());
        }

    }

}
