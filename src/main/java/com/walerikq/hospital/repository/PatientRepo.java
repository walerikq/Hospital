package com.walerikq.hospital.repository;

import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class PatientRepo {
    /**
     * должна быть логика хранения и работы с данными
     */

    private Map<Integer,Patient> patientList = new HashMap<>();
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
        return patientList.get(id);
    }

    public Map<Integer, Patient> getPatientsWithStatus(@NotNull PatientsStatus patientsStatus) {
        Map<Integer,Patient> patientsListWithStatus = new HashMap<>();
        for (int i = 0; i < patientList.size();i++) {
            if (patientList.get(i).getStatus() == patientsStatus) {
                patientsListWithStatus.put(i,patientList.get(i));
            }
        }
        return patientsListWithStatus;
    }

    /**
     * Метод возвращает всех пациентов
     *
     * @return List
     */
    public Map<Integer, Patient> getAllPatients() {
        return patientList;
    }

    /**
     * Удаление пациента из списка по ID
     *
     * @param id
     */
    public void deletingPatientById(int id) {
            patientList.remove(id);
    }

    public void addPatientInList(Patient patient) {
        patientList.put(patient.getId(), patient);
    }

    /**
     * Изменение имени клиента
     * @param name
     */
    public void setNamePerson(int id, @NotNull String name) {
        getPatientById(id).setName(name);
    }

    /**
     * Изменение фамилии пациента
     * @param surname
     */
    public void setSurnamePerson(int id,@NotNull String surname) {
        getPatientById(id).setSurname(surname);
    }

    /**
     * Изменение отчества клиента
     * @param patronymic
     */
    public void setPatronymicPerson(int id,@NotNull String patronymic) {
        getPatientById(id).setPatronymic(patronymic);
    }

    /**
     * Изменение возраста клиента
     * @param age
     */
    public void setAgePerson(int id, byte age) {
        getPatientById(id).setAge(age);
    }

public void setDiseases(int id,@NotNull String diseases){
        getPatientById(id).setDiseases(diseases);
    }

    public void setStatus(int id, @NotNull PatientsStatus status){
        getPatientById(id).setStatus(status);
    }

}
