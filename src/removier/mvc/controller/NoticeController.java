package removier.mvc.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import removier.mvc.dto.Notice;
import removier.mvc.service.NoticeService;
import removier.mvc.view.FailView;
import removier.mvc.view.SuccessView;



public class NoticeController {


	private static NoticeService noticeService = new NoticeService();
	static Scanner s = new Scanner(System.in);
	
	/**
	 * 공지사항 전체 조회하기
	 * */
	public static void noticeSelectByAll() {
		//호출
		try {
			//서비스 호출하고 그결과에 따라 성공 또는 실패뷰로 이동한다.
			List<Notice> list = noticeService.noticeSelectAll();
			SuccessView.selectPrint(list);
			
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage( e.getMessage() );
		}
		System.out.println();
		
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

		}	
		
	}	
	/**
	 * 되돌아가기 method
	 * */
	private static String inData(String st) {
		System.out.print(st+" : ");
		return s.next();
	}
	

	/**
	 * 공지 등록하기
	 * */

	public static void noticeInsert(Notice notice) {
		try{
		noticeService.noticeInsert(notice);
		SuccessView.messagePrint("공지가 등록되었습니다.");
		} catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 공지 수정하기
	 * */
	public static void noticeUpdate(Notice notice) {
		try {
		noticeService.noticeUpdate(notice);
		SuccessView.messagePrint("공지가 수정되었습니다.");
		} catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
		
	
	/**
	 * 공지 삭제하기
	 * */
	public static void noticeDelete(int notice_pk) {
		try {
		noticeService.noticeDelete(notice_pk);
		SuccessView.messagePrint("공지가 삭제되었습니다.");
		} catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	
}