package removier.mvc.controller;

import java.sql.SQLException;

import removier.mvc.dao.UserDAO;
import removier.mvc.dto.User;
import removier.mvc.service.MovieService;
import removier.mvc.service.UserService;
import removier.mvc.util.ViewUtil;
import removier.mvc.view.MenuView;
import removier.mvc.view.OutputView;
import removier.mvc.view.SuccessView;
import removier.mvc.view.FailView;

public class UserController {

    private static UserService userService = new UserService();
    private static User loginUser;


    public static User getLoginUser() {
        return loginUser;
    }

    /**
     * 로그인
     */
    public static void login(User user) {
        try {
            loginUser = userService.login(user);
            MenuView.printUserMenu(loginUser);
        } catch (Exception e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 회원 가입
     */
    public static void signUp(User user) {
        try {
            userService.signUp(user);
            SuccessView.printMessage("Welcome to Removier");
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void updateUserInfo(User loginUser) {
        try {
            userService.updateUserInfo(loginUser);
            SuccessView.printMessage("=== 회원정보가 수정되었습니다. ===");
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     * 로그아웃
     */
    public static void logout(User loginUser) {
        try {
            userService.logout(loginUser);
            SuccessView.printMessage("로그아웃 되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User updatedUserInfo(User requestLoginUser) {
        try {
            loginUser = userService.login(requestLoginUser);

        } catch (Exception e) {
            ViewUtil.errorMessage(e.getMessage());
        }
        return loginUser;
    }

    public static void getMyReview(User user) {
        try {
            User userInfo = userService.getMyReview(user);
            OutputView.printUserReviews(userInfo);
        } catch (Exception e) {
            ViewUtil.errorMessage(e.getMessage());
        }
    }
}

