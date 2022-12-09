package com.walerikq.hospital.PersonDto;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

//TODO 10.12 пакет называется не очень удачно. лучше назвать его просто dto

@Data
@AllArgsConstructor

public class PatientDto {
    //String name,String surname,String patronymic, short age, String diseases,PatientsStatus status

    private int id; //TODO 10.12 в объектах-хранилищах я предпочитаю использовать объекты - с примитивами могут быть проблемы потому что примитивы не могут быть null
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String patronymic;

    private short age; //TODO 10.12 шорт интересный выбор, но обычно используют Integer. Можно оставить шорт, но тогда лучше Short как объект
    private String diseases;
    private PatientsStatus status;

}
