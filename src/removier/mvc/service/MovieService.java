package removier.mvc.service;


import removier.mvc.dao.ActorDAO;
import removier.mvc.dao.ActorDAOImpl;
import removier.mvc.dao.MovieDAO;
import removier.mvc.dao.MovieDAOImpl;
import removier.mvc.dto.Actor;
import removier.mvc.dto.Movie;
import removier.mvc.dto.User;

import java.sql.SQLException;
import java.util.List;

public class MovieService {
    private MovieDAO movieDAO = new MovieDAOImpl();
    private ActorDAO actorDAO = new ActorDAOImpl();
    /**
     * 영화이름 검색
     * @param : 영화 제목을 인수로 받는다.
     * @return : 제목에 일치하는 Movie 를 객체로 리턴한다.
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
         * @param : actorName
         * @return : Actor 를 리턴한다.
         */
        public List<Actor> searchActorName(String actorName) throws Exception {
        	List<Actor> actors = actorDAO.movieSelectByActor(actorName);
            if (actors.size() == 0) {
                throw new Exception("해당 배우가 출현한 영화가 존재하지 않습니다.");
            } else {
                return actors;
            }
    }

    /**
     * 영화 top5 검색
     * @return : list 형태로 영화를 리턴
     * */

    public List<Movie> showTopFive() throws Exception {

        List<Movie> list = movieDAO.movieTopFive();

        return list;
    }

    /**
     * User 의 취향 저격 콘텐츠
     * @param : 로그인한 User 를 인수로 받는다
     * @return : 해당 장르에 맞는 movie 를 list 로 리턴한다.
     * */
    public List<Movie> showBestMyGenreMovie(User user) throws Exception {
        List<Movie> movies = movieDAO.showBestMyGenreMovie(user.getFavourite_genre());
        if (movies == null || movies.size() == 0) {
            throw new Exception("취향저격 영화가 존재하지 않습니다.");
        } else {
            return movies;
        }
    }
    /**
     * 영화 장르 검색
     * @param : String 으로 입력받은 영화 장르를 받는다
     * @return : list 형태로 movie 들을 리턴한다
     * */
	public List<Movie> searchMovieGenre(String movieGenre) throws Exception {
		 List<Movie> movieList = movieDAO.movieSelectByGenre(movieGenre);
		
	        if (movieList.size() == 0) {
	            throw new Exception("해당 영화 장르가 존재하지 않습니다.");
	        } else {
	     
	            return movieList;
	        }
	}

    public Movie updatedMovieInfo(Movie movie) throws Exception{
        Movie updatedMovieInfo = movieDAO.updatedMovieInfo(movie);
        if (movie == null) {
            throw new Exception("해당 영화가 존재하지 않습니다.");
        } else {
            return updatedMovieInfo;
        }
    }
}
