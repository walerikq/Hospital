package com.walerikq.hospital.repository;

import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.service.PatientsStatus;
import com.walerikq.hospital.util.ScriptReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Repository
public class PatientMap {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
//    public List<Patient> getAllPatients() {
//        return patientMap.values().stream().toList();
//    }

    public List<Patient> getAllPatients(){
        return namedParameterJdbcTemplate.query("select * from hospital.patient",
                (rs, rowNum) ->
                        Patient.builder()
                                .id(rs.getInt("id"))
                                .patronymic(rs.getString("patronymic"))
                                .name(rs.getString("name"))
                                .surname(rs.getString("surname"))
                                .age(rs.getInt("age"))
                                .diseases(rs.getString("diseases"))
                                .status(PatientsStatus.valueOf(rs.getString("status")))
                                .build());

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
