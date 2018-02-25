package ru.melpholan;

import org.junit.Test;
import sun.util.calendar.Gregorian;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class Testclass {

    @Test
    public void getDate() throws ParseException {
        Date jud = new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-12");
        java.sql.Date sqd = java.sql.Date.valueOf("2211-11-21");
        Gregorian cal = LocalGregorianCalendar.getGregorianCalendar();
        java.time.LocalDate ld = LocalDate.of(2099,11,11);
        System.out.println(ld);
        System.out.println(sqd);
        System.out.println(cal);

    }




}
