package com.walerikq.hospital.repository;

import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.service.PatientsStatus;
import com.walerikq.hospital.util.ScriptReader;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;


@RequiredArgsConstructor
@Repository
public class PatientMap {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    private Map<UUID,Patient> patientMap = new HashMap<>();
//    private int  idPatients = 0;

    /**
     *
     * @return new id patients
     */
    public UUID setCounter(){
        return UUID.randomUUID();
    }

    /**
     * Возвращает одного пациента из общего списка больных по ID
     *
     * @param uuid
     * @return
     */
    public Patient getPatientById(UUID uuid) {
        String request = ScriptReader.read("sql/getPatientByID.sql");
        return (Patient) namedParameterJdbcTemplate.query(
                request,
                Map.of("id",uuid),
                (rs, rowNum) -> Patient.builder()
                        .patronymic(rs.getString("patronymic"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .age(rs.getInt("age"))
                        .diseases(rs.getString("diseases"))
                        .status(PatientsStatus.valueOf(rs.getString("status")))
                        .build());
    }

    public List<Patient> getPatientsWithStatus(@NotNull PatientsStatus patientsStatus) {

       String request = ScriptReader.read("sql/getPatientsByStatus.sql");
        return namedParameterJdbcTemplate.query(
                request,
                (rs, rowNum) -> Patient.builder()
                        .patronymic(rs.getString("patronymic"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .age(rs.getInt("age"))
                        .diseases(rs.getString("diseases"))
                        .status(PatientsStatus.valueOf(rs.getString("status")))
                        .build());
    }

    /**
     * Метод возвращает всех пациентов
     *
     * @return List
     */
    public List<Patient> getAllPatients(){
        String request = ScriptReader.read("sql/getAllPatients.sql");
        return namedParameterJdbcTemplate.query(request,
                (rs, rowNum) ->
                        Patient.builder()
                                .uuid(UUID.fromString("uuid"))
                                .patronymic("patronymic")
                                .name("name")
                                .surname("surname")
                                .age(Integer.valueOf("age"))
                                .diseases("diseases")
                                .status(PatientsStatus.valueOf("status"))
                                .build());

    }

    /**
     * Удаление пациента из списка по ID
     *
     * @param uuid
     */
    public void deletingPatientById(UUID uuid) {

        String request = ScriptReader.read("deletePatient.sql");
        namedParameterJdbcTemplate.update(
                request,
                Map.of("id",uuid));
    }
//
    public void savePatient(Patient patient){
        String request = ScriptReader.read("sql/updatingPatientInformation.sql");
        namedParameterJdbcTemplate.update(
                request,
                Map.of( "id", patient.getUuid(),
                        "name", patient.getName(),
                        "surname", patient.getSurname(),
                        "patronymic", patient.getPatronymic(),
                        "age", patient.getAge(),
                        "diseases", patient.getDiseases(),
                        "status", patient.getStatus()));

    }
//
    public void addPatientInList(Patient patient) {
        String request = ScriptReader.read("sql/createNewPatient.sql");
        namedParameterJdbcTemplate.update(
                request,
                Map.of( "id", patient.getUuid(),
                        "name", patient.getName(),
                        "surname", patient.getSurname(),
                        "patronymic", patient.getPatronymic(),
                        "age", patient.getAge(),
                        "diseases", patient.getDiseases(),
                        "status", patient.getStatus()));
    }


}
