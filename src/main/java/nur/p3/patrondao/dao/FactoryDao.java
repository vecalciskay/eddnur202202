package nur.p3.patrondao.dao;

import nur.p3.patrondao.shared.DaoException;

public interface FactoryDao {
    public abstract PersonaDao getPersonaDao() throws DaoException;
}
