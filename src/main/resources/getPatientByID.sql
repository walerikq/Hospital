select patient.surname || ' ' || patient.name || ' ' || patient.patronymic  as fullname,
       patient.age,
       patient.status,
       patient.diseases
  from hospital.patient
 where p.id = :id;