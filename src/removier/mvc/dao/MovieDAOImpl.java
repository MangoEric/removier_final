package removier.mvc.dao;

import removier.mvc.dto.Actor;
import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
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
            ps = con.prepareStatement("select * from movie where id<=5");
            rs = ps.executeQuery();


            while (rs.next()) {
                Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
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
        String sql = "select * from movie where title = ?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, move_title);
            rs = ps.executeQuery();

            while (rs.next()) {
                int movie_pk = rs.getInt(1);

                String mov_title = rs.getString(2);
                String mov_genre = rs.getString(3);
                String mov_plot = rs.getString(4);
                String mov_date = rs.getString(5);
                String mov_director = rs.getString(6);
                String actor_name1 = rs.getString(7);
                String actor_name2 = rs.getString(8);
                String actor_name3 = rs.getString(9);
                String actor_name4 = rs.getString(10);

                movie = new Movie(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director, actor_name1, actor_name2, actor_name3, actor_name4);
                List<Review> reviews = getReviews(con, movie.getMovie_pk());
                movie.setReviewList(reviews);
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
        String sql = "select * from review where movie_id = ?";

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
    public List<Movie> movieSelectByActor(String actor_name) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie WHERE actor1=? or actor2=? or actor3=? or actor4=?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, actor_name);
            ps.setString(2, actor_name);
            ps.setString(3, actor_name);
            ps.setString(4, actor_name);

            rs = ps.executeQuery();

            while (rs.next()) {
                Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                movies.add(movie);


            }
        } finally {
            DBUtil.close(con, ps, rs);
        }

        return movies;
    }


    @Override
    public List<Movie> movieSelectByGenre(String mov_genre) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from movie where genre = ?";

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
        String sql = "select * from movie where  = ?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, favourite_genre);
            rs = ps.executeQuery();

            while (rs.next()) {
                int movie_pk = rs.getInt(1);

                String mov_title = rs.getString(2);
                String mov_genre = rs.getString(3);
                String mov_plot = rs.getString(4);
                String mov_date = rs.getString(5);
                String mov_director = rs.getString(6);
                String actor_name1 = rs.getString(7);
                String actor_name2 = rs.getString(8);
                String actor_name3 = rs.getString(9);
                String actor_name4 = rs.getString(10);

                movie = new Movie(movie_pk, mov_title, mov_genre, mov_plot, mov_date, mov_director, actor_name1, actor_name2, actor_name3, actor_name4);
                List<Review> reviews = getReviews(con, movie.getMovie_pk());
                movie.setReviewList(reviews);
            }
        } finally {
            DBUtil.close(con, ps, rs);
        }

        return movie;
    }
}
