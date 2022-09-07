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
        System.out.println();
        System.out.println("---- 총 회원수 : "+list.size()+" 명 --------------------------------------------------------------------");
        System.out.println("[회원번호]"+String.format("%10s","[회원명]")+String.format("%10s","[아이디]")+
                String.format("%10s","[비밀번호]")+String.format("%12s","[핸드폰번호]")+String.format("%13s","[최애장르]")+String.format("%10s","[최애배우]"));
        for(User user : list){
            System.out.println("\t"+user.getMember_pk()+"\t  "+String.format("%7s",user.getMember_name())+String.format("%10s",user.getLogingId())+
                    String.format("%10s",user.getPassword())+String.format("%20s",user.getPhone())
            +String.format("%10s",user.getFavourite_genre())+String.format("%10s",user.getFavourite_actor()));

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
    public static void printMovieOfActor(List<Movie> movies) {
    	for (Movie movie : movies) {
    		ViewUtil.printMessage(" ▥영화명   : " + movie.getMov_title());
    		ViewUtil.printMessage(" ▥영화감독 : " + movie.getMov_director());
    		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━");

    	}

    }


    public static void printMovieTopFive(List<Movie> list){

        System.out.println("┏━━━━━오늘의 Top5 영화━━━━━┓");
        for(Movie movie : list){
            System.out.println("┃ \t"+movie.getMov_title());
        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛");
    }


    public static void printMovieInfo(Movie movie) {
        ViewUtil.printMessage("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
                              "  ▒  영화정보 \n" +
                              " [영화제목] : " + movie.getMov_title()+"\n"+
                              " [장르] : "+ movie.getMov_genre()+"\n"+
                              " [감독] : "+ movie.getMov_director()+"\n"+
                              " [배우] : "+ movie.getActor_name1()+", "+ movie.getActor_name2()+","+ movie.getActor_name3()+", "+movie.getActor_name4()+"\n"+
                              " [줄거리] \n"+ movie.getMov_plot()+"\n"+

                              "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");


    }
}
