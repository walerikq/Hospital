package com.walerikq.hospital.repository;

import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.service.PatientsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class PatientRepo {
    /**
     * должна быть логика хранения и работы с данными
     */

    private List<Patient> patientList = new ArrayList<>();
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
        for (Patient patient:
             patientList) {
            if (patient.getId() == id){
                return patient;
            }
        }
            return null;
    }

    public List<Patient> getPatientsWithStatus(@NotNull PatientsStatus patientsStatus) {
        List<Patient> patientsListWithStatus = new ArrayList<>();
        for (Patient patientWithStatus :
                patientList) {
            if (patientWithStatus.getStatus() == patientsStatus) {
                patientsListWithStatus.add(patientWithStatus);
            }
        }
        return patientsListWithStatus;
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
                break;
            }
        }
    }

    public void addPatientInList(Patient patient) {
        patientList.add(patient);

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
