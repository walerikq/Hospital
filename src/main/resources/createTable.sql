create schema if not exists hospital;

create table if not exists hospital.patient
(
    id  uuid primary key,
    name character(30) not null,
    surname character(30) not null,
    patronymic character(30),
    age integer check(age >= 0),
    diseases character(300),
    status character(30),
    doctor_id integer,
    foreign key (doctor_id) references hospital.doctor(id)
    );

create table if not exists hospital.doctor
(
    id uuid primary key ,
    name character(30) not null,
    surname character(30) not null,
    patronymic character(30) not null,
    age integer check(age > 20),
    department_id integer,
    patient_id integer,
    foreign key (patient_id) references hospital.patient(id),
    foreign key (department_id) references hospital.department(id)
    );

create table if not exists hospital.department
(
    id uuid primary key,
    name character(60) not null,
    doctor_id integer,
    foreign key (doctor_id) references hospital.doctor(id)
    );