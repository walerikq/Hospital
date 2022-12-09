package com.walerikq.hospital.entity;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    private int id;
    private String name;
    private String surname;
    private String patronymic;

    private short age;
    private String diseases;
    private PatientsStatus status;
}
