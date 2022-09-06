package removier.mvc.view;


import removier.mvc.dto.User;


import java.util.List;

public class EndView {
    /**
     * 회원정보 전부 출력
     * */
    public static void printUserAllList(List<User> list){

        System.out.println("-- 회원수 : "+list.size()+" 명 --");
        for(User user : list){
            System.out.println(user);
        }
        System.out.println();
    }
}
