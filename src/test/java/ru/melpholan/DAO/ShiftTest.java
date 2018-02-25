package ru.melpholan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;
import ru.melpholan.DAO.Impl.ShiftsDAOImpl;
import ru.melpholan.entity.ShiftTypes;
import ru.melpholan.entity.Shifts;
import ru.melpholan.utils.HibernateUtil;

public class ShiftTest {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;
    private ShiftsDAO shiftsDAO = new ShiftsDAOImpl(Shifts.class);

    @Before
    public  void configure() {
        session = sessionFactory.openSession();
        shiftsDAO.setSession(session);
        System.out.println("Before");
    }

    @After
    public void afterShift(){
        System.out.println("After");
        session.close();
    }

    @Test
    public void test1(){

        System.out.println("OK-1");
        Shifts read = shiftsDAO.read(1L);
        ShiftTypes shiftTypes = read.getShiftTypes();
        System.out.println(shiftTypes);
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
