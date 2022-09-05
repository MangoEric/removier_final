package removier.mvc.view;


import java.util.List;

import removier.mvc.dto.Notice;


public class SuccessView {

	public static void selectPrint(List<Notice> list) {
		System.out.println("┏━━━━━━━━━━━━━━━━┓");
		System.out.println("         ▒ 공지사항 (" + list.size() + ")");
		System.out.println("┗━━━━━━━━━━━━━━━━┛");
		for (Notice notice : list) {
			System.out.println(notice);
		}

	}


	public static void messagePrint(String message) {
		System.out.println(message);

	}

	public static void selectByNoPrint(Notice notice) {
		System.out.println(notice);

	}


	public static void printMessage(String message) {
		System.out.println(message);
	}
}