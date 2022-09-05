package removier.mvc.controller;

import removier.mvc.dto.Admin;
import removier.mvc.dto.User;
import removier.mvc.service.AdminService;
import removier.mvc.service.UserService;
import removier.mvc.view.EndView;
import removier.mvc.view.MenuView;

import java.util.List;

public class AdminController {

	private static AdminService adminService = new AdminService();
	/**
	 * 로그인하기
	 * */
	public static void login(Admin admin) {
		try {
			Admin admin1 = adminService.adminLogin(admin);
			MenuView.printAdminMenu(admin1);
		} catch (Exception e){

		}

	}
	/**
	 * 전체 회원 정보 조회
	 * */
	public static void userSelectAll(){
		try	{
			List<User> list = adminService.userSelectAll();
			EndView.printUserAllList(list);
		} catch (Exception e){

		}
	}
}
