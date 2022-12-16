package com.walerikq.hospital.Dto;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

//TODO 10.12 пакет называется не очень удачно. лучше назвать его просто dto

@Data
@AllArgsConstructor

public class PatientDto {

    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String patronymic;

    @NotBlank
    private Byte age;
    private String diseases;
    private PatientsStatus status;

}
