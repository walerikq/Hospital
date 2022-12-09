package com.walerikq.hospital.entity;

import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    private int id; //TODO 10.12 в объектах-хранилищах я предпочитаю использовать объекты - с примитивами могут быть проблемы потому что примитивы не могут быть null
    private String name;
    private String surname;
    private String patronymic;

    private short age; //TODO 10.12 шорт интересный выбор, но обычно используют Integer. Можно оставить шорт, но тогда лучше Short как объект
    private String diseases;
    private PatientsStatus status;
}
