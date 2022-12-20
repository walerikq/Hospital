package com.walerikq.hospital.controller;

import com.walerikq.hospital.Dto.PatientDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.service.PatientService;
import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private PatientService patientService;


    @GetMapping("/get-all-patient")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/get-patient-from-id")
    public Patient getPatientById(int id){
        return patientService.getPatientById(id);
    }

    @PostMapping("/create-new-patient")
    public void createNewPatient(@RequestBody PatientDto personDto){
        patientService.createPatient(personDto);
    }

    @GetMapping("/get-patients-with-status")
    public List<Patient> getPatientsWithStatus(PatientsStatus patientsStatus){
        return patientService.getPatientsWithStatus(patientsStatus);
    }

    @PutMapping("/put-info")
    public void changeInformation(@RequestBody PatientDto patientDto){
        patientService.changingPatientData(patientDto);
    }

    @DeleteMapping("/delete-person")
    public void deletePersonOnList(@RequestBody PatientDto patientDto){
        patientService.deletingPatientById(patientDto.getId());
    }
}
