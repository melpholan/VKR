package ru.melpholan.DAO;

import ru.melpholan.entity.Personal;


public interface PersonalDAO extends GenericDAO<Personal,Integer>{

    Personal findPersonByName(String name);
    Personal findPersonalByFullName(String name, String surname);

}
