package removier.mvc.view;


import java.util.List;

import removier.mvc.dto.Notice;
import removier.mvc.util.ViewUtil;


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
}