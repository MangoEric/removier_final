package removier.mvc.dto;

/**
 * 관리자 계정
 */
public class Admin extends Member {
    public Admin(String logingId, String password) {
        super(logingId, password);
    }

    public Admin() {
    }

    public Admin(int id, String name, String logingId, String password, int role) {
        super(id, name, logingId, password, role = 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
