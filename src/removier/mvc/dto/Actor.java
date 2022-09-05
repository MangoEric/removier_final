package removier.mvc.dto;

/**
 * 배우 정보
 * */
public class Actor {
    private int actor_pk;
    private String actor_name; // 배우이름
    private Movie movie;

    public Actor() {
    }

    public Actor(int actor_pk, String actor_name, Movie movie) {
        this.actor_pk = actor_pk;
        this.actor_name = actor_name;
        this.movie = movie;
    }

    public int getActor_pk() {
        return actor_pk;
    }

    public void setActor_pk(int actor_pk) {
        this.actor_pk = actor_pk;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
