package removier.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import removier.mvc.dto.Bookmark;
import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
import removier.mvc.util.DBUtil;



public class UserDAOImpl implements UserDAO {

    @Override
    public User login(User user) throws SQLException { //user는 id, password 담고 있다.
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User userInfo = null;
        String sql = "select * from removier_user where login_id = ?";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getLogingId());

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String loginId = rs.getString(3);
                String password = rs.getString(4);
                int role = rs.getInt(5);
                String phone = rs.getString(6);
                String favoriteGenre = rs.getString(7);
                String favoriteActor = rs.getString(8);

                userInfo = new User(id, name, loginId, password, role, phone, favoriteGenre, favoriteActor);
                List<Review> reviews = getReviews(userInfo);
                userInfo.setReviews(reviews);
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }
        return userInfo; //
    }

    private List<Review> getReviews(User userInfo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Review> reviews = new ArrayList<>();
        String sql = "select * from review where user_id = ?";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userInfo.getMember_pk());

            rs = ps.executeQuery();
            while (rs.next()) {
                Review review = new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                reviews.add(review);
            }

        } finally {
            DBUtil.close(null, ps, rs);
        }
        return reviews;
    }


	@Override
	public int signUp(User user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into removier_user values (USER_ID_SEQ.nextval, ?, ?, ?, 1, ?, ?, ?)");
			ps.setString(1, user.getMember_name());
			ps.setString(2, user.getLogingId());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getFavourite_genre());
			ps.setString(6, user.getFavourite_actor());
			
			result = ps.executeUpdate();			
		} finally {
			DBUtil.close(con, ps, null);
		}
		
		return result;
	}

	@Override
	public int updateUserInfo(User loginUser) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update removier_user set password=?, name=?, favourite_actor=?, favourite_genre=?, phone=? where id=?");
			ps.setString(1, loginUser.getPassword());
			ps.setString(2, loginUser.getMember_name());
			ps.setString(3, loginUser.getFavourite_actor());
			ps.setString(4, loginUser.getFavourite_genre());
			ps.setString(5, loginUser.getPhone());
			ps.setInt(6, loginUser.getMember_pk());
			
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.close(con, ps, null);
		}
		
		return result;
	}


	@Override
	public int logout(User loginUser) throws SQLException {
		return 0;
	}


	@Override
	public List<Bookmark> selectBookmarkByUser(User loginUser) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Bookmark> bookmarks = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from bookmark where login_id = ?");
			ps.setInt(1, loginUser.getMember_pk());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Bookmark bm = new Bookmark(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));	
				bookmarks.add(bm);
			}
			
		} finally {
			DBUtil.close(con, ps, rs);
		}
		
		return bookmarks;
	}	

    @Override
    public User getMyReview(User user) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User userInfo = null;
        String sql = "select * from removier_user where login_id = ?";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getLogingId());

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String loginId = rs.getString(3);
                String password = rs.getString(4);
                int role = rs.getInt(5);
                String phone = rs.getString(6);
                String favoriteGenre = rs.getString(7);
                String favoriteActor = rs.getString(8);

                userInfo = new User(id, name, loginId, password, role, phone, favoriteGenre, favoriteActor);
                List<Review> reviews = getReviews(userInfo);
                userInfo.setReviews(reviews);
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }
        return userInfo;
    }

	@Override
	public int addBookmark(User loginUser, Movie movie) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into bookmark values(bookmark_id_seq.nextval, ?, ?, ?)");
			ps.setString(1, movie.getMov_title());
			ps.setInt(2, movie.getMovie_pk());
			ps.setInt(3, loginUser.getMember_pk());
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.close(con, ps, null);
		}
		return result;
	}

	@Override
	public int deleteBookmark(User user, Movie movie) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("DELETE FROM bookmark WHERE MOVIE_ID =? AND LOGIN_ID =?");
			ps.setInt(1, movie.getMovie_pk());
			ps.setInt(2, user.getMember_pk());
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.close(con, ps, null);
		}
		return result;
	}

}
