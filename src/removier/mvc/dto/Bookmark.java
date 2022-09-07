package removier.mvc.dto;

/**
 * 즐겨찾기
 * */
public class Bookmark {
    private int Bookmark_pk; // PK
    private User user; // 회원 PK
    private Movie movie;
    private int user_id;
    private int movie_id;
    private String movie_title;
    
    public Bookmark() {} 
    
    public Bookmark(int bookmark_pk, String movie_title, int user_id, int movie_id) {
		super();
		Bookmark_pk = bookmark_pk;
		this.user_id = user_id;
		this.movie_id = movie_id;
		this.movie_title = movie_title;
	}
    
	public Bookmark(int bookmark_pk, User user, Movie movie, int user_id, int movie_id, String movie_title) {
		super();
		Bookmark_pk = bookmark_pk;
		this.user = user;
		this.movie = movie;
		this.user_id = user_id;
		this.movie_id = movie_id;
		this.movie_title = movie_title;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
}
