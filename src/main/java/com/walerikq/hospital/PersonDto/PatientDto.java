package com.walerikq.hospital.PersonDto;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor

public class PatientDto {
    //String name,String surname,String patronymic, short age, String diseases,PatientsStatus status

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
