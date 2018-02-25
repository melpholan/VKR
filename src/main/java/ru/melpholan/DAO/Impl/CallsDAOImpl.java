package ru.melpholan.DAO.Impl;

import ru.melpholan.DAO.CallsDAO;
import ru.melpholan.entity.Calls;

public class CallsDAOImpl extends GenericDAOImpl<Calls, Long> implements CallsDAO {

    public CallsDAOImpl(Class<Calls> clazz) {
        super(clazz);


    }
}
