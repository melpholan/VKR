package ru.melpholan.DAO;

import ru.melpholan.entity.Calls;
import ru.melpholan.entity.Personal;

import java.sql.Date;
import java.util.List;

public interface CallsDAO extends GenericDAO<Calls, Long> {

    List findByDate(Date date);
    List<Calls> findByPerson(Personal person);
    List<Calls> findByResultType(Integer resultType);
    List<Calls> findByErrorType(Integer errorType);
}
