package ru.melpholan.services.chiefServices;

import ru.melpholan.DAO.PassportDAO;
import ru.melpholan.DAO.PersonalDAO;
import ru.melpholan.entity.Passport;
import ru.melpholan.entity.Personal;

public interface PersonalService {

    PersonalDAO getPersonalDAO();

    void setPassportDAO(PassportDAO passportDAO);
    void setPersonalDAO(PersonalDAO personalDAO);

    Integer createPersonal(Personal personal);
    Personal findPersonal(Personal personal);
    void updatePersonal(Personal personal, String name, String surname, String patronymic);

    void addPassport(Personal personal, Passport passport);
    void createAddress();
    void createContacts();
}
