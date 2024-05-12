package springbook.user.dao.v5;

public class DaoFactory {
    public UserDaoV5 userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return new UserDaoV5(connectionMaker);
    }
}
