package removier.mvc.dao;

import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
import removier.mvc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReviewDAOImpl implements ReviewDAO {
    @Override
    public int reviewInsert(Review review) throws SQLException {
        // int review_pk, int review_stars, String review_content, User user, Movie movie
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "insert into review values (review_id_seq.nextval, ?, ?, ?, ?, ?)";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, review.getReview_stars());
            ps.setString(2, review.getReview_content());
            ps.setInt(3, review.getUser().getMember_pk());
            ps.setString(4, review.getUser().getLogingId());
            ps.setInt(5, review.getMovie().getMovie_pk());

            result = ps.executeUpdate();

        } finally {
            DBUtil.close(con, ps, null);
        }
        return result;
    }

    @Override
    public int reviewUpdate(Review updateReview) throws SQLException {
        // int review_pk, int review_stars, String review_content, User user, Movie movie
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "update review set review_stars = ?, review_content = ? where user_id = " + updateReview.getUser_id() + " and movie_id = " + updateReview.getMovie_id();

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, updateReview.getReview_stars());
            ps.setString(2, updateReview.getReview_content());

            result = ps.executeUpdate();

        } finally {
            DBUtil.close(con, ps, null);
        }
        return result;
    }

    @Override
    public int reviewDelete(User user, Movie movie) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "delete from review where movie_id = ? and user_id = ?";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, movie.getMovie_pk());
            ps.setInt(2, user.getMember_pk());
            result = ps.executeUpdate();

        } finally {
            DBUtil.close(con, ps, null);
        }
        return result;
    }
}

