CREATE TABLE employee.employee
(
    employee_id   serial not null,
    first_name    varchar(30),
    last_name     varchar(30),
    department_id integer,
    job_title     varchar(30),
    gender        varchar (30),
    constraint employee_pk
        primary key (employee_id)
);

INSERT INTO employee.employee
(
    first_name,
    last_name,
    department_id,
    job_title,
    gender
),
VALUES
(
    'John',
    'Petrucci',
    '1',
    'Guitar Player',
    'MALE'
),
(
    'Diana',
    'Krall',
    '2',
    'Vocalist',
    'FEMALE'
),
(
    'Joe',
    'Bonamassa',
    '3',
    'Bass Player',
    'MALE'
);
create sequence employee_id_seq;
