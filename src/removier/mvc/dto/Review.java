package removier.mvc.dto;

/**
 * 영화 한줄평 리뷰, 별점
 * */
public class Review {
    private int review_pk; //PK
    private int review_stars; // 별점
    private String review_content; // 리뷰내용

    private User user; // User fK
    private Movie movie; // Movie fk

    private int user_id;
    private String userLoginId;
    private int movie_id;
    private String movieTitle;

    public Review() {
    }

    public Review(int review_stars, String review_content, User user, Movie movie) {
        this.review_stars = review_stars;
        this.review_content = review_content;
        this.user = user;
        this.movie = movie;
    }

    public Review(int review_pk, int review_stars, String review_content, int user_id, String userLoginId, int movie_id, String movieTitle) {
        this.review_pk = review_pk;
        this.review_stars = review_stars;
        this.review_content = review_content;
        this.user_id = user_id;
        this.userLoginId = userLoginId;
        this.movie_id = movie_id;
        this.movieTitle = movieTitle;
    }

    public Review(int review_pk, int review_stars, String review_content, int user_id, String userLoginId, int movie_id) {
        this.review_pk = review_pk;
        this.review_stars = review_stars;
        this.review_content = review_content;
        this.user_id = user_id;
        this.userLoginId = userLoginId;
        this.movie_id = movie_id;
    }

    //    public static Review getFixture(User user, Movie movie) {
//        return new Review(1, 5, "좋아요", user, movie);
//    }


    public int getReview_pk() {
        return review_pk;
    }

    public void setReview_pk(int review_pk) {
        this.review_pk = review_pk;
    }

    public int getReview_stars() {
        return review_stars;
    }

    public void setReview_stars(int review_stars) {
        this.review_stars = review_stars;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[영화]  ").append(movieTitle + "\t\n");
        sb.append("[작성자]  ").append(userLoginId + "\t");
        sb.append("[평점]  ").append(review_stars + "/5").append("\n");
        sb.append("[리뷰]  ").append(review_content + "\n");
        return sb.toString();
    }
}
