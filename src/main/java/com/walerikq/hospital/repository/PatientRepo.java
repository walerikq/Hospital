package com.walerikq.hospital.repository;

import com.walerikq.hospital.entity.Patient;
import com.walerikq.hospital.util.ScriptReader;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


@RequiredArgsConstructor
@Repository
public class PatientRepo {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * @return new id patients
     */
    public UUID setCounter() {
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
        return namedParameterJdbcTemplate.query(
                request,
                Map.of("id", uuid),
                (rs, rowNum) -> buildPatitenFromRs(rs)
        ).stream().findFirst().orElse(null);
    }

    /**
     * Метод возвращающий пациентов с определённым статусом
     * @param patientsStatus
     * @return
     */
    public List<Patient> getPatientsWithStatus(@NotNull String patientsStatus) {
        String request = ScriptReader.read("sql/getPatientsByStatus.sql");
        return namedParameterJdbcTemplate.query(
                request,
                Map.of("status", patientsStatus),
                (rs, rowNum) -> buildPatitenFromRs(rs));
    }


    /**
     * Метод возвращает всех пациентов
     *
     * @return List
     */
    public List<Patient> getAllPatients() {
        String request = ScriptReader.read("sql/getAllPatients.sql");
        return namedParameterJdbcTemplate.query(request,
                (rs, rowNum) -> buildPatitenFromRs(rs));
    }

    /**
     * Удаление пациента из списка по ID
     *
     * @param uuid
     */
    public void deletingPatientById(UUID uuid) {
        String request = ScriptReader.read("sql/deletePatient.sql");
        namedParameterJdbcTemplate.update(
                request,
                Map.of("id", uuid));
    }

    /**
     * Сохранение пациента
     * @param patient
     */
    public void savePatient(Patient patient) {
        String request = ScriptReader.read("sql/updatingPatientInformation.sql");
        namedParameterJdbcTemplate.update(
                request,
                patientBuilder(patient)
        );

    }


    public void addPatientInList(Patient patient) {
        String request = ScriptReader.read("sql/createNewPatient.sql");
        namedParameterJdbcTemplate.update(
                request,
                patientBuilder(patient)
        );

    }

    private Map<String, ?> patientBuilder(Patient patient) {
        return Map.of(
                "id", patient.getUuid(),
                "name", patient.getName(),
                "surname", patient.getSurname(),
                "patronymic", patient.getPatronymic(),
                "age", patient.getAge(),
                "diseases", patient.getDiseases(),
                "status", patient.getStatus());

    }

    private Patient buildPatitenFromRs(ResultSet rs) throws SQLException {
        return Patient.builder()
                .uuid(UUID.fromString(rs.getString("id")))
                .patronymic(rs.getString("patronymic"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .age(rs.getInt("age"))
                .diseases(rs.getString("diseases"))
                .status(rs.getString("status"))
                .build();
    }
}
