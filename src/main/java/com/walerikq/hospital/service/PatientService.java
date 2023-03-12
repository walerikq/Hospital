package com.walerikq.hospital.service;

import com.walerikq.hospital.Dto.PatientDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.repository.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepo patientRepo;


    public Patient getPatientById(UUID uuid){
        return patientRepo.getPatientById(uuid);
    }

    public List<Patient> getAllPatients() {
        return patientRepo.getAllPatients();
    }

    /**
     * Создание новой карточки клиента
     * @param personDto
     */
    public void createPatient(PatientDto personDto) {
        Patient patient = new Patient(
                UUID.randomUUID(),
                personDto.getName(),
                personDto.getSurname(),
                personDto.getPatronymic(),
                personDto.getAge(),
                personDto.getDiseases(),
                personDto.getStatus()
        );
        patientRepo.addPatientInList(patient);


    }


    public void changingPatientData(PatientDto patientDto){
        Patient patient = patientRepo.getPatientById(patientDto.getUuid());
        if (patient.getName() != null){
            patient.setName(patientDto.getName());
        }
        if (patient.getSurname() != null){
            patient.setSurname(patientDto.getSurname());
        }
        if (patient.getPatronymic() != null){
            patient.setPatronymic(patientDto.getPatronymic());
        }
        if (patient.getAge() > 0){
            patient.setAge(patientDto.getAge());
        }
        if (patient.getDiseases() != null){
            patient.setDiseases(patientDto.getDiseases());
        }
        if (patient.getStatus() != null){
            patient.setStatus(patientDto.getStatus());
        }

        patientRepo.savePatient(patient);

    }
//
    public void deletingPatientById(UUID uuid){
        patientRepo.deletingPatientById(uuid);
    }

    /**
     * Получение пациентов с определённым статусом
     * @param patientsStatus
     * @return
     */
   public List<Patient> getPatientsWithStatus(String patientsStatus){
        return patientRepo.getPatientsWithStatus(patientsStatus);
   }


}
