package com.walerikq.hospital.PersonDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PersonDto {

//Dto - это Data Trasfer Object
// Не содержит никакой внутренней логики, она используется только для транспортировки данных

    private int id;
    private String name;
    private short age;
    private String diseases;

}
