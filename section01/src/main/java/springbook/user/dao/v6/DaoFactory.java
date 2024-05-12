package springbook.user.dao.v6;

public class DaoFactory {
    public UserDaoV6 userDao() {
        return new UserDaoV6(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
