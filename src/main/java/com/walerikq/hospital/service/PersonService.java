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

@AllArgsConstructor          //TODO Если используешь конструктор со всеми аргументами - спринг будет искать бины всех классов которые есть в параметрах
@NoArgsConstructor           //TODO Когда комментишь этот - спринг ищет бин инта, которого нет и падает. Когда юзаешь такие служебные параметры надо использовать RequiredArgConstructor
@Service                     //TODO И ставить модификатор final на то, что тебе нужно как бин
public class PersonService { //TODO А еще в таком случае хорошим тоном будет явно присвоить при старте значение переменной: private int idCounter = 0;

    private PatientRepo patientRepo;
    private int idCounter; //TODO 10.12 это я бы лучше перенес в репозиторий. Пусть бы там и хранилась эта логика идентификаторов


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
        patientRepo.addListPatients(patient);

    }


    public void changingPatientData(PatientDto patientDto){
        Patient patient = new Patient(patientDto.getId(), patientDto.getName(),
                patientDto.getSurname(), patientDto.getPatronymic(),
                patientDto.getAge(), patientDto.getDiseases(),patientDto.getStatus());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите данные которые необходимо изменить: "); //TODO это не сработает. Ты печатаешь в консоль и ждешь ввода из консоли
        while (scanner.hasNextInt()) {                                       //TODO А фронт у тебя так не умеет. Он тебе закинул что то и ждет ответа
            System.out.println(                                              //TODO Ты не занимаешься общением с пользователем, UI живет только на фронте
                    "1 - Name" +                                             //TODO Бэк работает в формате - пришел запрос, мы его внутри обработали, выплюнули обратно ответ
                    "2 - Surname" +                                          //TODO Здесь твоя задача обработать введенные данные и обновить только те которые пришли
                    "3 - Patronymic" +                                       //TODO Есть два пути - перезатирать в любом случае что бы ни пришло (и это норм)
                    "4 - Age" +                                              //TODO Перезатирать только то что пришло (и это тоже норм)
                    "5 - Status" +                                           //TODO Или добавить параметр-флаг который будет указывать - обновлять полностью или только то что заполнено
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

    public List<Patient> getPatientsWithStatus(List<Patient> patients){ //TODO тут какие то странные дела))
        PatientsStatus status = null; ;                                 //TODO По хорошему тебе надо передавать в метод статус (прям с фронта текстом один из PatientsStatus)
        System.out.println("Выберите номер необходимого статуса: \n"    //TODO обращаться с ним в репозиторий, и внутри репозитория реализовать метод поиска по статусу
                + "1 - REGISTRATION\n"
                + "2 - APPOINTMENT\n"
                + "3 - TREATMENT\n"
                + "4 - RESUSCITATION\n"
                + "5 - DISCHARGED");

        Scanner scanner = new Scanner(System.in);                       //TODO это тут не сработает точно, из консоли тут читать некому и писать туда тоже некому
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
        List<Patient> patientsListWithStatus = new ArrayList<>();           //TODO эту логику лучше вынести в репозиторий
        for (Patient patientWithStatus:                                     //TODO проще всего сделать через стрим: stream().filter().collect()
             patients) {
            if (patientWithStatus.getStatus() == status){
                patientsListWithStatus.add(patientWithStatus);
            }
        }
        return patientsListWithStatus;
    }


}
