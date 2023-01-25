select patient.id,
       patient.patronymic,
       patient.surname,
       patient.name,
       patient.age,
       patient.status,
       patient.diseases
  from hospital.patient
 where patient.id = :id;

