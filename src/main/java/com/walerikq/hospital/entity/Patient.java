package com.walerikq.hospital.entity;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
@Builder

public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;

    @NotBlank
    @Max(130)@Min(0)
    private Integer age;
    private String diseases;
    private PatientsStatus status;
}
