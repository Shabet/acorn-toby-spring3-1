package springbook.user.dao.v0;

import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoV0Test {

    public static void main(String[] args) {
        UserDaoV0 dao = new UserDaoV0();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        try {
            dao.add(user);
            System.out.println(user.getId() + " 등록 성공");

            User user2 = dao.get(user.getId());
            System.out.println("user2.name = " + user2.getName());
            System.out.println("user2.password = " + user2.getPassword());
            System.out.println(user.getId() + " 조회 성공");

            dao.delete("whiteship");
            System.out.println(user.getId() + " 삭제 성공");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
