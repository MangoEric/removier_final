package removier.mvc.dao;

import java.sql.SQLException;

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
	//User signUp(User user) throws SQLException;
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
}
