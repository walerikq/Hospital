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
    doctor_id integer,
    foreign key (doctor_id) references hospital.doctor(id)
    );

insert into hospital.patient(
    id,name,patronymic,surname,age,diseases)
values
    (gen_random_uuid(),'Valera','Lolikovich','Pupkin',22,'ochen silno bolen'),
    (gen_random_uuid(),'Valera','Popikovich','Lulkin',25,'ne silno bolen'),
    (gen_random_uuid(),'Migeraera','Klokoovich','Zubkina',22,'pochti umer'),
    (gen_random_uuid(),'Walera','Lolikovi4','Lupkin',22,'ochen silno bolen');


create table if not exists hospital.doctor
(
    id uuid primary key default gen_random_uuid(),
    name character(30) not null,
    surname character(30) not null,
    patronymic character(30) not null,
    age integer check(age > 20),
    cabinet integer check(cabinet > 0),
    department_id integer,
    patient_id integer,
    foreign key (patient_id) references hospital.patient(id),
    foreign key (department_id) references hospital.department(id)
    );

insert into hospital.doctor(
    id,name,patronymic,surname,cabinet)
values
    (gen_random_uuid(),'Innokentyi','Vladislavovich','Okyrkok',58),
    (gen_random_uuid(),'Aleksandr','Vladislavovich','Pokyrkok',63),
    (gen_random_uuid(),'Kentavr','Zevsovich','Olymp',13),
    (gen_random_uuid(),'Polinariya','Iskanderovna','Listok',5);

create table if not exists hospital.department
(
    id uuid primary key default gen_random_uuid(),
    name character(60) not null,
    doctor_id integer,
    foreign key (doctor_id) references hospital.doctor(id)
    );

insert into hospital.department(
    id,name)
values
    (gen_random_uuid(),'Psychiatry'),
    (gen_random_uuid(),'Cardiology'),
    (gen_random_uuid(),'Neurology'),
    (gen_random_uuid(),'Otolaryngology')
