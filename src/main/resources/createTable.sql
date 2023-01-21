create schema if not exists hospital;

create table if not exists hospital.patient
(
    id  uuid primary key default gen_random_uuid(),
    name character(30) not null,
    surname character(30) not null,
    patronymic character(30),
    age integer check(age >= 0),
    diseases character(300),
    status character(30),
    );

insert into hospital.patient(
    id,name,patronymic,surname,age,diseases)
values
    (gen_random_uuid(),'Valera','Lolikovich','Pupkin',22,'ochen silno bolen'),
    (gen_random_uuid(),'Valera','Popikovich','Lulkin',25,'ne silno bolen'),
    (gen_random_uuid(),'Migeraera','Klokoovich','Zubkina',22,'pochti umer'),
    (gen_random_uuid(),'Walera','Lolikovi4','Lupkin',22,'ochen silno bolen');




