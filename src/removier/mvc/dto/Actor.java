package removier.mvc.dto;

/**
 * 배우 정보
 * */
public class Actor {
    private int actorPk;
    private int movieId;
    private String name; // 배우이름
    private String movieName;

    private Movie movie;

    public Actor() {
    }

    public Actor(int actorPk, int movieId, String name, String movieName) {
        this.actorPk = actorPk;
        this.movieId = movieId;
        this.name = name;
        this.movieName = movieName;
    }

    public int getActorPk() {
        return actorPk;
    }

    public void setActorPk(int actorPk) {
        this.actorPk = actorPk;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Actor{");
        sb.append("actorPk=").append(actorPk);
        sb.append(", movieId=").append(movieId);
        sb.append(", actorName='").append(name).append('\'');
        sb.append(", movieName='").append(movieName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
