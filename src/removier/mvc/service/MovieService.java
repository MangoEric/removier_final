package removier.mvc.service;


import removier.mvc.dao.MovieDAO;
import removier.mvc.dao.MovieDAOImpl;
import removier.mvc.dto.Actor;
import removier.mvc.dto.Movie;
import removier.mvc.dto.User;

import java.sql.SQLException;
import java.util.List;

public class MovieService {
    private MovieDAO movieDAO = new MovieDAOImpl();
    /**
     * 영화이름 검색
     * @param movieTitle
     */
    public Movie searchMovieTitle(String movieTitle) throws Exception {
        Movie movie = movieDAO.movieSelectByMovieTitle(movieTitle);
        if (movie == null) {
            throw new Exception("해당 영화가 존재하지 않습니다.");
        } else {
            return movie;
        }
    }
//        return Movie.getFixture();
        /**
         * 배우이름 검색
         * @param actorName
         */
        public List<Movie> searchActorName(String actorName) throws Exception {
        	List<Movie> actor = movieDAO.movieSelectByActor(actorName);
            if (actor == null) {
                throw new Exception("해당 배우가 존재하지 않습니다.");
            } else {
                return actor;
            }
    }

    /**
     * 영화 top5 검색
     * */

    public List<Movie> showTopFive() throws Exception {

        List<Movie> list = movieDAO.movieTopFive();

        return list;
    }


    public Movie showBestMyGenreMovie(User user) throws Exception {
        Movie movie = movieDAO.showBestMyGenreMovie(user.getFavourite_genre());
        if (movie == null) {
            throw new Exception("해당 영화가 존재하지 않습니다.");
        } else {
            return movie;
        }
    }
    /*
     * 영화 장르 검색
     * */
	public List<Movie> searchMovieGenre(String movieGenre) throws Exception {
		 List<Movie> movieList = movieDAO.movieSelectByGenre(movieGenre);
		
	        if (movieList.size() == 0) {
	            throw new Exception("해당 영화 장르가 존재하지 않습니다.");
	        } else {
	     
	            return movieList;
	        }
	}
}
