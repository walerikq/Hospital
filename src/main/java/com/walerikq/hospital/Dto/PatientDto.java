package com.walerikq.hospital.Dto;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Data
@AllArgsConstructor

public class PatientDto {

    private UUID uuid;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String patronymic;

    @NotBlank
    @Max(130)@Min(0)
    private Integer age;
    private String diseases;
    private PatientsStatus status;

}
