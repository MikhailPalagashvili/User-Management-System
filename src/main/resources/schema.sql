create table if not exists employee
(
    id   varchar(50) primary key,
    name varchar(50),
    age  int
);

create table if not exists m_user
(
    user_id       varchar(50) primary key,
    password      varchar(100),
    user_name     varchar(50),
    birthday      date,
    age           int,
    gender        int,
    department_id int,
    role          varchar(50)
);


create table if not exists m_department
(
    department_id   int primary key,
    department_name varchar(50)
);

create table if not exists t_salary
(
    user_id    varchar(50),
    year_month varchar(50),
    salary     int,
    primary key (user_id, year_month)
);
