package removier.mvc.dao;

import removier.mvc.dto.Actor;
import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {
    @Override
    public List<Movie> movieTopFive() throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Movie> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement("SELECT * FROM (select * from movie_api order by audiacc DESC) WHERE rownum <= 5");
            rs = ps.executeQuery();


            while (rs.next()) {
                Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7));
                list.add(movie);
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }
        return list;
    }

    @Override
    public Movie movieSelectByMovieTitle(String move_title) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Movie movie = null;
        String sql = "select * from movie_api where title = ?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + move_title + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                int movie_pk = rs.getInt(1);

                String mov_title = rs.getString(2);
                String mov_genre = rs.getString(3);
                String mov_plot = rs.getString(4);
                String mov_date = rs.getString(5);
                String mov_director = rs.getString(6);

                int audiacc = rs.getInt(7);

                movie = new Movie(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director, audiacc);
                List<Review> reviews = getReviews(con, movie.getMovie_pk());
                movie.setReviewList(reviews);
                List<Actor> actors = getActors(con, movie.getMovie_pk());
                movie.setActors(actors);

            }
        } finally {
            DBUtil.close(con, ps, rs);
        }

        return movie;
    }

    private List<Review> getReviews(Connection con, int movie_pk) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Review> reviews = new ArrayList<>();
        String sql = "select * from review_api where movie_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, movie_pk);
            rs = ps.executeQuery();

            while (rs.next()) {
                Review review = new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
                reviews.add(review);
            }
        } finally {
            DBUtil.close(null, ps, rs);
        }

        return reviews;
    }

    @Override
    public List<Movie> movieSelectByGenre(String mov_genre) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from movie_api where genre = ?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, mov_genre);
            rs = ps.executeQuery();

            while (rs.next()) {
                Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                movies.add(movie);
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }

        return movies;
    }

    @Override
    public Movie showBestMyGenreMovie(String favourite_genre) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Movie movie = null;
        String sql = "select * from movie_api WHERE genre LIKE '?' AND rownum <= 5 ORDER BY audiacc desc;";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + favourite_genre + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                int movie_pk = rs.getInt(1);

                String mov_title = rs.getString(2);
                String mov_genre = rs.getString(3);
                String mov_plot = rs.getString(4);
                String mov_date = rs.getString(5);
                String mov_director = rs.getString(6);

                int audiacc = rs.getInt(7);

                movie = new Movie(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director, audiacc);
                List<Review> reviews = getReviews(con, movie.getMovie_pk());
                movie.setReviewList(reviews);
                List<Actor> actors = getActors(con, movie.getMovie_pk());
                movie.setActors(actors);
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }

        return movie;
    }

    @Override
    public Movie updatedMovieInfo(Movie movie) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Movie updatedMovie = null;
        String sql = "select * from movie_api where title = ?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, movie.getMov_title());
            rs = ps.executeQuery();

            while (rs.next()) {
                int movie_pk = rs.getInt(1);

                String mov_title = rs.getString(2);
                String mov_genre = rs.getString(3);
                String mov_plot = rs.getString(4);
                String mov_date = rs.getString(5);
                String mov_director = rs.getString(6);

                int audiacc = rs.getInt(7);

                updatedMovie = new Movie(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director, audiacc);
                List<Review> reviews = getReviews(con, updatedMovie.getMovie_pk());
                List<Actor> actors = getActors(con, updatedMovie.getMovie_pk());
                updatedMovie.setReviewList(reviews);
                updatedMovie.setActors(actors);
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }

        return updatedMovie;
    }

    private List<Actor> getActors(Connection con, int movie_pk) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Actor> actors = new ArrayList<>();
        String sql = "SELECT * FROM actor_api WHERE movie_id = ? AND rownum <= 5";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, movie_pk);
            rs = ps.executeQuery();

            while (rs.next()) {
                Actor actor = new Actor(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                actors.add(actor);
            }
        } finally {
            DBUtil.close(null, ps, rs);
        }
        return actors;
    }
}
