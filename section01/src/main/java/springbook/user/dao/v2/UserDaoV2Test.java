package springbook.user.dao.v2;

import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoV2Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDaoV2 dao = new UserDaoV2();

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

        dao.delete("whiteship");
        System.out.println(user.getId() + " 삭제 성공");
    }
}
