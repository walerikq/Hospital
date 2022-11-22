package com.walerikq.hospital.controller;

import com.walerikq.hospital.PersonDto.PersonDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.service.PersonService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.awt.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private List<Patient> diseases;

    @GetMapping("/get-person")
    public List<Patient> getAllPerson(){
        return diseases;
    }

    @PostMapping("/post-info")
    public void informationTransfer(){

    }

    @PutMapping("/put-info")
    public void changeInformation(List<Patient> person){

    }

    @DeleteMapping("/delete-person")
    public void deletePersonOnList(java.util.List<PersonDto> person){

    }
}
