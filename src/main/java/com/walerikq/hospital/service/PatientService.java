package com.walerikq.hospital.service;

import com.walerikq.hospital.Dto.PatientDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.repository.PatientMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientMap patientMap;

    public Patient getPatientById(int id){
        return patientMap.getPatientById(id);
    }

    public List<Patient> getAllPatients() {
        return patientMap.getAllPatients();
    }

    /**
     * Создание новой карточки клиента
     * @param personDto
     */
    public void createPatient(PatientDto personDto) {
        Patient patient = new Patient(
                patientMap.setCounter(),
                personDto.getName(),
                personDto.getSurname(),
                personDto.getPatronymic(),
                personDto.getAge(),
                personDto.getDiseases(),
                personDto.getStatus()
        );
        patientMap.addPatientInList(patient);


    }


    public void changingPatientData(PatientDto patientDto){
        Patient patient = patientMap.getPatientById(patientDto.getId());
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

        patientMap.savePatient(patient);

    }

    public void deletingPatientById(int id){
        patientMap.deletingPatientById(id);
    }

    /**
     * Получение пациентов с определённым статусом
     * @param patientsStatus
     * @return
     */
   public List<Patient> getPatientsWithStatus(PatientsStatus patientsStatus){
        return patientMap.getPatientsWithStatus(patientsStatus);
   }


}
