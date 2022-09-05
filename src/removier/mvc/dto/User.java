package removier.mvc.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 회원 계정
 */
public class User extends Member {
    /**
     *
     */
    private String phone;
    private String favourite_genre;
    private String favourite_actor;


    /**
     * 영화 리뷰를 list 로 가져온다.
     */
    private List<Review> reviews = new ArrayList<Review>();


    /**
     * 즐겨찾기 를 list 로 가져온다.
     */
    private List<Bookmark> bookmarks = new ArrayList<Bookmark>();

    public User(String logingId, String password) {
        super(logingId, password);
    }

    public User(String phone, String favourite_genre, String favourite_actor) {
        this.phone = phone;
        this.favourite_genre = favourite_genre;
        this.favourite_actor = favourite_actor;
    }

    public User(int id, String name, String logingId, String password, int role, String phone, String favourite_genre, String favourite_actor) {
        super(id, name, logingId, password, role = 1);
        this.phone = phone;
        this.favourite_genre = favourite_genre;
        this.favourite_actor = favourite_actor;
    }

    public User(String logingId, String password, String phone, String favourite_genre, String favourite_actor, List<Review> reviews, List<Bookmark> bookmarks) {
        super(logingId, password);
        this.phone = phone;
        this.favourite_genre = favourite_genre;
        this.favourite_actor = favourite_actor;
        this.reviews = reviews;
        this.bookmarks = bookmarks;
    }

    public User(String phone, String favourite_genre, String favourite_actor, List<Review> reviews, List<Bookmark> bookmarks) {
        this.phone = phone;
        this.favourite_genre = favourite_genre;
        this.favourite_actor = favourite_actor;
        this.reviews = reviews;
        this.bookmarks = bookmarks;
    }

    public User(int member_pk, String member_name, String logingId, String password, int role, String phone, String favourite_genre, String favourite_actor, List<Review> reviews, List<Bookmark> bookmarks) {
        super(member_pk, member_name, logingId, password, role);
        this.phone = phone;
        this.favourite_genre = favourite_genre;
        this.favourite_actor = favourite_actor;
        this.reviews = reviews;
        this.bookmarks = bookmarks;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFavourite_genre() {
        return favourite_genre;
    }

    public void setFavourite_genre(String favourite_genre) {
        this.favourite_genre = favourite_genre;
    }

    public String getFavourite_actor() {
        return favourite_actor;
    }

    public void setFavourite_actor(String favourite_actor) {
        this.favourite_actor = favourite_actor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public static User getFixture() {
        User user = new User(1,
                "테스트",
                "test",
                "test",
                1,
                "010-7236-1800",
                "공포",
                "김영철");

//        Movie movie = Movie.getFixture();
//        Review review = Review.getFixture(user, movie);
//        user.getReviews().add(review);
//        Bookmark bookmark = new Bookmark(1, user, movie);
//        user.setBookmarks(List.of(bookmark));
        return user;
    }

    @Override
    public String toString() {


        return super.toString() + " | "+ phone+" | "+favourite_genre+" | "+favourite_actor;

    }
}
