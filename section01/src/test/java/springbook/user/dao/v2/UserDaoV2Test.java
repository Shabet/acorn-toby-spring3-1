package springbook.user.dao.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springbook.user.dao.v2.UserDaoV2;
import springbook.user.domain.User;

import java.sql.SQLException;

class UserDaoV2Test {

    @BeforeEach
    void beforeEach() throws SQLException, ClassNotFoundException {
        UserDaoV2 dao = new UserDaoV2();

        dao.delete("whiteship");
    }

    @AfterEach
    void afterEach() throws SQLException, ClassNotFoundException {
        UserDaoV2 dao = new UserDaoV2();

        dao.delete("whiteship");
    }

    @Test
    void test() throws ClassNotFoundException, SQLException {
        //given
        UserDaoV2 dao = new UserDaoV2();

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