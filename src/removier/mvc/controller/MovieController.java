package removier.mvc.controller;

import removier.mvc.dto.Movie;
import removier.mvc.dto.User;
import removier.mvc.service.MovieService;
import removier.mvc.util.ViewUtil;
import removier.mvc.view.EndView;
import removier.mvc.view.SearchMovieView;

import java.sql.PreparedStatement;
import java.util.List;

public class MovieController {
    private static MovieService movieService = new MovieService();


    /**
     * 영화 Top5 가져오기
     */
    public static void movieTopFive() {
        try {
            List<Movie> list = movieService.showTopFive();
            EndView.printMovieTopFive(list);
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
    public static void movieSelectByActor() {
    }

    /**
     * 영화 장르로 검색하기
     */
    public static void movieSelectByGenre() {
    }

    /**
     * 리뷰 등록하기
     */
    public static void reviewInsert() {
    }

    /**
     * 리뷰 수정하기
     */
    public static void reviewUpdate() {
    }

    /**
     * 리뷰 삭제하기
     */
    public static void reviewDelete() {
    }

    public static void showBestMyGenreMovie(User user) {
        try {
            Movie movie = movieService.showBestMyGenreMovie(user);
            SearchMovieView.movieResult(UserController.getLoginUser(), movie);
        } catch (Exception e) {
            ViewUtil.printMessage(e.getMessage());
        }
    }

    /**
     * 영화이름 검색하기
     *
     * @param movieName
     */

}
