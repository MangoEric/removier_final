package removier.mvc.view;



import removier.mvc.controller.NoticeController;

import removier.mvc.controller.AdminController;
import removier.mvc.controller.NoticeController;


import removier.mvc.controller.UserController;


import removier.mvc.dto.Admin;
import removier.mvc.dto.Notice;
import removier.mvc.dto.User;
import removier.mvc.service.NoticeService;
import removier.mvc.util.ViewUtil;

import java.util.Scanner;


public class MenuView {
	static Scanner sc = new Scanner(System.in);

    public static void menu() {
        while (true) {

            MenuView.printMenu();
            int menu = Integer.parseInt(ViewUtil.input("번호를 입력하세요 > ")) ;
            switch(menu) {
                case 1 :
                    MenuView.register(); // 가입

                    break;
                case 2:
                    User requestLoginUser = MenuView.login();
                    UserController.login(requestLoginUser);// 로그인
                    break;
                case 7:
                    MenuView.adminLogin();// 관리자 로그인
                    break;

                case 9:
                    System.exit(0);
            }
        }

    }

    public static void printMenu() {

        System.out.println(ViewConst.banner);

        ViewUtil.printMessage("1. 가입   |   2. 로그인   |  9. 종료");
    }
	
	/**
	 * 가입
	 * */
	private static void register() {
		String registerId = ViewUtil.input("아이디 > ");
        String registerPw = ViewUtil.input("비밀번호 > ");
        String registerName = ViewUtil.input("이름 > ");
        String registerPhone = ViewUtil.input("휴대폰 > ");
        String registerFG = ViewUtil.input("=== 1. 멜로 2. 코미디 3. 로맨틱 코미디 4. 액션 =======\r\n"
        		+ "=== 5. 스릴러 6. 미스터리 7. 공포 8. 공상과학 9 판타지 ===\r\n"
        		+ "선호 장르 > ");
        String registerFA = ViewUtil.input("최애 배우 > ");
        
        User user = new User(0, registerName, registerId, registerPw, 1, registerPhone, registerFG, registerFA);
		
        UserController.signUp(user);
	}

    /**
     * 로그인 메뉴
     */
    public static User login() {


        String logingId = ViewUtil.input("아이디 > ");
        String password = ViewUtil.input("비밀번호 > ");
        
        User user = new User(logingId, password);
        

		return user;

    }

    /**
     * 관리자 로그인
     * */
    public static void adminLogin(){
        System.out.println("==========[관리자 로그인]==========");
        String logingId = ViewUtil.input("관리자 아이디 > ");
        String password = ViewUtil.input("관리자 비밀번호 > ");


        Admin admin = new Admin(logingId,password);


        AdminController.login(admin);
    }

    public static void printAdminMenu(Admin admin) {
		while (true) {
			System.out.println();
			ViewUtil.printMessage(ViewConst.adminBanner);
			System.out.println("-----------------------------관리자 " + admin.getLogingId() + " 님 로그인 중 -------------------------------");
			System.out.println(" 1. 회원정보 조회 |  2. 공지사항 작성  |  3. 공지사항 수정  | 4. 공지사항 삭제  |  5. Logout ");
			int menu = Integer.parseInt(ViewUtil.input("번호를 입력하세요 > "));
			switch (menu) {
				case 1:
					AdminController.userSelectAll();
					break;
				case 2:
					inputInsertNotice();
					break;
				case 3:
					inputUpdateNotice();
					break;
				case 4:
					inputDeleteNotice();
					break;
				case 5:
					return;
			}
		}
	}

    private static void showMyPage() {
    	User loginUser = UserController.getLoginUser();
    	while(true) {	
    		int menu = Integer.parseInt(
    			ViewUtil.input("\n===" + loginUser.getLogingId() + "님의 My Page ===\n" 
    				+ "[id] " + loginUser.getLogingId() + "\n"
    				+ "[이름] " + loginUser.getMember_name() + "\n"
    				+ "[나의 최애 배우] " + loginUser.getFavourite_actor() + "\n"
    				+ "[나의 선호 영화 장르] " + loginUser.getFavourite_genre() + "\n"
    				+ "[연락처] " + loginUser.getPhone() + "\n\n\n"
    				+ "======= 1. 회원정보 수정 2. 내가 작성한 리뷰(7) 3.즐겨찾기 영화 4. 메인으로 ======\n"
    				+ "번호를 입력하세요 > "
    			)		
    		); 
    	
    		switch(menu) {
				case 1 :
			        String updatePw = ViewUtil.input("비밀번호 > ");
			        String updateName = ViewUtil.input("이름 > ");
					String updateFA = ViewUtil.input("최애 배우 > ");
					String updateFG = ViewUtil.input("=== 1. 멜로 2. 코미디 3. 로맨틱 코미디 4. 액션 =======\r\n"
			        		+ "=== 5. 스릴러 6. 미스터리 7. 공포 8. 공상과학 9 판타지 ===\r\n"
			        		+ "선호 장르 > ");
					String updatePhone = ViewUtil.input("연락처 > ");	
					
					loginUser = new User(loginUser.getMember_pk(), updateName, loginUser.getLogingId(), updatePw, 1, updatePhone, updateFG, updateFA);
					
					UserController.updateUserInfo(loginUser);
					break;
					
				case 2 :
					break;
					
				case 3 :
					UserController.selectBookmarkByUser(loginUser);
					break;
					
				case 4 :
					return;
				}
    	}
	}


	/**
     * 로그아웃
     * */
    public static void logout(User loginUser) {    	
    	UserController.logout(loginUser);
    }

	public static void printUserMenu(User user) {
		while (true) {

			System.out.println();
			System.out.println(" ▣ " + user.getLogingId() + " 로그인 중 ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　				           ┃");
			System.out.println("┃     1.최신영화 (Top5)     2.영화검색     3.공지사항     4. MyPage     5.Logout	   ┃");
			System.out.println("┃　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　				           ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println();
			int menu = Integer.parseInt(ViewUtil.input("번호를 입력하세요 ▷ "));
			System.out.println();
			switch (menu) {
			case 1:

			case 2:
				SearchMovieView.searchMovie(user);
				break;
			case 3:// 공지사항
				NoticeController.noticeSelectByAll();
				break;

			case 4:
				showMyPage();
				break;
			case 5:
				logout(user);
				return;

			}
		}

	}

	/**
	 * 관리자 > 공지사항 - 등록, 수정, 삭제
	 */

	/*공지사항 등록*/
	public static void inputInsertNotice() {
		System.out.println("공지사항 등록해주세요.");
		System.out.println();

		System.out.print("제목 : ");
		String notice_title = sc.nextLine();

		System.out.print("내용 : ");
		String notice_content = sc.nextLine();

		Notice notice = new Notice(0, notice_title, notice_content, null);
		NoticeController.noticeInsert(notice);
	}

	/*공지사항 수정*/
	public static void inputUpdateNotice() {
		System.out.println("공지사항 수정해주세요.");
		System.out.println();

		System.out.print("수정 게시물 번호 ▷ ");
		int no = Integer.parseInt(sc.nextLine());

		System.out.print("수정 내용 : ");
		String notice_content = sc.nextLine();

		Notice notice = new Notice(no, null, notice_content, null);
		NoticeController.noticeUpdate(notice);
	}

	/*공지사항 삭제*/
	public static void inputDeleteNotice() {
		System.out.print("삭제 게시물 번호 ▷ ");
		int notice_pk = Integer.parseInt(sc.nextLine());
		NoticeController.noticeDelete(notice_pk);
	}

}
