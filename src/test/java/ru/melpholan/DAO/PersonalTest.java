package ru.melpholan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.melpholan.DAO.Impl.PersonalDAOImpl;
import ru.melpholan.entity.Personal;
import ru.melpholan.utils.HibernateUtil;

public class PersonalTest {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;
    private PersonalDAOImpl personalDAO = new PersonalDAOImpl(Personal.class);

    @Before
    public  void configure() {
        session = sessionFactory.openSession();
        personalDAO.setSession(session);
        System.out.println("Before");
    }

    @After
    public void afterShift(){
        System.out.println("After");
        session.close();
    }

    @Test
    public void test1(){
        Personal personal = new Personal();
        personal.getIdPersonal();
    }

    @Test
    public void test2(){
        System.out.println("OK-2");
    }

    @AfterClass
    public static void closeShiftsTest(){
        System.out.println("AfterClass");
        HibernateUtil.destroy();
    }
}
