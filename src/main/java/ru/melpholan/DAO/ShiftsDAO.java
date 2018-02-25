package ru.melpholan.DAO;

import ru.melpholan.entity.Personal;
import ru.melpholan.entity.Shifts;

import java.sql.Date;
import java.util.List;

public interface ShiftsDAO extends GenericDAO<Shifts, Long>{

    List<Shifts> findShiftsByPerson(Personal personal);
    List<Shifts> findShiftsByDate(Date date);
    List<Shifts> findShiftsByPeriod(Date begin, Date end);

}
