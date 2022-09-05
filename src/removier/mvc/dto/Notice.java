package removier.mvc.dto;
/**
 * 공지사항
 * */
public class Notice {
    private int notice_pk; // 공지사항 PK    
    private String notice_title; // 공지사항 제목
    private String notice_content; // 공지사항 내용
    private String notice_date; // 공지사항 등록일

    public int getNotice_pk() {
        return notice_pk;
    }

    public void setNotice_pk(int notice_pk) {
        this.notice_pk = notice_pk;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(String notice_date) {
        this.notice_date = notice_date;
    }

    public Notice() {
    }

    public Notice(int notice_pk, String notice_title, String notice_content, String notice_date) {
        this.notice_pk = notice_pk;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_date = notice_date;
    }

	@Override
	public String toString() {
		System.out.println(" ==========================================================================================");
		System.out.println();
		return " "+ notice_pk +"▷ "+ notice_title + "\n\n" + "     " + notice_content + "\n\n\n" + "     "+ notice_date + "\n";
		
	}		  
    
}
