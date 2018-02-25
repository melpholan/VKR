package ru.melpholan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.melpholan.entity.DoctorsErrors;
import ru.melpholan.entity.ResultOfDoctorsCalls;
import ru.melpholan.services.headDoctorServices.CallsService;
import ru.melpholan.services.headDoctorServices.servicesImpl.CallsServiceImpl;
import ru.melpholan.utils.HibernateUtil;

import java.sql.Date;

public class CallsTest {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;
    //private CallsDAO callsDAO = new CallsDAOImpl(Calls.class);

    @Before
    public  void configure() {
        session = sessionFactory.openSession();
       // callsDAO.setSession(session);
        System.out.println("Before");
    }

    @Test
    public void createCall(){
        DoctorsErrors doctorsErrors = (DoctorsErrors)
                session.createQuery("from DoctorsErrors de where de.idDoctorsErrors = 2").uniqueResult();
        ResultOfDoctorsCalls result = (ResultOfDoctorsCalls)
                session.createQuery("from ResultOfDoctorsCalls dc where dc.idResultOfDoctorCalls=2").uniqueResult();
        CallsService callsService = new CallsServiceImpl();
        callsService.createCall(session,new Date(2018,12,12),"Райков", doctorsErrors,result);
    }

//    @Test
//    public void getCall(){
//        CallsDAO callsDAO = new CallsDAOImpl(Calls.class);
//        callsDAO.setSession(session);
//        Calls read = callsDAO.read((long) 2);
//        System.out.println(read);
//    }
//
//    @Test
//    public void getByDate(){
//        CallsDAO callsDAO = new CallsDAOImpl(Calls.class);
//        callsDAO.setSession(session);
//        List<Calls> byDate = callsDAO.findByDate(Date.valueOf("2009-01-12"));
//        for (Calls c: byDate
//             ) {
//            System.out.println(c);
//        }
//    }


    @After
    public void afterShift(){
        System.out.println("After");
        session.close();
    }
}
