package removier.mvc.dto;

public abstract class Member {
    private int member_pk; // PK
    private String member_name;
    private String logingId; // 로그인 아이디
    private String password;
    private int role; // 0: Admin  1 : User

    public Member(String logingId, String password) {
        this.logingId = logingId;
        this.password = password;
    }

    public Member() {
    }

    public int getMember_pk() {
        return member_pk;
    }

    public String getMember_name() {
        return member_name;
    }

    public String getLogingId() {
        return logingId;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public Member(int member_pk, String member_name, String logingId, String password, int role) {
        this.member_pk = member_pk;
        this.member_name = member_name;
        this.logingId = logingId;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {


        return member_pk +" | "+ member_name +" | "+ logingId +" | "+password +" | "+ role;

    }
}
