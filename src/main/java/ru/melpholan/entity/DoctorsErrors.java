package ru.melpholan.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DoctorsErrors")
public class DoctorsErrors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDoctorsErrors", nullable = false)
    private Integer idDoctorsErrors;

    public Integer getIdDoctorsErrors() {
        return idDoctorsErrors;
    }

    public void setIdDoctorsErrors(Integer idDoctorsErrors) {
        this.idDoctorsErrors = idDoctorsErrors;
    }

    @Column(name = "errorsCharacter", nullable = false)
    private String errorsCharacter;

    public String getErrorsCharacter() {
        return errorsCharacter;
    }

    public void setErrorsCharacter(String errorsCharacter) {
        this.errorsCharacter = errorsCharacter;
    }

    @Column(name = "errorScales", nullable = false)
    private Integer errorScale;

    public Integer getErrorScale() {
        return errorScale;
    }

    public void setErrorScale(Integer errorScale) {
        this.errorScale = errorScale;
    }

    public DoctorsErrors() {
    }

    public DoctorsErrors(String errorsCharacter, Integer errorScale) {
        this.errorsCharacter = errorsCharacter;
        this.errorScale = errorScale;
    }
}
