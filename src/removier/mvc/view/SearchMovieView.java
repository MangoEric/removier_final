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

    /**
     * 영화 검색 method
     * @param : User 를 받는다.
     * */
    public static void searchMovie(User user) {
        ViewUtil.printMessage("----- 현재 로그인된 사용자 : " + user.getLogingId() + " -----");
        ViewUtil.printMessage("★★★★★★★★★★★  영화검색  ★★★★★★★★★★★");
        ViewUtil.printMessage("1. 영화이름    2. 배우이름    3. 장르");
        int input = Integer.parseInt(ViewUtil.input("선택 > "));
        switch (input) {
            case 1:
                String movieName = searchMovieTitle();
//                UserController.updatedUserInfo(user);
                MovieController.movieSelectByMovieTitle(movieName);
                break;
            case 2:
                String actorName = searchActorName();
//                UserController.updatedUserInfo(user);
                MovieController.movieSelectByActor(actorName);
                break;
            case 3:
                String movieGenre = searchMovieGenre();
                MovieController.movieSelectByGenre(movieGenre);
                break;

        }
    }

    /**
     * 영화 장르를 검색을 받는다
     * @return : 해당 영화장르를 String 으로 리턴한다.
     * */
    private static String searchMovieGenre() {
        ViewUtil.printMessage("================ 영화장르를 검색하세요 ================");
        System.out.println();
        return ViewUtil.input("영화장르 ▶ ");

    }

    /**
     * 영화 제목으로 검색을 받는다
     * @return : 입력받은 영화 제목을 String 으로 리턴한다.
     * */
    private static String searchMovieTitle() {
        ViewUtil.printMessage("=== 영화이름을 검색하세요 ===");
        return ViewUtil.input("영화이름 > ");
    }


    /**
     * 영화 배우를 검색을 받는다
     * @return : 입력받은 영화배우를 리턴한다.
     * */
    private static String searchActorName() {
        ViewUtil.printMessage("=== 배우이름을 검색하세요 ===");
        return ViewUtil.input("배우이름 > ");
    }

    /**
     * 영화 검색결과 출력
     * @param : User 정보와, Movie 를 객체로 받는다
     * */
    public static void movieResult(User user, Movie movie) throws Exception {
        boolean run = true;
        while (run) {
            User updatedUser = UserController.updatedUserInfo(user);
            Movie updatedMovie = MovieController.updatedMovieInfo(movie);
            SuccessView.printMovieInfo(updatedMovie);


            if (updatedMovie.getReviewList() == null || updatedMovie.getReviewList().size() == 0) {
                ViewUtil.printMessage("작성된 리뷰가 없습니다.");
            } else {
                SuccessView.printMovieReview(updatedMovie.getReviewList());
            }
            ViewUtil.printMessage("=== 1. 리뷰 작성  2. 리뷰 수정하기  3. 리뷰 삭제하기  4. 즐겨찾기 추가  5. 즐겨찾기 취소  9. 메인으로 ===");

            int input = Integer.parseInt(ViewUtil.input("선택 > "));
            switch (input) {
                case 1:
                    int result = 0;
                    User updatedUserInfo = UserController.updatedUserInfo(updatedUser);
                    for (Review userReview : updatedUserInfo.getReviews()) {
                        if (userReview.getMovie_id() == updatedMovie.getMovie_pk()) {
                            result = 1;
                        }
                    }
                    if (result == 1) {
                        ViewUtil.printMessage("이미 작성하신 리뷰가 존재합니다!!!!");
                        break;
                    }

                    Review newReview = createReview(updatedUser, updatedMovie);
                    ReviewController.createReview(newReview);
                    break;
                case 2:
                    User updatedUserInfo2 = UserController.updatedUserInfo(updatedUser);
                    Review updateReview = updateReview(updatedUserInfo2, updatedMovie);
                    if (updateReview == null) {
                        ViewUtil.printMessage("작성하신 리뷰가 없습니다.");
                        break;
                    }
                    ReviewController.updateReview(updateReview);
                    break;
                case 3:
                    int deleteResult = 0;
                    User updatedUserInfo3 = UserController.updatedUserInfo(updatedUser);
                    for (Review review : updatedMovie.getReviewList())
                        if (review.getUser_id() == updatedUserInfo3.getMember_pk()) {
                            deleteResult = 1;
                        }
                    if (deleteResult == 1) {
                        if (Integer.parseInt(ViewUtil.input("정말 삭제하시겠습니까? \n ( 메인으로가기 : 1 || 삭제하기 : 2 ) > ")) == 2) {
                            deleteReview(updatedUser, updatedMovie);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        ViewUtil.printMessage("삭제하실 리뷰가 없습니다.");
                        break;
                    }
                case 4:
                    UserController.addBookmark(user, movie);
                    break;
                case 5:
                    UserController.deleteBookmark(user, movie);
                    break;
                case 9:
                    run=false;

            }

        }
    }

    /**
     * 리뷰 삭제
     * @param : User 와 Movie 를 객체로 받는다.
     * */
    private static void deleteReview(User user, Movie movie) {
        ReviewController.deleteReview(user, movie);
    }

    /**
     * 리뷰 내용을 수정한다
     * @param : User 객체와 Moive 객체를 전달받는다.
     * @return : 수정된 Review 객체를 리턴한다.
     * */
    private static Review updateReview(User user, Movie movie) {
        int review_star = 0;
        String review_contents = null;
        Review review = null;

        for (Review userReview : user.getReviews()) {
            if (userReview.getMovie_id() == movie.getMovie_pk()) {
                SuccessView.printUserReview(user, movie);
                review_star = Integer.parseInt(ViewUtil.input("평점 > "));
                review_contents = ViewUtil.input("리뷰 > ");
                userReview.setReview_stars(review_star);
                userReview.setReview_content(review_contents);
                review = userReview;
            }
        }
        return review;
    }

    /**
     * 리뷰 생성
     * @param : User 객체와 Moive 객체를 전달받는다.
     * @return : 작성된 Review 객체 리턴
     * */
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

    /**
     * 별점은 0~5 점 사이만 등록된다
     * @return : boolean 형으로 리턴
     * */
    private static boolean isNotValidRange(int review_star) {
        return review_star < 0 || review_star > 5;
    }

    /**
     * 취향 저격 콘텐츠 영화 출력
     * @param : 로그인한 User 의 정보를 받는다.
     * */
    public static void showBestMyGenreMovie(User loginUser) {
        ViewUtil.printMessage(loginUser.getMember_name() + "님의 취향저격 콘텐츠");


    }
}


