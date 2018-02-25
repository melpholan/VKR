package ru.melpholan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import ru.melpholan.DAO.Impl.CallsDAOImpl;
import ru.melpholan.entity.Calls;
import ru.melpholan.utils.HibernateUtil;

public class CallsTest {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;
    private CallsDAO callsDAO = new CallsDAOImpl(Calls.class);

    @Before
    public  void configure() {
        session = sessionFactory.openSession();
        callsDAO.setSession(session);
        System.out.println("Before");
    }

    @After
    public void afterShift(){
        System.out.println("After");
        session.close();
    }
}
