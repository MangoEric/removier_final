package removier.mvc.dao;

import removier.mvc.dto.Actor;
import removier.mvc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAOImpl implements ActorDAO{

    public List<Actor> movieSelectByActor(String actor_name) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Actor> actors = new ArrayList<>();
        String sql = "SELECT * FROM actor_api WHERE actor_name = ?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, actor_name);

            rs = ps.executeQuery();

            while (rs.next()) {
                Actor actor = new Actor(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                actors.add(actor);
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }
        return actors;
    }

}
