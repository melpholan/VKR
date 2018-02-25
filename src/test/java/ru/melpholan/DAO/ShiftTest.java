package ru.melpholan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.melpholan.DAO.Impl.PersonalDAOImpl;
import ru.melpholan.DAO.Impl.ShiftsDAOImpl;
import ru.melpholan.entity.Personal;
import ru.melpholan.entity.ShiftTypes;
import ru.melpholan.entity.Shifts;
import ru.melpholan.utils.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class ShiftTest {

    private static final Logger log = LoggerFactory.getLogger(ShiftTest.class);


    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;
    private ShiftsDAO shiftsDAO = new ShiftsDAOImpl(Shifts.class);

    @Before
    public  void configure() {
        session = sessionFactory.openSession();
        shiftsDAO.setSession(session);
        log.info("Before");
    }

    @After
    public void afterShift(){
        log.info("After");
        session.close();
    }

    @Test
    public void test1(){

        log.info("OK-1");
        System.out.println();
        Shifts read = shiftsDAO.read(1L);
        ShiftTypes shiftTypes = read.getShiftTypes();
        log.info(shiftTypes.toString());
    }

    @Test
    public void getShiftsByPerson(){
        PersonalDAO personalDAO = new PersonalDAOImpl(Personal.class);
        personalDAO.setSession(session);
        Personal p = personalDAO.read(1);
        log.info(p.toString());
        List<Shifts> shiftsByPerson = shiftsDAO.findShiftsByPerson(p);
        for (Shifts s:shiftsByPerson
             ) {

            log.info(s.toString());
        }
        log.info("OK-2");
    }

    @Test
    public void getBetweenDate(){

        Date begin = Date.valueOf("2016-12-12");
        Date end = Date.valueOf("2032-12-12");
        List<Shifts> shiftsByPeriod = shiftsDAO.findShiftsByPeriod(begin, end);
        for (Shifts s: shiftsByPeriod
             ) {
            log.info("OK-3");
            log.info(s.toString());
        }

    }

    @AfterClass
    public static void closeShiftsTest(){
        log.info("AfterClass");
        HibernateUtil.destroy();
    }
}
