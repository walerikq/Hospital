package com.walerikq.hospital.controller;

import com.walerikq.hospital.PersonDto.PersonDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.repository.PatientRepo;
import com.walerikq.hospital.service.PatientsStatus;
import com.walerikq.hospital.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private PatientRepo patientRepo;
    private final PersonService personService;

    @GetMapping("/get-person")
    public List<Patient> getAllPerson(){
        return patientRepo.getAllPatients();
    }

    @GetMapping("/get-patient-from-id")
    public Patient getPatientFromId(int id){
       Patient patient = patientRepo.getIdPatient(id);
        return patient;
    }

    @PostMapping("/create-new-patient")
    public void createNewPatient(String name,String surname,String patronymic, short age, String diseases,PatientsStatus status){
        personService.createPatient(name,surname,patronymic,age,diseases,status);
    }

    @GetMapping("/get-patients-with-status")
    public List<Patient> getPatientsWithStatus(){
        return personService.getPatientsWithStatus(patientRepo.getPatientList());
    }

    @PutMapping("/put-info")
    public void changeInformation(Patient patient,
                                  String name,String surname,String patronymic,
                                  short age, String diseases,PatientsStatus status){

        personService.changingPatientData(patient,name,surname,patronymic,age,diseases,status);

    }

    @DeleteMapping("/delete-person")
    public void deletePersonOnList(Patient patient){
        patientRepo.deletingPatientById(patient.getId());

    }
}
