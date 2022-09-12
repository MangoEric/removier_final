package removier.mvc.dao;

import removier.mvc.dto.Actor;

import java.sql.SQLException;
import java.util.List;

public interface ActorDAO {
    /**
     * 영화 배우로 검색하기
     * */
    List<Actor> movieSelectByActor(String actor_name) throws SQLException;
}
