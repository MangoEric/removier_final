package removier.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import removier.mvc.dto.Bookmark;
import removier.mvc.dto.Movie;
import removier.mvc.dto.User;

public interface UserDAO {
	/**
	 * 로그인하기
	 * @param : user는 id와 비밀번호만 가지고 있다.
	 * */
	User login(User user) throws SQLException;
	
	/**
	 * 회원 가입
	 * @param: user는 회원 가입 시 받은 모든 정보를 가지고 있다.
	 * */
	int signUp(User user) throws SQLException;
	
	/**
	 * 정보 수정
	 * @param : pw, 장르, 최애배우 수정한다.
	 * */ 
	int updateUserInfo(User user) throws SQLException;

	/**
	 * 로그 아웃
	 * */
	int logout(User loginUser) throws SQLException;

	User getMyReview(User user) throws Exception;
	
	/**
	 * 즐겨찾기 보기
	 * */
	List<Bookmark> selectBookmarkByUser(User loginUser) throws SQLException;
	
	/**
	 * 즐겨찾기 추가
	 * */
	int addBookmark(User loginUser, Movie movie) throws SQLException;

	/**
	 * 즐겨찾기 취소
	 * */
	int deleteBookmark(User user, Movie movie) throws SQLException;
}
