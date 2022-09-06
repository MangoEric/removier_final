package removier.mvc.view;

import removier.mvc.dto.Movie;
import removier.mvc.dto.User;

import java.util.List;

public class EndView {
    /**
     * 회원정보 전부 출력
     * */
    public static void printUserAllList(List<User> list){

        System.out.println("-- 회원수 : "+list.size()+" 명 --");
        for(User user : list){
            System.out.println(user);
        }
        System.out.println();
    }

    public static void printMovieTopFive(List<Movie> list){

        System.out.println("┏━━━━━오늘의 Top5 영화━━━━━┓");
        for(Movie movie : list){
            System.out.println("┃ \t"+movie.getMov_title());
        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

}
