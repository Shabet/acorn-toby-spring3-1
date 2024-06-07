package springbook.user.dao.v0;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoV0Test {

    @BeforeEach
    void beforeEach() throws SQLException, ClassNotFoundException {
        UserDaoV0 dao = new UserDaoV0();

        dao.delete("whiteship");
    }

    @AfterEach
    void afterEach() throws SQLException, ClassNotFoundException {
        UserDaoV0 dao = new UserDaoV0();

        dao.delete("whiteship");
    }

    @Test
    void test() throws ClassNotFoundException, SQLException {
        //given
        UserDaoV0 dao = new UserDaoV0();

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