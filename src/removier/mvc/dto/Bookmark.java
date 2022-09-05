package removier.mvc.dto;

/**
 * 즐겨찾기
 * */
public class Bookmark {
    private int Bookmark_pk; // PK
    private User user; // 회원 PK
    private Movie movie;

    public Bookmark() {
    }

    public Bookmark(int bookmark_pk, User user, Movie movie) {
        Bookmark_pk = bookmark_pk;
        this.user = user;
        this.movie = movie;
    }

    public int getBookmark_pk() {
        return Bookmark_pk;
    }

    public void setBookmark_pk(int bookmark_pk) {
        Bookmark_pk = bookmark_pk;
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
}
