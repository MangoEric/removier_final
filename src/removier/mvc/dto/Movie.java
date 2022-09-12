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
    private int audiacc; // 누적 관람객 수


    private List<Actor> actors = new ArrayList<>();

    /**
     * 영화 리뷰를 list 로 가져온다.
     * */
    private List<Review> reviewList = new ArrayList<Review>();

    public Movie() {
    }

    public Movie(int movie_pk, String mov_title, String mov_genre, String mov_plot, String mov_date, String mov_director) {
        this.movie_pk = movie_pk;
        this.mov_title = mov_title;
        this.mov_genre = mov_genre;
        this.mov_plot = mov_plot;
        this.mov_date = mov_date;
        this.mov_director = mov_director;
    }

    public Movie(int movie_pk, String mov_title, String mov_genre, String mov_plot, String mov_date, String mov_director, int audiacc) {
        this(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director);
        this.audiacc = audiacc;
    }

    public Movie(int movie_pk, String mov_title, String mov_genre, String mov_plot, String mov_date, String mov_director, int audiacc, List<Review> reviewList) {
        this(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director, audiacc);
        this.reviewList = reviewList;
    }

    public Movie(int movie_pk, String mov_title, String mov_genre, String mov_plot, String mov_date, String mov_director, int audiacc, List<Actor> actors, List<Review> reviewList) {
        this(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director, audiacc, reviewList);
        this.actors = actors;
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

    public int getAudiacc() {
        return audiacc;
    }

    public void setAudiacc(int audiacc) {
        this.audiacc = audiacc;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("movie_pk=").append(movie_pk);
        sb.append(", mov_title='").append(mov_title).append('\'');
        sb.append(", mov_genre='").append(mov_genre).append('\'');
        sb.append(", mov_plot='").append(mov_plot).append('\'');
        sb.append(", mov_date='").append(mov_date).append('\'');
        sb.append(", mov_director='").append(mov_director).append('\'');
        sb.append(", audiacc='").append(audiacc).append('\'');
        sb.append(", reviewList=").append(reviewList);
        sb.append('}');
        return sb.toString();
    }
}
