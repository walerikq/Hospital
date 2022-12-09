package com.walerikq.hospital.repository;

import com.walerikq.hospital.PersonDto.PatientDto;
import com.walerikq.hospital.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Repository
public class PatientRepo {
    /**
     * должна быть логика хранения и работы с данными
     */

    private List<Patient> patientList;

    /**
     *
     * Возвращает одного пациента из общего списка больных по ID
     *
     * @param id
     * @return
     */
    public Patient getIdPatient(int id) {

        Patient patientById = null;
        for (Patient patientIter :
                patientList) {
            if (patientIter.getId() == id) {
                patientById = patientIter;
            }
        }

        return patientById;
    }

    /**
     * Метод возвращает всех пациентов
     *
     * @return List
     */
    public List<Patient> getAllPatients() {
        return patientList;
    }

    /**
     * Удаление пациента из списка по ID
     *
     * @param id
     */
    public void deletingPatientById(int id) {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getId() == id) {
                patientList.remove(i);
            }
        }
    }

    public void addListPatients(Patient patient){
        patientList.add(patient);
    }

}
