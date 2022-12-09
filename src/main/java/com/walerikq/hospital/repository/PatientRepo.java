package com.walerikq.hospital.repository;

import com.walerikq.hospital.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Repository
public class PatientRepo {
    /**
     * должна быть логика хранения и работы с данными
     */

    private List<Patient> patientList; //TODO - ты при создании бина не инициализируешь лист, он у тебя null. Поэтому может падать NPE при обращении к нему

    /**
     *
     * Возвращает одного пациента из общего списка больных по ID
     *
     * @param id
     * @return
     */
    public Patient getIdPatient(int id) { //TODO 10.12 обрати внимание на нейминг: получитьАйдиПациента
                                          // Но по логике ты получаешь пациента по айди. getPatientById будет лучше

        Patient patientById = null;         //TODO 10.12 тут несколько моментов на подумать:
        for (Patient patientIter :          //TODO 1) Во первых тут можно было бы использовать стрим
                patientList) {              //TODO 2) Во вторых ты даже после получения пациента бежишь дальше, можно было сразу как получил сделать ретерн
            if (patientIter.getId() == id) {//TODO 3) В третьих если использовать тут Map<Integer, Patient> то метод будет гораздо проще и быстрее работать
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
        for (int i = 0; i < patientList.size(); i++) { //TODO 10.12 тут несколько моментов на подумать:
            if (patientList.get(i).getId() == id) {    //TODO 1) Во первых ты даже после удаления пробегаешься по всему оставшемуся циклу, можно было бы делать ретерн после успешного удаления
                patientList.remove(i);                 //TODO 2) Во вторых - лист здесь не лучший выбор. Гарантируется, что id - уникальный
                                                       //TODO Если использовать тут Map<Integer, Patient> то метод будет гораздо проще и быстрее работать
            }
        }
    }

    public void addListPatients(Patient patient){ //TODO 10.12 тут обрати внимание метод называется добавитьЛистПациентов.
        patientList.add(patient);                 // Но ты же добавляешь не лист, а одного. Лучше назвать addPatient

    }

}
