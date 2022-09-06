package removier.mvc.dao;

import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;

import java.sql.SQLException;

public interface ReviewDAO {

    /**
     * 리뷰 등록하기
     * */
    User reviewInsert(Review review) throws SQLException;

    /**
     * 리뷰 수정하기
     * */
    int reviewUpdate(Review review) throws SQLException;

    /**
     * 리뷰 삭제하기
     * */
    int reviewDelete(User user, Movie movie) throws SQLException;
}
