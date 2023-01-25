package com.walerikq.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder

public class Patient {
    private UUID uuid;
    private String name;
    private String surname;
    private String patronymic;

    @NotBlank
    @Max(130)@Min(0)
    private Integer age;
    private String diseases;
    private String status;
}
