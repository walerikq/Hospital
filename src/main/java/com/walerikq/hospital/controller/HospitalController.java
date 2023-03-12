package com.walerikq.hospital.controller;

import com.walerikq.hospital.Dto.PatientDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final PatientService patientService;


    @GetMapping("/get-all-patient")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/get-patient-from-id")
    public Patient getPatientById(@RequestParam UUID uuid){
        return patientService.getPatientById(uuid);
    }

    @PostMapping("/create-new-patient")
    public void createNewPatient(@RequestBody PatientDto personDto){
        patientService.createPatient(personDto);
    }

    @GetMapping("/get-patients-with-status")
    public List<Patient> getPatientsWithStatus(String patientsStatus){
        return patientService.getPatientsWithStatus(patientsStatus);
    }

    @PutMapping("/put-info")
    public void changeInformation(@RequestBody PatientDto patientDto){
        patientService.changingPatientData(patientDto);
    }

    @DeleteMapping("/delete-person")
    public void deletePerson(@RequestBody PatientDto patientDto){
        patientService.deletingPatientById(patientDto.getUuid());
    }
}
