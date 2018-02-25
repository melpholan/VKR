package ru.melpholan.DAO.Impl;

import org.hibernate.Query;
import ru.melpholan.DAO.CallsDAO;
import ru.melpholan.entity.Calls;
import ru.melpholan.entity.Personal;

import java.sql.Date;
import java.util.List;

public class CallsDAOImpl extends GenericDAOImpl<Calls, Long> implements CallsDAO {

    public CallsDAOImpl(Class<Calls> clazz) {
        super(clazz);


    }

    @Override
    public List<Calls> findByDate(Date date) {
        org.hibernate.Query query = session.createQuery("from Calls cls where cls.dateOfCall= :date");
        query.setParameter("date", date);
        return query.list();
    }

    @Override
    public List<Calls> findByPerson(Personal person) {
        Query query = session.createQuery("from Calls cls where cls.personal = :personal");
        query.setParameter("personal", person);
        return query.list();
    }

    @Override
    public List<Calls> findByResultType(Integer resultType) {
        return null;
    }

    @Override
    public List<Calls> findByErrorType(Integer errorType) {
        return null;
    }
}
