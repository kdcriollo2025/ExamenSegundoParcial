package com.arquitectura.examen.segundoparcial.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BranchHolidayDTO {
    private LocalDate date;
    private String name;
} 