package com.walerikq.hospital.entity;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Validated
@Data
public class Patient {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String patronymic;

    private short age;
    private String diseases;
    private PatientsStatus status;
}
