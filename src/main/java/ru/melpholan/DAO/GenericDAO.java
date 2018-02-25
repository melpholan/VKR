package ru.melpholan.DAO;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO <T, PK extends Serializable> {

    Session getSession();
    void setSession(Session session);

    /** Сохранить объект newInstance в базе данных */
    PK create(T newInstance);

    /** Извлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа
     */
    T read(PK id);

    /** Сохранить изменения, сделанные в объекте.  */
    void update(T transientObject);

    /** Удалить объект из базы данных */
    void delete(T persistentObject);

    List<T> getAll();

}

