package removier.mvc.controller;

import java.util.List;


import removier.mvc.dto.Actor;
import removier.mvc.dto.Movie;
import removier.mvc.dto.User;
import removier.mvc.service.MovieService;
import removier.mvc.util.ViewUtil;
import removier.mvc.view.SuccessView;
import removier.mvc.view.SearchMovieView;

public class MovieController {
    private static MovieService movieService = new MovieService();


    /**
     * 영화 Top5 가져오기
     */
    public static void movieTopFive() {
        try {
            List<Movie> list = movieService.showTopFive();
            SuccessView.printMovieTopFive(list);
        }catch (Exception e) {

        }

    }

    /**
     * 영화 제목으로 검색하기
     */
    public static void movieSelectByMovieTitle(String movieName) {
        try {
            Movie movie = movieService.searchMovieTitle(movieName);
            SearchMovieView.movieResult(UserController.getLoginUser(), movie);
        } catch (Exception e) {
            ViewUtil.printMessage(e.getMessage());
        }
    }

    /**
     * 영화 배우로 검색하기
     */
    public static void movieSelectByActor(String actorName) {
    	try {
            List<Actor> actors = movieService.searchActorName(actorName);

            SuccessView.printMovieOfActor(actors);
            
        } catch (Exception e) {
            ViewUtil.printMessage(e.getMessage());
        }
    }

    /**
     * 영화 장르로 검색하기
     */
    public static void movieSelectByGenre(String movieGenre) {
    	 try {
    		 List<Movie> movie = movieService.searchMovieGenre(movieGenre);
             SuccessView.printMovieGenre(movie);
             
         } catch (Exception e) {
             ViewUtil.printMessage(e.getMessage());
         }
    }


    public static void showBestMyGenreMovie(User user) {
        try {
            List<Movie> movies = movieService.showBestMyGenreMovie(user);
            // todo : 뷰 바꿔야됨
            SearchMovieView.showBestMyGenreMovie(UserController.getLoginUser());
            SuccessView.printFavoriteMovie(movies);
        } catch (Exception e) {
            ViewUtil.printMessage(e.getMessage());
        }
    }

    public static Movie updatedMovieInfo(Movie movie) {
        Movie updatedMovieInfo = null;
        try {
            updatedMovieInfo = movieService.updatedMovieInfo(movie);
        } catch (Exception e) {
            ViewUtil.printMessage(e.getMessage());
        }
        return updatedMovieInfo;
    }


}
