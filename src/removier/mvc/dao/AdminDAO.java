package removier.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import removier.mvc.dto.Admin;
import removier.mvc.dto.User;

public interface AdminDAO {
	/**
	 * 로그인하기 - jong
	 * */
	Admin login(Admin admin) throws SQLException;

	List<User> userSelectAll() throws SQLException;
}
