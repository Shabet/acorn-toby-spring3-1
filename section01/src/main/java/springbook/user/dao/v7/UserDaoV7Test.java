package springbook.user.dao.v7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoV7Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//        UserDaoV7 dao = (UserDaoV7) context.getBean("userDao");
        UserDaoV7 dao = context.getBean("userDao", UserDaoV7.class);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println("user2.name = " + user2.getName());
        System.out.println("user2.password = " + user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
