package ru.melpholan.DAO.Impl;

import org.hibernate.Query;
import ru.melpholan.DAO.ShiftsDAO;
import ru.melpholan.entity.Personal;
import ru.melpholan.entity.Shifts;

import java.sql.Date;
import java.util.List;

public class ShiftsDAOImpl extends GenericDAOImpl<Shifts, Long>  implements ShiftsDAO {

    public ShiftsDAOImpl(Class<Shifts> clazz) {
        super(clazz);
    }

    @Override
    public List<Shifts> findShiftsByPerson(Personal personal) {
        Query query = session.createQuery("from Shifts s where s.personal = :person");
        query.setParameter("person", personal);
        return query.list();

    }

    @Override
    public List<Shifts> findShiftsByDate(Date date) {
        Query query = session.createQuery("from Shifts s where s.workDate = :date");
        query.setParameter("date", date);
        return query.list();

    }

    @Override
    public List<Shifts> findShiftsByPeriod(Date begin, Date end) {
        Query query = session.createQuery("from Shifts s where s.workDate between :begin and :end");
        query.setParameter("begin", begin);
        query.setParameter("end", end);
        return query.list();
    }
}
