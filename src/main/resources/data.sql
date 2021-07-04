insert into employee(id, name, age)
values ('1', 'Tom', 30);

/* User master */
insert into m_user(user_id, password, user_name, birthday, age, gender, department_id, role)
values ('example@gmail.com', 'password', 'System Administrator', '2000-01-01', 21, 1, 1, 'ROLE_ADMIN'),
       ('anotherexample@gmail.com', 'password', 'User1', '2000-01-01', 21, 2, 2, 'ROLE_GENERAL');

/* Department master */
insert into m_department(department_id, department_name)
values (1, 'System Management'),
       (2, 'Sales');

/* Salary table */
insert into t_salary (user_id, year_month, salary)
values ('example@gmail.com', '11/2020', 2800),
       ('example@gmail.com', '12/2000', 2900),
       ('example@gmail.com', '01/2021', 3000);