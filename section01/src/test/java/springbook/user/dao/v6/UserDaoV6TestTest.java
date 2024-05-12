package springbook.user.dao.v6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoV6TestTest {

    @BeforeEach
    void beforeEach() throws SQLException, ClassNotFoundException {
        UserDaoV6 dao = new DaoFactory().userDao();

        dao.delete("whiteship");
    }

    @AfterEach
    void afterEach() throws SQLException, ClassNotFoundException {
        UserDaoV6 dao = new DaoFactory().userDao();

        dao.delete("whiteship");
    }

    @Test
    void test() throws ClassNotFoundException, SQLException {
        //given
        UserDaoV6 dao = new DaoFactory().userDao();

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
}