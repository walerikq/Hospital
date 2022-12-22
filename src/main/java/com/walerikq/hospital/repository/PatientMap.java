package com.walerikq.hospital.repository;

import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class PatientMap {
    /**
     * должна быть логика хранения и работы с данными
     */

    private Map<Integer,Patient> patientMap = new HashMap<>();
    private int  idPatients = 0;

    /**
     *
     * @return new id patients
     */
    public int setCounter(){
        return idPatients++;
    }

    /**
     * Возвращает одного пациента из общего списка больных по ID
     *
     * @param id
     * @return
     */
    public Patient getPatientById(int id) {
        return patientMap.get(id);
    }

    public List<Patient> getPatientsWithStatus(@NotNull PatientsStatus patientsStatus) {

        return patientMap.values().stream()
                .filter(x -> (patientMap.get(x).getStatus()== patientsStatus))
                .collect(Collectors.toList());
    }

    /**
     * Метод возвращает всех пациентов
     *
     * @return List
     */
    public List<Patient> getAllPatients() {
        return patientMap.values().stream().toList();
    }

    /**
     * Удаление пациента из списка по ID
     *
     * @param id
     */
    public void deletingPatientById(int id) {
            patientMap.remove(id);
    }

    public void savePatient(Patient patient){
        patientMap.put(patient.getId(),patient);
    }

    public void addPatientInList(Patient patient) {
        patientMap.put(patient.getId(), patient);
    }


}
