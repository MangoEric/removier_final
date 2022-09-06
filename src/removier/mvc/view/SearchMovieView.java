package removier.mvc.view;

import removier.mvc.controller.MovieController;
import removier.mvc.controller.ReviewController;
import removier.mvc.controller.UserController;
import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
import removier.mvc.util.ViewUtil;

import java.util.List;


public class SearchMovieView {
    public static void searchMovie(User user) {
        ViewUtil.printMessage("----- 현재 로그인된 사용자 : " + user.getLogingId() + " -----");
        ViewUtil.printMessage("★★★★★★★★★★★  영화검색  ★★★★★★★★★★★");
        ViewUtil.printMessage("1. 영화이름    2. 배우이름    3. 장르");
        int input = Integer.parseInt(ViewUtil.input("선택 > "));
        switch (input) {
            case 1:
                String movieName = searchMovieTitle();
                UserController.updatedUserInfo(user);
                MovieController.movieSelectByMovieTitle(movieName);
                break;
            case 2:

                break;
            case 3:

                break;

        }
    }

    private static String searchMovieTitle() {
        ViewUtil.printMessage("=== 영화이름을 검색하세요 (정확한 영화이름으로 검색하세요!!) ===");
        return ViewUtil.input("영화이름 > ");
    }

    public static void movieResult(User user, Movie movie) throws Exception {
        if (movie.getReviewList() == null || movie.getReviewList().size() == 0) {
            ViewUtil.printMessage("작성된 리뷰가 없습니다.");
        } else {
            OutputView.printMovieReview(movie.getReviewList());
        }

        ViewUtil.printMessage("=== 1. 리뷰 작성  2. 리뷰 수정하기  3. 리뷰 삭제하기  4. 즐겨찾기  5. 메인으로 ===");

        int input = Integer.parseInt(ViewUtil.input("선택 > "));
        switch (input) {
            case 1:
                User updatedUserInfo = UserController.updatedUserInfo(user);
                for (Review userReview : updatedUserInfo.getReviews()) {
                    System.out.println(userReview.getMovie_id());
                    System.out.println(movie.getMovie_pk());
                    if (userReview.getMovie_id() == movie.getMovie_pk()) {
                        ViewUtil.printMessage("이미 작성하신 리뷰가 존재합니다!!!!");
                        return;
                    }
                }
                Review newReview = createReview(user, movie);
                ReviewController.createReview(newReview);
                break;
            case 2:
                Review updateReview = updateReview(user, movie);
                if (updateReview == null) {
                    break;
                }
                ReviewController.updateReview(updateReview);
                break;
            case 3:
                deleteReview(user, movie);
                break;
            case 4:
                break;

        }
    }

    private static void deleteReview(User user, Movie movie) {
        ReviewController.deleteReview(user, movie);
    }

    private static Review updateReview(User user, Movie movie) {
        int review_star = 0;
        String review_contents = null;

        for (Review userReview : user.getReviews()) {
            if (userReview.getMovie_id() == movie.getMovie_pk()) {
                OutputView.printUserReview(user, movie);
                review_star = Integer.parseInt(ViewUtil.input("평점 > "));
                review_contents = ViewUtil.input("리뷰 > ");
                break;
            } else {
                ViewUtil.errorMessage("작성하신 리뷰가 없습니다.");
                break;
            }
        }

//                Review updateReview = user.getReviews()
//                        .stream()
//                        .filter(r -> r.getMovie().getMov_title().equals(movie.getMov_title()))
//                        .findFirst().get();

        List<Review> reviews = user.getReviews();
        for (Review review : reviews) {
            if (review.getMovie_id() == movie.getMovie_pk()) {
                review.setReview_stars(review_star);
                review.setReview_content(review_contents);
//                    updateReview = review;
                return review;
            }
        }
        return null;
    }


    private static Review createReview(User user, Movie movie) {
        int review_star = 0;
        String review_contents = null;
        ViewUtil.printMessage("=== 리뷰작성 ===");

        while (true) {
            review_star = Integer.parseInt(ViewUtil.input("별점 > "));

            if (isNotValidRange(review_star)) {
                ViewUtil.errorMessage("1 ~ 5사이의 숫자를 입력해주세요!");
                continue;
            }

            review_contents = ViewUtil.input("리뷰 > ");
            return new Review(review_star, review_contents, user, movie);

        }
    }

    private static boolean isNotValidRange(int review_star) {
        return review_star < 0 || review_star > 5;
    }


    public static void showTopFive() {
        MovieController.movieTopFive();
    }

    public static void showBestMyGenreMovie(User user) {
        MovieController.showBestMyGenreMovie(user);
    }
}


