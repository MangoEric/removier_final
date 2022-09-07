package removier.mvc.view;

import removier.mvc.dto.Movie;
import removier.mvc.dto.User;
import removier.mvc.util.ViewUtil;

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
    
    public static void printMovieGenre(List<Movie> movies) {
    	for (Movie movie : movies) {
    		ViewUtil.printMessage(" ▥영화명   : " + movie.getMov_title());    		
    		ViewUtil.printMessage(" ▥영화감독 : " + movie.getMov_director());
    		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    		
    	}
    	
    }
}
