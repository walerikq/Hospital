create schema if not exists hospital;

create table if not exists hospital.patient
(
    id  uuid primary key default gen_random_uuid(),
    name varchar (30) not null,
    surname varchar(30) not null,
    patronymic varchar(30),
    age integer check(age >= 0),
    diseases varchar(300),
    status varchar(30)
    );

insert into hospital.patient(
    id,name,patronymic,surname,age,diseases,status)
values
    (gen_random_uuid(),'Алексей','Булатов','Pupkin',22,'ochen silno bolen','APPOINTMENT'),
    (gen_random_uuid(),'Инокентий','Филатов','Аркадьевич',25,'ne silno bolen','APPOINTMENT'),
    (gen_random_uuid(),'Авраам','Карпатов','Сергеевич',22,'pochti umer','APPOINTMENT'),
    (gen_random_uuid(),'Людмила','Скорозубкина','Алексеевна',22,'ochen silno bolen','APPOINTMENT');


alter table hospital.patient
    alter column name type varchar(30);


