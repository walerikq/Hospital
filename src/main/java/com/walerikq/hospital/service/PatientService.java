package com.walerikq.hospital.service;

import com.walerikq.hospital.Dto.PatientDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.repository.PatientRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepo patientRepo;

    public Patient getPatientById(int id){
        return patientRepo.getPatientById(id);
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
                patientRepo.setCounter(),
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
        Patient patient = patientRepo.getPatientById(patientDto.getId());
        if (patientDto.getName() != null){
            patientRepo.setNamePerson(patientDto.getId(),patientDto.getName());
        }
        if (patientDto.getSurname() != null){
            patientRepo.setSurnamePerson(patientDto.getId(),patientDto.getSurname());
        }
        if (patientDto.getPatronymic() != null){
            patientRepo.setPatronymicPerson(patientDto.getId(),patientDto.getPatronymic());
        }
        if (patientDto.getAge() > 0){
            patientRepo.setAgePerson(patientDto.getId(), patientDto.getAge());
        }
        if (patientDto.getDiseases() != null){
            patientRepo.setDiseases(patientDto.getId(), patientDto.getDiseases());
        }
        if (patientDto.getStatus() != null){
            patientRepo.setStatus(patientDto.getId(), patientDto.getStatus());
        }

    }

    public void deletingPatientById(int id){
        patientRepo.deletingPatientById(id);
    }

    /**
     * Получение пациентов с определённым статусом
     * @param patientsStatus
     * @return
     */
   public List<Patient> getPatientsWithStatus(PatientsStatus patientsStatus){
        return patientRepo.getPatientsWithStatus(patientsStatus);
   }


}
