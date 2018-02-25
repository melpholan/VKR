package ru.melpholan.services.headDoctorServices.servicesImpl;

import org.hibernate.Session;
import ru.melpholan.DAO.CallsDAO;
import ru.melpholan.DAO.Impl.CallsDAOImpl;
import ru.melpholan.DAO.Impl.PersonalDAOImpl;
import ru.melpholan.DAO.PersonalDAO;
import ru.melpholan.entity.Calls;
import ru.melpholan.entity.DoctorsErrors;
import ru.melpholan.entity.Personal;
import ru.melpholan.entity.ResultOfDoctorsCalls;
import ru.melpholan.services.headDoctorServices.CallsService;

import java.sql.Date;

public class CallsServiceImpl implements CallsService{

    //Session session;

    @Override
    public void createCall(Session session, Date date, String personalName,
                           DoctorsErrors doctorsErrors, ResultOfDoctorsCalls result) {

        CallsDAO callsDAO = new CallsDAOImpl(Calls.class);
        callsDAO.setSession(session);

        PersonalDAO personalDAO = new PersonalDAOImpl(Personal.class);
        personalDAO.setSession(session);
        Personal personal = personalDAO.findPersonByName(personalName);

        Calls call = new Calls();
        call.setDateOfCall(date);
        call.setPersonal(personal);
        call.setDoctorsErrors(doctorsErrors);
        call.setResultOfDoctorsCalls(result);
        callsDAO.create(call);

    }

}
