package springbook.user.dao.v1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springbook.user.dao.v1.DUserDaoV1;
import springbook.user.domain.User;

import java.sql.SQLException;


class DUserDaoV1Test {

    @BeforeEach
    void beforeEach() throws SQLException, ClassNotFoundException {
        DUserDaoV1 dao = new DUserDaoV1();

        dao.delete("whiteship");
    }


    @AfterEach
    void afterEach() throws SQLException, ClassNotFoundException {
        DUserDaoV1 dao = new DUserDaoV1();

        dao.delete("whiteship");
    }

    @Test
    void test() throws ClassNotFoundException, SQLException {
        //given
        DUserDaoV1 dao = new DUserDaoV1();

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