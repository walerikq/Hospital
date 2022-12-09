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
    private PatientRepo patientRepo; //TODO 10.12 В контроллере не должен быть репозиторий, контроллер общается только с сервисами и с клиентской частью
                                     //TODO Обращайся к этим методам репозитория через сервис:
                                     //TODO создай в сервисе новые методы которые будут дергать репозиторий и обращайся к сервису
    private final PersonService personService;

    @GetMapping("/get-person")
    public List<Patient> getAllPerson(){
        return patientRepo.getAllPatients();
    } //TODO 10.12 вот это в сервис точно

    @GetMapping("/get-patient-from-id")
    public Patient getPatientById(int id){
       Patient patient = patientRepo.getIdPatient(id); //TODO 10.12 и это в сервис
        return patient;                                //TODO А тут идея подсказывает что можно сделать просто return patientRepo.getIdPatient(id);
    }

    @PostMapping("/create-new-patient")
    public void createNewPatient(@RequestBody PatientDto personDto){
        personService.createPatient(personDto);
    }

    @GetMapping("/get-patients-with-status")
    public List<Patient> getPatientsWithStatus(){ ////TODO 10.12 тут принимаешь с фронта параметр PatientStatus
        return personService.getPatientsWithStatus(patientRepo.getPatientList()); //TODO А вот тут передаешь параметр в сервис, а оттуда из репозитория получаешь новый список пациентв
    }

    @PutMapping("/put-info")
    public void changeInformation(PatientDto personDto){ //TODO 10.12 реквестбади не добавил

        personService.changingPatientData(personDto);

    }

    @DeleteMapping("/delete-person")
    public void deletePersonOnList(Patient patient){ //TODO 10.12 реквестбади не добавил, используешь в контроллере энтити, а не ДТО
        patientRepo.deletingPatientById(patient.getId()); //TODO 10.12 и это нужно перенести в сервис в сервис

    }
}
