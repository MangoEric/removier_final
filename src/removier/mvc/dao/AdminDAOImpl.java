package removier.mvc.dao;

import removier.mvc.dto.Admin;
import removier.mvc.dto.User;
import removier.mvc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO{

    @Override
    public Admin login(Admin admin) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Admin admin1 = null;
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement("select * from admininfo where admin_id=? and admin_pw=?");
            ps.setString(1, admin.getLogingId());
            ps.setString(2, admin.getPassword());

            rs = ps.executeQuery();

            if (rs.next()) {
                admin1 = new Admin(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }
        return admin1;
    }

    @Override
    public List<User> userSelectAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<User> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            ps= con.prepareStatement("select * from removier_USER");
            rs = ps.executeQuery();


            while(rs.next()) {
                User user  = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                                    rs.getString(4), rs.getInt(5), rs.getString(6),
                                    rs.getString(7), rs.getString(8));
                list.add(user);
            }
        }finally {
            DBUtil.close(con, ps, rs);
        }
        return list;
    }
}
