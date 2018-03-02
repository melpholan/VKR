package ru.melpholan.DAO.Impl;

import ru.melpholan.DAO.PassportDAO;
import ru.melpholan.entity.Passport;

public class PassportDAOImpl extends GenericDAOImpl<Passport, Integer> implements PassportDAO {

    public PassportDAOImpl(Class<Passport> clazz) {
        super(clazz);
    }
}
