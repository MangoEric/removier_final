package removier.mvc.view;


import removier.mvc.controller.UserController;
import removier.mvc.dto.*;


import removier.mvc.util.ViewUtil;


import java.util.List;

public class SuccessView {
    public static void selectPrint(List<Notice> list) {

        ViewUtil.printMessage("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        ViewUtil.printMessage("         ▒ 공지사항 (" + list.size() + ")");
        ViewUtil.printMessage("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        for (Notice notice : list) {
            ViewUtil.printMessage(notice);
        }

    }


    public static void messagePrint(String message) {
        ViewUtil.printMessage(message);

    }

    public static void selectByNoPrint(Notice notice) {
        ViewUtil.printMessage(notice);

    }


    public static void printMessage(String message) {
        ViewUtil.printMessage(message);
    }


    public static void printBookmarkByUser(List<Bookmark> bookmarks) {
        System.out.println("나의 즐겨찾기");
        //System.out.println("나의 즐겨찾기" + bookmarks.size() + "개");
        for (Bookmark bm : bookmarks) {
            System.out.println(bm.getMovie_title());
        }
    }

    public static void printMovieReview(List<Review> reviews) {
        for (Review review : reviews) {
            final StringBuilder sb = new StringBuilder();
            sb.append("[작성자]  ").append(review.getUserLoginId() + "\t");
            sb.append("[평점]  ").append(review.getReview_stars() + "/5").append("\n");
            sb.append("[리뷰]  ").append(review.getReview_content());
            ViewUtil.printMessage(sb.toString());
        }
    }

    public static void printUserReview(User user, Movie movie) {
        Review review = null;
        for (Review movieReview : movie.getReviewList()) {
            if (user.getMember_pk() == movieReview.getUser_id()) {
                review = movieReview;
                break;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("[작성자]  ").append(user.getLogingId() + "\t");
        sb.append("[평점]  ").append(review.getReview_stars() + "/5").append("\n");
        sb.append("[리뷰]  ").append(review.getReview_content() + "\n");
        ViewUtil.printMessage(sb.toString());
    }

    public static void printUserReviews(User userInfo) {
        List<Review> reviews = userInfo.getReviews();

        for (int i = 0; i < reviews.size(); i++) {
            ViewUtil.printMessage(reviews.get(i));
        }
    }

    /**
     * 회원정보 전부 출력
     */
    public static void printUserAllList(List<User> list) {
        System.out.println();
        System.out.println("---- 총 회원수 : " + list.size() + " 명 --------------------------------------------------------------------");
        System.out.println("[회원번호]" + String.format("%10s", "[회원명]") + String.format("%10s", "[아이디]") +
                String.format("%10s", "[비밀번호]") + String.format("%12s", "[핸드폰번호]") + String.format("%13s", "[최애장르]") + String.format("%10s", "[최애배우]") + String.format("%10s", "[작성한 리뷰]"));
        for (User user : list) {
            System.out.println("\t" + user.getMember_pk() + "\t  " + String.format("%7s", user.getMember_name()) + String.format("%10s", user.getLogingId()) +
                    String.format("%10s", user.getPassword()) + String.format("%20s", user.getPhone())
                    + String.format("%10s", user.getFavourite_genre()) + String.format("%10s", user.getFavourite_actor()) + String.format("%10s", UserController.updatedUserInfo(user).getReviews().size() + "개"));

        }
        System.out.println();
    }

    public static void printMovieGenre(List<Movie> movies) {
        for (Movie movie : movies) {
            ViewUtil.printMessage(" ▥영화명   : " + movie.getMov_title());
            ViewUtil.printMessage(" ▥영화감독 : " + movie.getMov_director());
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        }

    }

    public static void printMovieOfActor(List<Actor> actors) {
        for (Actor actor : actors) {
            ViewUtil.printMessage(" ▥영화명   : " + actor.getMovieName());
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        }

    }


    public static void printMovieTopFive(List<Movie> list) {

        System.out.println("┏━━━━━오늘의 Top5 영화━━━━━┓");
        for (Movie movie : list) {
            System.out.println("┃ \t" + movie.getMov_title());
        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛");
    }


    public static void printMovieInfo(Movie movie) {
        ViewUtil.printMessage("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
                "  ▒  영화정보 \n" +
                " [영화제목] : " + movie.getMov_title() + "\n" +
                " [장르] : " + movie.getMov_genre() + "\n" +
                " [감독] : " + movie.getMov_director() + "\n" +
                " [배우] : " + getActors(movie.getActors()) + "\n" +
                " [줄거리] \n" + movie.getMov_plot() + "\n" +

                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");


    }

    private static String getActors(List<Actor> actors) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < actors.size(); i++) {
            if (i != actors.size() - 1) {
                result.append(actors.get(i).getName()).append(", ");
            } else {
                result.append(actors.get(i).getName());
            }
        }
        return result.toString();
    }

    public static void printFavoriteMovie(List<Movie> movies) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━┓");
        for (Movie movie : movies) {
            System.out.println("┃ \t" + movie.getMov_title());
        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}
