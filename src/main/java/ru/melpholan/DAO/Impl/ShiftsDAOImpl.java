package ru.melpholan.DAO.Impl;

import ru.melpholan.DAO.ShiftsDAO;
import ru.melpholan.entity.Shifts;

public class ShiftsDAOImpl extends GenericDAOImpl<Shifts, Long>  implements ShiftsDAO {

    public ShiftsDAOImpl(Class<Shifts> clazz) {
        super(clazz);
    }
}
