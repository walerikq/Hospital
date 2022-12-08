package com.walerikq.hospital.service;

import com.walerikq.hospital.PersonDto.PatientDto;
import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.repository.PatientRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PersonService {

    private PatientRepo patientRepo;
    private int idCounter;


    /**
     * Создание новой карточки клиента
     * @param personDto
     */
    public void createPatient(PatientDto personDto) {
        Patient patient = new Patient();
        patient.setId(idCounter++);
        patient.setName(personDto.getName());
        patient.setSurname(personDto.getSurname());
        patient.setPatronymic(personDto.getPatronymic());
        patient.setAge(personDto.getAge());
        patient.setDiseases(personDto.getDiseases());
        patient.setStatus(personDto.getStatus());
        patientRepo.getPatientList().add(patient);

    }


    public void changingPatientData(PatientDto patientDto){
        Patient patient = new Patient(patientDto.getId(), patientDto.getName(),
                patientDto.getSurname(), patientDto.getPatronymic(),
                patientDto.getAge(), patientDto.getDiseases(), patientDto.getStatus());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите данные которые необходимо изменить: ");
        while (scanner.hasNextInt()) {
            System.out.println(
                    "1 - Name" +
                    "2 - Surname" +
                    "3 - Patronymic" +
                    "4 - Age" +
                    "5 - Status" +
                    "6 - Diseases" +
                    "0 - Exit");
            int choise = scanner.nextInt();
            if (choise == 0){
                break;
            }
            if (choise == 1){
                if (patient.getName() == null){
                    break;
                }
                setNamePerson(patient,patientDto.getName());
                patientRepo.getPatientList().set(patient.getId(),patient);

            }

            if(choise == 2){
                if (patient.getSurname() == null){
                    break;
                }
                setSurnamePerson(patient,patient.getSurname());
                patientRepo.getPatientList().set(patient.getId(),patient);
            }

            if (choise == 3){
                if (patient.getPatronymic() == null){
                    break;
                }
                setPatronymicPerson(patient,patient.getPatronymic());
                patientRepo.getPatientList().set(patient.getId(),patient);
            }

            if (choise == 4){
                if (patient.getAge() == 0){
                    break;
                }
                setAgePerson(patient,patientDto.getAge());
                patientRepo.getPatientList().set(patient.getId(),patient);
            }
            if (choise == 5){
                if (patient.getStatus() == null){
                    break;
                }
                patient.setStatus(patient.getStatus());
                patientRepo.getPatientList().set(patient.getId(),patient);
            }

            if(choise == 6){
                if (patientDto.getDiseases() == null){
                    break;
                }
                patient.setDiseases(patientDto.getDiseases());
                patientRepo.getPatientList().set(patient.getId(),patient);
            }
        }
    }

    /**
     * Изменение имени клиента
     * @param patient
     * @param name
     */
    public void setNamePerson(@NotNull Patient patient,@NotNull String name) {
        patient.setName(name);
    }

    /**
     * Изменение фамилии пациента
     * @param patient
     * @param surname
     */
    public void setSurnamePerson(@NotNull Patient patient,@NotNull String surname) {
        patient.setName(surname);
    }

    /**
     * Изменение отчества клиента
     * @param patient
     * @param patronymic
     */
    public void setPatronymicPerson(@NotNull Patient patient,@NotNull String patronymic) {
        patient.setPatronymic(patronymic);
    }

    /**
     * Изменение возраста клиента
     * @param patient
     * @param age
     */
    public void setAgePerson(@NotNull Patient patient, short age) {
        patient.setAge(age);
    }

    //получение всех пациентов с определенным статусом

    public List<Patient> getPatientsWithStatus(List<Patient> patients){
        PatientsStatus status = null; ;
        System.out.println("Выберите номер необходимого статуса: \n"
                + "1 - REGISTRATION\n"
                + "2 - APPOINTMENT\n"
                + "3 - TREATMENT\n"
                + "4 - RESUSCITATION\n"
                + "5 - DISCHARGED");

        Scanner scanner = new Scanner(System.in);
        byte choise = scanner.nextByte();
        boolean flag = true;
        while (flag){
            switch (choise) {
                case 1:
                    status = PatientsStatus.REGISTRATION;
                    flag = false;
                    break;
                case 2:
                    status = PatientsStatus.APPOINTMENT;
                    flag = false;
                    break;
                case 3:
                    status = PatientsStatus.TREATMENT;
                    flag = false;
                    break;
                case 4:
                    status = PatientsStatus.RESUSCITATION;
                    flag = false;
                    break;
                case 5:
                    status = PatientsStatus.DISCHARGED;
                    flag = false;
                    break;
                default:
                    System.out.println("Данного статуса не сущестует");
            }
        }
        List<Patient> patientsListWithStatus = new ArrayList<>();
        for (Patient patientWithStatus:
             patients) {
            if (patientWithStatus.getStatus() == status){
                patientsListWithStatus.add(patientWithStatus);
            }
        }
        return patientsListWithStatus;
    }


}
