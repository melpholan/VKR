package ru.melpholan.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Calls")
public class Calls implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalls")
    private Integer idCalls;

    public Integer getIdCalls() {
        return idCalls;
    }

    public void setIdCalls(Integer idCalls) {
        this.idCalls = idCalls;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfCall")
    private Date dateOfCall;

    public Date getDateOfCall() {
        return dateOfCall;
    }

    public void setDateOfCall(Date dateOfCall) {
        this.dateOfCall = dateOfCall;
    }

    @ManyToOne
    @JoinColumn(name = "Personal_idPersonal")
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @ManyToOne
    @JoinColumn(name = "DoctorsErrors_idDoctorsErrors")
    private DoctorsErrors doctorsErrors;

    public DoctorsErrors getDoctorsErrors() {
        return doctorsErrors;
    }

    public void setDoctorsErrors(DoctorsErrors doctorsErrors) {
        this.doctorsErrors = doctorsErrors;
    }

    @ManyToOne
    @JoinColumn(name = "ResultOfDoctorsCalls_idResultOfDoctorCalls")
    private ResultOfDoctorsCalls resultOfDoctorsCalls;

    public ResultOfDoctorsCalls getResultOfDoctorsCalls() {
        return resultOfDoctorsCalls;
    }

    public void setResultOfDoctorsCalls(ResultOfDoctorsCalls resultOfDoctorsCalls) {
        this.resultOfDoctorsCalls = resultOfDoctorsCalls;
    }

    public Calls() {
    }

    public Calls(Date dateOfCall, Personal personal, DoctorsErrors doctorsErrors, ResultOfDoctorsCalls resultOfDoctorsCalls) {
        this.dateOfCall = dateOfCall;
        this.personal = personal;
        this.doctorsErrors = doctorsErrors;
        this.resultOfDoctorsCalls = resultOfDoctorsCalls;
    }
}
