package removier.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;

public interface MovieDAO {
    /**
	 * 영화 Top5 가져오기
	 * */
	List<Movie> movieTopFive() throws SQLException;
	
	/**
	 * 영화 제목으로 검색하기
	 * */
	Movie movieSelectByMovieTitle(String mov_title) throws SQLException;
	
	/**
	 * 영화 배우로 검색하기
	 * */
	List<Movie> movieSelectByActor(String actor_name) throws SQLException;
	
	/**
	 * 영화 장르로 검색하기
	 * */
	List<Movie> movieSelectByGenre(String mov_genre) throws SQLException;

    Movie showBestMyGenreMovie(String favourite_genre) throws SQLException;

    Movie updatedMovieInfo(Movie movie) throws Exception;
}

