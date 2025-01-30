package com.arquitectura.examen.segundoparcial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arquitectura.examen.segundoparcial.db.DB;
import com.arquitectura.examen.segundoparcial.exception.NotFoundException;
import com.arquitectura.examen.segundoparcial.model.SegundoParcial;

@Service
public class SegundoParcialService {

    public static final String ENTITY_NAME = "Segundo Parcial";

    public List<SegundoParcial> findAll() {
        List<SegundoParcial> accounts = DB.parcial;
        return accounts;
    }

    public SegundoParcial findById(String id) {
        SegundoParcial sp = DB.findByPK(id);
        if (sp == null) {
            throw new NotFoundException(id, ENTITY_NAME);
        } else {
            return sp;
        }
    }

    public SegundoParcial findByName(String name) {
        SegundoParcial sp = DB.findByAccountNumber(name);
        if (sp == null) {
            throw new NotFoundException(name, ENTITY_NAME);
        } else {
            return sp;
        }
    }

    public SegundoParcial create(SegundoParcial model) {

        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    public SegundoParcial updateField(String id, String fieldValue) {

        throw new UnsupportedOperationException("Unimplemented method 'updateField'");
    }

}
