package nur.p3.patrondao.dao;

public class FactoryDaoSingleton {
    private static FactoryDao factoryDao = null;

    private FactoryDaoSingleton() {
    }

    public static FactoryDao getFactoryDao() {
        if (factoryDao == null) {
            factoryDao = new FactoryDaoMySql();
        }
        return factoryDao;
    }
}
