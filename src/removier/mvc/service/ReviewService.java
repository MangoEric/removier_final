package removier.mvc.service;

import removier.mvc.dao.ReviewDAO;
import removier.mvc.dao.ReviewDAOImpl;
import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
import removier.mvc.util.ViewUtil;

import java.sql.SQLException;

public class ReviewService {
    private ReviewDAO reviewDAO = new ReviewDAOImpl();
    public User createReview(Review newReview) throws Exception {
        User result = reviewDAO.reviewInsert(newReview);
        if (result == null) {
            throw new SQLException("리뷰등록에 실패하였습니다.");
        }
        return result;
    }

    public void updateReview(Review updateReview) throws SQLException {
        int result = reviewDAO.reviewUpdate(updateReview);
        if (result == 0) {
            throw new SQLException("리뷰수정에 실패하였습니다.");
        }
    }

    public void deleteReview(User user, Movie movie) throws SQLException {
        int result = reviewDAO.reviewDelete(user, movie);
        if (result == 0) {
            throw new SQLException("삭제에 실패하였습니다.");
        }
    }
}
