package com.walerikq.hospital.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionResponse {

    private Integer status;
    private String message;

}
