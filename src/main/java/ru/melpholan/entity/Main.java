package ru.melpholan.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.LoggerFactory;
import ru.melpholan.DAO.Impl.PersonalDAOImpl;
import ru.melpholan.DAO.PersonalDAO;
import ru.melpholan.services.chiefServices.PersonalService;
import ru.melpholan.services.chiefServices.servicesImpl.PersonalServiceImpl;
import ru.melpholan.utils.HibernateUtil;


public class Main {

   // private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        log.debug("Debug message");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        PersonalDAO personalDAO = new PersonalDAOImpl(Personal.class);
        personalDAO.setSession(session);
        PersonalService personalService = new PersonalServiceImpl();
        personalService.setPersonalDAO(personalDAO);




        Transaction tx = session.beginTransaction();

        if(tx.getStatus() == TransactionStatus.ACTIVE) {

            Personal p = new Personal();
            p.setName("Райков");
            Personal personal = personalService.findPersonal(p);
            System.out.println(personal);
//            for (Personal personal : personalDAO.getAll()) {
//                System.out.println(personal);
//            }
//            ;
//            log.error("SesIOM "+ session.isOpen());
//            Personal personal = personalDAO.read(1);
//            System.out.println(personal);


//            Personal personByName = personalDAO.findPersonByName("Райков");
//            if(personByName !=null){
//                System.out.println(personByName);
//            }
//            else {
//                System.out.println("person null");
//            }

            tx.commit();
        }

        if (session != null && session.isOpen()) {

            session.close();


        }
        HibernateUtil.destroy();
    }


}


