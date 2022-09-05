package removier.mvc.service;


import java.sql.SQLException;

import removier.mvc.dao.UserDAO;
import removier.mvc.dao.UserDAOImpl;
import removier.mvc.dto.User;

public class UserService {

	UserDAO userDao = new UserDAOImpl();

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

	public void signUp(User user) throws SQLException {
		/* if(user.getLogingId() != null) {
			throw new SQLException("중복된 아이디입니다.");
		} else */
		if(userDao.signUp(user) == 0) {
			throw new SQLException("회원 가입에 실패했습니다.");
		}
	}

	public int logout(User loginUser) throws SQLException {
    	if(userDao.logout(loginUser) != 0) {
    		throw new SQLException("로그아웃에 실패했습니다.");
    	}
    	
    	return 0;
	}

	public void updateUserInfo(User loginUser) throws SQLException {
		if(userDao.updateUserInfo(loginUser) == 0) {
			throw new SQLException("회원 정보 수정에 실패했습니다.");
		}
	}
}

