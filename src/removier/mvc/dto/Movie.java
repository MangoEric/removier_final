package removier.mvc.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 영화 정보
 * */
public class Movie {
    private int movie_pk; // 영화아이디 PK
    private String mov_title; //영화 제목
    private String mov_genre; //영화 장르
    private String mov_plot; //영화 줄거리
    private String mov_date; //영화 개봉일
    private String mov_director; // 영화 감독

    private String actor_name1; //주연배우 이름1
    private String actor_name3; //주연배우 이름3
    private String actor_name4; //주연배우 이름4
    private String actor_name2; //주연배우 이름2

    /**
     * 주연배우 4명을 List로 가져온다.
     */
//    List<Actor> actorList = new ArrayList<>();

    /**
     * 영화 리뷰를 list 로 가져온다.
     * */
    private List<Review> reviewList = new ArrayList<Review>();

    public Movie() {
    }

    public Movie(int movie_pk, String mov_title, String mov_genre, String mov_plot, String mov_date, String mov_director, String actor_name1, String actor_name3, String actor_name4, String actor_name2, List<Review> reviewList) {
        this(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director, actor_name1, actor_name2, actor_name3, actor_name4);
        this.reviewList = reviewList;
    }

    public Movie(int movie_pk, String mov_title, String mov_genre, String mov_plot, String mov_date, String mov_director, String actor_name1, String actor_name2, String actor_name3, String actor_name4) {
        this.movie_pk = movie_pk;
        this.mov_title = mov_title;
        this.mov_genre = mov_genre;
        this.mov_plot = mov_plot;
        this.mov_date = mov_date;
        this.mov_director = mov_director;
        this.actor_name1 = actor_name1;
        this.actor_name3 = actor_name2;
        this.actor_name4 = actor_name3;
        this.actor_name2 = actor_name4;
    }

    public int getMovie_pk() {
        return movie_pk;
    }

    public void setMovie_pk(int movie_pk) {
        this.movie_pk = movie_pk;
    }

    public String getMov_title() {
        return mov_title;
    }

    public void setMov_title(String mov_title) {
        this.mov_title = mov_title;
    }

    public String getMov_genre() {
        return mov_genre;
    }

    public void setMov_genre(String mov_genre) {
        this.mov_genre = mov_genre;
    }

    public String getMov_plot() {
        return mov_plot;
    }

    public void setMov_plot(String mov_plot) {
        this.mov_plot = mov_plot;
    }

    public String getMov_date() {
        return mov_date;
    }

    public void setMov_date(String mov_date) {
        this.mov_date = mov_date;
    }

    public String getMov_director() {
        return mov_director;
    }

    public void setMov_director(String mov_director) {
        this.mov_director = mov_director;
    }

    public String getActor_name1() {
        return actor_name1;
    }

    public void setActor_name1(String actor_name1) {
        this.actor_name1 = actor_name1;
    }

    public String getActor_name3() {
        return actor_name3;
    }

    public void setActor_name3(String actor_name3) {
        this.actor_name3 = actor_name3;
    }

    public String getActor_name4() {
        return actor_name4;
    }

    public void setActor_name4(String actor_name4) {
        this.actor_name4 = actor_name4;
    }

    public String getActor_name2() {
        return actor_name2;
    }

    public void setActor_name2(String actor_name2) {
        this.actor_name2 = actor_name2;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("movie_pk=").append(movie_pk);
        sb.append(", mov_title='").append(mov_title).append('\'');
        sb.append(", mov_genre='").append(mov_genre).append('\'');
        sb.append(", mov_plot='").append(mov_plot).append('\'');
        sb.append(", mov_date='").append(mov_date).append('\'');
        sb.append(", mov_director='").append(mov_director).append('\'');
        sb.append(", actor_name1='").append(actor_name1).append('\'');
        sb.append(", actor_name3='").append(actor_name3).append('\'');
        sb.append(", actor_name4='").append(actor_name4).append('\'');
        sb.append(", actor_name2='").append(actor_name2).append('\'');
        sb.append(", reviewList=").append(reviewList);
        sb.append('}');
        return sb.toString();
    }
}
