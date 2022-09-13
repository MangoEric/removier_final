package removier.mvc.service;


import java.sql.SQLException;
import java.util.List;

import removier.mvc.dao.UserDAO;
import removier.mvc.dao.UserDAOImpl;
import removier.mvc.dto.Bookmark;
import removier.mvc.dto.Movie;
import removier.mvc.dto.User;

public class UserService {

	UserDAO userDao = new UserDAOImpl();

	/**
	 * 로그인
	 * @param : 로그인한 User 를 받는다.
	 * @return : 로그인한 User 를 리턴한다.
	 * */
    public User login(User user) throws Exception {
    	User loginUser = userDao.login(user);

        if (loginUser == null) {
            throw new IllegalAccessException("존재하지 않는 아이디입니다.");
        }

        if (!(user.getPassword().equals(loginUser.getPassword()))) {
            throw new Exception("비밀번호가 틀렸습니다");
        } else {
            return loginUser;
        }
    }
	/**
	 * 회원가입
	 * @param : 작성한 User 를 받는다.
	 * */
	public void signUp(User user) throws SQLException {
		/* if(user.getLogingId() != null) {
			throw new SQLException("중복된 아이디입니다.");
		} else */
		if(userDao.signUp(user) == 0) {
			throw new SQLException("회원 가입에 실패했습니다.");
		}
	}
	/**
	 * 로그아웃
	 * @param : 로그인한 User 를 받는다.
	 * @return : int 로 리턴한다. 0이면 로그아웃, 0이 아니면 로그아웃 실패
	 * */
	public int logout(User loginUser) throws SQLException {
    	if(userDao.logout(loginUser) != 0) {
    		throw new SQLException("로그아웃에 실패했습니다.");
    	}
    	return 0;
	}
	/**
	 * 회원 정보 수정
	 * @param : 로그인한 User 를 받는다.
	 * */
	public void updateUserInfo(User loginUser) throws SQLException {
		if(userDao.updateUserInfo(loginUser) == 0) {
			throw new SQLException("회원 정보 수정에 실패했습니다.");
		}
	}
	/**
	 * 나의 리뷰 보기
	 * @param : 로그인한 User 를 받는다.
	 * @return : 로그인한 User 를 리턴한다.
	 * */
	public User getMyReview(User user) throws Exception {
		User userInfo = userDao.getMyReview(user);
		if (userInfo.getReviews().size() == 0) {
			throw new Exception("작성하신 리뷰가 없습니다.");
		}
		return userInfo;

	}
	/**
	 * 즐겨찾기 출력
	 * @param : 로그인한 User 를 받는다.
	 * @return : 즐겨찾기에 추가된 내용을 list 로 리턴한다.
	 * */
	public List<Bookmark> selectBookmarkByUser(User loginUser) throws Exception {
		List<Bookmark> bookmarks = userDao.selectBookmarkByUser(loginUser);
		if (bookmarks.size() == 0 || bookmarks.isEmpty()) {
			throw new Exception("즐겨찾기에 추가한 영화가 없습니다.");
		}
		return bookmarks;
	}

	/**
	 * 즐겨찾기 추가
	 * @param : 로그인한 User , Movie 를 객체로 받는다.
	 * */
	public void addBookmark(User loginUser, Movie movie) throws Exception {
		if(userDao.addBookmark(loginUser, movie) == 0) {
			throw new Exception("즐겨찾기 추가에 실패했습니다.");
		}
	}

	/**
	 * 즐겨찾기 삭제
	 * @param : 로그인한 User , Movie 를 객체로 받는다.
	 * */
	public void deleteBookmark(User user, Movie movie) throws Exception {
		if(userDao.deleteBookmark(user, movie) == 0) {
			throw new Exception("즐겨찾기 취소에 실패했습니다."); 
		}
		
	}	
}

