update hospital.patient p
set name = :name, surname = :surname, patronymic = :patronymic, age = :age,diseases = :diseases,
    status = :status
where id = :id;