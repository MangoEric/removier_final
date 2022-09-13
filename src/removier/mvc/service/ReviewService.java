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

    /**
     * 리뷰 생성
     * @param : 작성된 리뷰를 받는다.
     * */
    public void createReview(Review newReview) throws Exception {
        int result = reviewDAO.reviewInsert(newReview);
        if (result == 0) {
            throw new SQLException("리뷰등록에 실패하였습니다.");
        }
    }
    /**
     * 리뷰 수정
     * @param : 수정된 리뷰를 Review 객체로 받는다.
     * */
    public void updateReview(Review updateReview) throws SQLException {
        int result = reviewDAO.reviewUpdate(updateReview);
        if (result == 0) {
            throw new SQLException("리뷰수정에 실패하였습니다.");
        }
    }
    /**
     * 리뷰 삭제
     * @param : 삭제할 계정 User 를 받고, 삭제할 영화 정보를 Movie 로 받는다.
     * */
    public void deleteReview(User user, Movie movie) throws SQLException {
        int result = reviewDAO.reviewDelete(user, movie);
        if (result == 0) {
            throw new SQLException("삭제할 리뷰가 없습니다.");
        }
    }
}
