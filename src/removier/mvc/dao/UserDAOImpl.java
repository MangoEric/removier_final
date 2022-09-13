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

	/**
	 * 로그인 기능
	 * @param : 입력받은 User 를 인수로 받느다
	 * @return : 로그인한 User 를 리턴한다.
	 * */
    @Override
    public User login(User user) throws SQLException { //user는 id, password 담고 있다.
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User userInfo = null;
        String sql = "select * from removier_api_user where login_id = ?";
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

	/**
	 * 리뷰 조회
	 * @param : 입력받은 User 를 인수로 받느다
	 * @return : 리뷰를 list 로 리턴한다.
	 * */
    private List<Review> getReviews(User userInfo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Review> reviews = new ArrayList<>();
        String sql = "select * from review_api where user_id = ?";
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
            DBUtil.close(con, ps, rs);
        }
        return reviews;
    }

	/**
	 * 회원가입
	 * @param : 입력받은 User 를 인수로 받느다
	 * @return : int 로 회원가입 여부를 출력
	 * */
	@Override
	public int signUp(User user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into removier_api_user values (USER_api_ID_SEQ.nextval, ?, ?, ?, 1, ?, ?, ?)");
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

	/**
	 * 회원정보 수정
	 * @param : 로그인 받은 User 를 받아온다
	 * @return : int 로 성공 여부를 리턴한다.
	 * */
	@Override
	public int updateUserInfo(User loginUser) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update removier_api_user set password=?, name=?, favourite_actor=?, favourite_genre=?, phone=? where id=?");
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

	/**
	 * 로그아웃
	 * */
	@Override
	public int logout(User loginUser) throws SQLException {
		return 0;
	}


	/**
	 * 즐겨찾기 조회
	 * @param : 로그인한 User 를 받아온다
	 * @return : 즐겨찾기 를 list 로 리턴한다.
	 * */
	@Override
	public List<Bookmark> selectBookmarkByUser(User loginUser) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Bookmark> bookmarks = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from bookmark_api where login_id = ?");
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

	/**
	 * 나의 리뷰 조회
	 * @param : 로그인한 User 를 받아온다
	 * */
    @Override
    public User getMyReview(User user) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User userInfo = null;
        String sql = "select * from removier_api_user where login_id = ?";
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


	/**
	 * 즐겨찾기 추가
	 * @param : 로그인 한 User 와 즐겨찾기에 추가할 Movie 를 받는다.
	 * @return : int 로 성공여부 리턴
	 * */
	@Override
	public int addBookmark(User loginUser, Movie movie) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into bookmark_api values(bookmark_api_id_seq.nextval, ?, ?, ?)");
			ps.setString(1, movie.getMov_title());
			ps.setInt(2, movie.getMovie_pk());
			ps.setInt(3, loginUser.getMember_pk());
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.close(con, ps, null);
		}
		return result;
	}

	/**
	 * 즐겨찾기 삭제
	 * @param : 로그인한 User 와 삭제할 Movie 를 객체로 받는다
	 * @return : 삭제 성공 여부를 int 로 리턴한다.
	 * */
	@Override
	public int deleteBookmark(User user, Movie movie) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("DELETE FROM bookmark_api WHERE MOVIE_ID =? AND LOGIN_ID =?");
			ps.setInt(1, movie.getMovie_pk());
			ps.setInt(2, user.getMember_pk());
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.close(con, ps, null);
		}
		return result;
	}

}
