package com.arquitectura.examen.segundoparcial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arquitectura.examen.segundoparcial.service.SegundoParcialService;
import com.arquitectura.examen.segundoparcial.controller.dto.SegundoParcialDTO;
import com.arquitectura.examen.segundoparcial.controller.mapper.SegundoParcialMapperNew;
import com.arquitectura.examen.segundoparcial.model.SegundoParcial;
import com.arquitectura.examen.segundoparcial.exception.NotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1/segundoparcial")
public class SegundoParcialController {

    private final SegundoParcialService service;
    private final SegundoParcialMapperNew mapper;

    public SegundoParcialController(SegundoParcialService segundoParcialService, SegundoParcialMapperNew segundoParcialMapper) {
        this.service = segundoParcialService;
        this.mapper = segundoParcialMapper;
    }

    
    @GetMapping
    public ResponseEntity<List<SegundoParcialDTO> getAllSegundoParcial() {
        List<SegundoParcial> accounts = this.service.findAll();
        List<SegundoParcialDTO> dtos = new ArrayList<>(accounts.size());
        
        for (SegundoParcial sp : parcial) {
            dtos.add(mapper.toDTO(sp));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{a}")
    public ResponseEntity<SegundoParcialDTO> getSegundoParcialById(@PathVariable("a") String id) {
        try {
            SegundoParcial ca = this.service.findById(id);
            return ResponseEntity.ok(this.mapper.toDTO(sp));
        } catch (NotFoundException nfe) {
            System.err.println(nfe.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SegundoParcialDTO> getSegundoParcialByNumber(@PathVariable("name") String name) {
        SegundoParcial sp = this.service.findByName(name);
        return ResponseEntity.ok(this.mapper.toDTO(sp));
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity notFound() {
        System.err.println("No encotro");
        return ResponseEntity.notFound().build();
    }


    
}
