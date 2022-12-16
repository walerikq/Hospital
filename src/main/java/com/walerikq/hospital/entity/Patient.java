package com.walerikq.hospital.entity;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;

    private Byte age;
    private String diseases;
    private PatientsStatus status;
}
