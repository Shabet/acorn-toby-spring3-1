package springbook.user.dao.v7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoV7TestTest {

    @BeforeEach
    void beforeEach() throws SQLException, ClassNotFoundException {
        UserDaoV7 dao = new DaoFactory().userDao();

        dao.delete("whiteship");
    }

    @AfterEach
    void afterEach() throws SQLException, ClassNotFoundException {
        UserDaoV7 dao = new DaoFactory().userDao();

        dao.delete("whiteship");
    }

    @Test
    void test() throws ClassNotFoundException, SQLException {
        //given
        UserDaoV7 dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        //when
        User user2 = dao.get(user.getId());

        //then
        Assertions.assertThat(user.getId()).isEqualTo(user2.getId());
        Assertions.assertThat(user.getName()).isEqualTo(user2.getName());
        Assertions.assertThat(user.getPassword()).isEqualTo(user2.getPassword());
    }

    @Test
    void 오브젝트비교() throws ClassNotFoundException, SQLException {
        DaoFactory factory = new DaoFactory();
        UserDaoV7 dao1 = factory.userDao();
        UserDaoV7 dao2 = factory.userDao();

        System.out.println("dao1 = " + dao1);
        System.out.println("dao2 = " + dao2);

        Assertions.assertThat(dao1).isNotEqualTo(dao2);
    }

    @Test
    void 스프링오브젝트비교() throws ClassNotFoundException, SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDaoV7 dao3 = context.getBean("userDao", UserDaoV7.class);
        UserDaoV7 dao4 = context.getBean("userDao", UserDaoV7.class);

        System.out.println("dao3 = " + dao3);
        System.out.println("dao4 = " + dao4);

        Assertions.assertThat(dao3).isEqualTo(dao4);
    }
}