package com.arquitectura.examen.segundoparcial.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class SegundoParcialDTO {

    private String id;
    private String emailAdress;
    private String name;
    private String phoneNumber;
    private String state;
    private LocalDate creationDate;
    private LocalDateTime lastModifiedDate;
    private List<BranchHolidayDTO> branchHoliday;

}
