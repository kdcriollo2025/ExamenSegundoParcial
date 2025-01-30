package com.arquitectura.examen.segundoparcial.db;

import com.arquitectura.examen.segundoparcial.model.SegundoParcial;
import com.arquitectura.examen.segundoparcial.model.BranchHoliday;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class DB {

    public static List<SegundoParcial> parcial = new ArrayList<>();

    static {
        SegundoParcial sp = new SegundoParcial();
        sp.setId("string");
        sp.setEmailAdress("string");
        sp.setName("string");
        sp.setPhoneNumber("string");
        sp.setState("string");
        sp.setCreationDate(LocalDate.parse("2016-09-06"));
        sp.setLastModifiedDate(LocalDateTime.parse("2016-09-06T13:00:00"));
        
        BranchHoliday holiday = new BranchHoliday();
        holiday.setDate(LocalDate.parse("1987-04-26"));
        holiday.setName("string");
        
        sp.setBranchHoliday(Arrays.asList(holiday));
        
        parcial.add(sp);
    }
   
}

public static SegundoParcial findByPK(String pk) {
    for (SegundoParcial sp : DB.parcial) {
        if (sp.getId().equals(pk)) {
            return sp;
        }
    }
    return null;
}

public static SegundoParcial findByAccountNumber(String Name) {
    for (SegundoParcial sp : DB.parcial) {
        if (sp.getName().equals(Name)) {
            return sp;
        }
    }
    return null;
}


