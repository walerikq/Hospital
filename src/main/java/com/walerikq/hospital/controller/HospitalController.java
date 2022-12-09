package com.walerikq.hospital.controller;

import com.walerikq.hospital.PersonDto.PatientDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.repository.PatientRepo;
import com.walerikq.hospital.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public Patient getPatientById(int id){
       Patient patient = patientRepo.getIdPatient(id);
        return patient;
    }

    @PostMapping("/create-new-patient")
    public void createNewPatient(@RequestBody PatientDto personDto){
        personService.createPatient(personDto);
    }

    @GetMapping("/get-patients-with-status")
    public List<Patient> getPatientsWithStatus(){
        return personService.getPatientsWithStatus(patientRepo.getPatientList());
    }

    @PutMapping("/put-info")
    public void changeInformation(PatientDto personDto){

        personService.changingPatientData(personDto);

    }

    @DeleteMapping("/delete-person")
    public void deletePersonOnList(Patient patient){
        patientRepo.deletingPatientById(patient.getId());

    }
}
