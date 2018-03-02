package ru.melpholan.servies.chiefServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.melpholan.DAO.Impl.PassportDAOImpl;
import ru.melpholan.DAO.Impl.PersonalDAOImpl;
import ru.melpholan.DAO.PassportDAO;
import ru.melpholan.DAO.PersonalDAO;
import ru.melpholan.entity.Passport;
import ru.melpholan.entity.Personal;
import ru.melpholan.services.chiefServices.PersonalService;
import ru.melpholan.services.chiefServices.servicesImpl.PersonalServiceImpl;
import ru.melpholan.utils.HibernateUtil;

public class TestPersonal {

    static final Logger log = LoggerFactory.getLogger(TestPersonal.class);

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session;
    private static final PassportDAO passportDAO = new PassportDAOImpl(Passport.class);
    private static final PersonalDAO personalDAO = new PersonalDAOImpl(Personal.class);


    PersonalService personalService = new PersonalServiceImpl();


    @Before
    public   void configure() {
        session = sessionFactory.openSession();
        personalDAO.setSession(session);
        passportDAO.setSession(session);
        System.out.println("Before");
    }

    @Test
    public void createPersonalTest(){

        personalService.setPersonalDAO(personalDAO);
//        Personal personal = new Personal();
//        personal.setName("IVANOV");

//        Personal PK = personalService.findPersonal(personal);

//        Personal personal = new Personal();
//        personal.setName("IVANOV");
//        personal.setSurname("IVaNN");
//        Integer PK = personalService.createPersonal(personal);
//        log.error(""+PK);
//        System.out.println(PK);
        Personal personal = personalDAO.read(71);
        System.out.println(personal.getSurname());
        System.out.println(personal.getSurname() == null);

    }

    @After
    public void afterShift(){
        System.out.println("After");
        session.close();
    }

}
