package ru.melpholan.DAO.Impl;

import org.hibernate.Query;
import ru.melpholan.DAO.PersonalDAO;
import ru.melpholan.entity.Personal;

public class PersonalDAOImpl  extends GenericDAOImpl<Personal,Integer> implements PersonalDAO{

    //private Session session;
    public PersonalDAOImpl(Class<Personal> clazz) {
        super(clazz);
    }

    @Override
    public Personal findPersonByName(String name) {

        Query query = session.createQuery("from Personal p where p.name = :name");
        query.setParameter("name", name);
        return (Personal) query.uniqueResult();
    }

    @Override
    public Personal findPersonalByFullName(String name, String surname) {
        Query query = session.createQuery("from Personal p where p.name = :name and p.surname = :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return (Personal) query.uniqueResult();
    }

}
