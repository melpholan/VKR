package ru.melpholan.DAO.Impl;


import org.hibernate.Session;
import ru.melpholan.DAO.GenericDAO;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAOImpl <T, PK extends Serializable>
        implements GenericDAO<T, PK> {

    protected Session session;

    Class<T> type;

    public GenericDAOImpl(Class<T> clazz){
        type = clazz;
    }


    public void setSession(Session session) { this.session = session; }

    public Session getSession(){ return session; }


    @Override
    public PK create(T newInstance) {
        PK pk = (PK)session.save(newInstance);
        return pk;
    }

    @Override
    public T read(PK id) { return session.get(type, id); }

    @Override
    public void update(T transientObject) { session.update(transientObject); }

    @Override
    public void delete(T persistentObject) { session.delete(persistentObject); }

    @Override
    public  List<T> getAll()
    {
        List<T> list = session.createQuery("from " + type.getName() + " p ").list();
        return list;
    }
}