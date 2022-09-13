package removier.mvc.controller;

import removier.mvc.dto.Admin;
import removier.mvc.dto.User;
import removier.mvc.service.AdminService;
import removier.mvc.view.SuccessView;
import removier.mvc.view.MenuView;

import java.util.List;
import java.util.Scanner;

public class AdminController {

	private static AdminService adminService = new AdminService();
	static Scanner s = new Scanner(System.in);
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
			SuccessView.printUserAllList(list);
		} catch (Exception e){

		}
		//뒤로가기
		System.out.println("◁ 메인으로 가기");
		String option = inData("(1)을 선택해주세요!");
		if(option.equals("1")) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("\n");
			System.out.printf("\n");

			return ;
		}
	}

	/**
	 * 되돌아가기 method
	 * */
	private static String inData(String st) {
		System.out.print(st+" : ");
		return s.next();
	}

}
