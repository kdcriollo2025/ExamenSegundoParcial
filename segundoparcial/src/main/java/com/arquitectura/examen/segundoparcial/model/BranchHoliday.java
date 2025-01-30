package com.arquitectura.examen.segundoparcial.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BranchHoliday {
    private LocalDate date;
    private String name;
} 