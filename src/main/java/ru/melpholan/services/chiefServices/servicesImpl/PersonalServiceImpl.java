package ru.melpholan.services.chiefServices.servicesImpl;

import ru.melpholan.DAO.PassportDAO;
import ru.melpholan.DAO.PersonalDAO;
import ru.melpholan.entity.Passport;
import ru.melpholan.entity.Personal;
import ru.melpholan.services.chiefServices.PersonalService;

public class PersonalServiceImpl implements PersonalService{

    private PersonalDAO personalDAO;
    private PassportDAO passportDAO;


    @Override
    public PersonalDAO getPersonalDAO() {
        return this.personalDAO;
    }

    @Override
    public void setPassportDAO(PassportDAO passportDAO) {
        this.passportDAO = passportDAO;
    }

    @Override
    public void setPersonalDAO(PersonalDAO personalDAO) {
        this.personalDAO = personalDAO;
    }



    @Override
    public Integer createPersonal(Personal personal) {

        Integer PK = personalDAO.create(personal);
        return PK;

    }

    @Override
    public Personal findPersonal(Personal personal) {
        Personal findedPersonal;

        System.out.println("PERSONAL NAME = "+ personal.getName());

//        if(personal.getSurname() != null){
//            findedPersonal = personalDAO.findPersonalByFullName(personal.getName(), personal.getSurname());
//
//        }else {
//
//            findedPersonal = personalDAO.findPersonByName(personal.getName());
//        }

        findedPersonal = personalDAO.findPersonByName(personal.getName());

        System.out.println("PERSONAL NAME = "+ personal.getName());
        return findedPersonal;

    }

    @Override
    public void updatePersonal(Personal personal, String name, String surname, String patronymic) {

        Personal personal1 = findPersonal(personal);
        personal1.setName(name);
        if(surname != null){
            personal1.setSurname(surname);
        }
        if(patronymic != null){
            personal1.setPatronymic(patronymic);
        }
        personalDAO.update(personal1);

    }

    @Override
    public void addPassport(Personal personal, Passport passport) {

        Personal personal1 = findPersonal(personal);
        Passport passport1 = personal1.getPassport();

        if(passport1 != null){
            passport1.setBirthsday(passport.getBirthsday());
            passport1.setLastDateOfWorkLicense(passport.getLastDateOfWorkLicense());
            passport1.setDateOfEmployment(passport.getDateOfEmployment());
            passport1.setDateOfDimissal(passport.getDateOfDimissal());
            passportDAO.update(passport1);
          //  personal1.setPassport(passport1);
          //  personalDAO.update(personal1);
        }
        personal1.setPassport(passport);
        personalDAO.update(personal1);

    }

    @Override
    public void createAddress() {

    }

    @Override
    public void createContacts() {

    }
}
