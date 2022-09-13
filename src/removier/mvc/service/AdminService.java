package removier.mvc.service;

import removier.mvc.dao.AdminDAO;
import removier.mvc.dao.AdminDAOImpl;
import removier.mvc.dto.Admin;
import removier.mvc.dto.User;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    AdminDAO adminDAO = new AdminDAOImpl();

    static AdminService adminService = new AdminService();
    /***
     * 관리자 로그인
     * @param : admin 을 전달 받는다.
     * @return : 로그인된 Admin 을 리턴
     */
    public Admin adminLogin(Admin admin) throws Exception{
        Admin admin1 = adminDAO.login(admin);
        if(admin1==null){
            throw new Exception();
        }
        return admin1;
    }
    /**
     * 전체 회원 정보 조회
     * @return : 회원정보를 모두 list 로 전달
     * */
    public List<User> userSelectAll() throws SQLException {
        List<User> list = adminDAO.userSelectAll();
        if(list.size()==0) throw new SQLException("회원이 없습니당.");
        return list;
    }
}
