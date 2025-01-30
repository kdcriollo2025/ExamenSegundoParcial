package com.arquitectura.examen.segundoparcial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.arquitectura.examen.segundoparcial.service.SegundoParcialService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.arquitectura.examen.segundoparcial.controller.dto.SegundoParcialDTO;
import com.arquitectura.examen.segundoparcial.controller.mapper.SegundoParcialMapperNew;
import com.arquitectura.examen.segundoparcial.model.SegundoParcial;
import com.arquitectura.examen.segundoparcial.exception.NotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1/segundoparcial")
public class SegundoParcialController {

    private final SegundoParcialService service;
    private final SegundoParcialMapperNew mapper;

    public SegundoParcialController(SegundoParcialService service, SegundoParcialMapperNew mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<SegundoParcialDTO>> getAllSegundoParcial() {
        List<SegundoParcial> records = this.service.findAll();
        List<SegundoParcialDTO> dtos = new ArrayList<>(records.size());

        for (SegundoParcial sp : records) {
            dtos.add(mapper.toDTO(sp));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SegundoParcialDTO> getSegundoParcialById(@PathVariable("id") String id) {
        try {
            SegundoParcial sp = this.service.findById(id);
            return ResponseEntity.ok(this.mapper.toDTO(sp));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SegundoParcialDTO> getSegundoParcialByName(@PathVariable("name") String name) {
        try {
            SegundoParcial sp = this.service.findByName(name);
            return ResponseEntity.ok(this.mapper.toDTO(sp));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SegundoParcialDTO> createSegundoParcial(@RequestBody SegundoParcialDTO dto) {
        SegundoParcial sp = this.service.create(mapper.toModel(dto));
        return ResponseEntity.ok(mapper.toDTO(sp));
    }

    @PatchMapping("/{id}/update-field")
    public ResponseEntity<SegundoParcialDTO> updateField(@PathVariable("id") String id, @RequestParam String fieldValue) {
        try {
            SegundoParcial updated = this.service.updateField(id, fieldValue);
            return ResponseEntity.ok(this.mapper.toDTO(updated));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body("Error: " + ex.getMessage());
    }
}
