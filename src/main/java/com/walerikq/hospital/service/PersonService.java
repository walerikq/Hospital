package com.walerikq.hospital.service;

import com.walerikq.hospital.entity.Patient;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonService {

    private static int ID_COUNTER;
    private List<Patient> patients;



    /**
     * Создание карточки(объекта) нового пациента
     *
     * @param name
     * @param age
     * @param diseases
     */
    public void createPatient(String name,String surname,String patronymic, short age, String diseases,PatientsStatus status) {
        Patient patient = new Patient();
        patient.setId(ID_COUNTER++);
        patient.setName(name);
        patient.setSurname(surname);
        patient.setPatronymic(patronymic);
        patient.setAge(age);
        patient.setDiseases(diseases);
        patient.setStatus(status);
        patients.add(patient);

    }

    /**
     * Изменение имени клиента
     * @param patient
     * @param name
     */
    public void changeNamePerson(@NotNull Patient patient, String name) {
        patient.setName(name);
    }

    /**
     * Изменение фамилии пациента
     * @param patient
     * @param surname
     */
    public void changeSurnamePerson(Patient patient, String surname) {
        patient.setName(surname);
    }

    /**
     * Изменение отчества клиента
     * @param patient
     * @param patronymic
     */
    public void changePatronymicPerson(Patient patient, String patronymic) {
        patient.setPatronymic(patronymic);
    }

    /**
     * Изменение возраста клиента
     * @param patient
     * @param age
     */
    public void changeAgePerson(Patient patient, short age) {
        patient.setAge(age);
    }



    /**
     * Возвращает одного пациента из общего списка больных по ID
     *
     * @param patients
     * @param id
     * @return
     */
    public Patient getIdPatient(List<Patient> patients, int id) {
        Patient patientById = null;
        for (Patient patientIter :
                patients) {
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
        return patients;
    }

    /**
     * Удаление пациента из списка по ID
     *
     * @param id
     */
    public void deletingPatientById(int id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.remove(i);
            }
        }
    }


}
