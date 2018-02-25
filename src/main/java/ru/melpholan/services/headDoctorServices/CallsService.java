package ru.melpholan.services.headDoctorServices;

import org.hibernate.Session;
import ru.melpholan.entity.DoctorsErrors;
import ru.melpholan.entity.ResultOfDoctorsCalls;

import java.sql.Date;

public interface CallsService {

    void createCall(Session session, Date date, String personal, DoctorsErrors doctorsErrors, ResultOfDoctorsCalls result);

}
