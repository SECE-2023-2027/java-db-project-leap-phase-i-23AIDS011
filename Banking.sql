create database banking;
use banking;
create table user(uid varchar(10) primary key,uname varchar(30),password varchar(30),email varchar(30),phno bigint);
/*alter table tablename add column columnname datatype;
alter table table name modify columnname datatype;*/
alter table user drop email;
drop table user;
create table user(uid int auto_increment primary key,uname varchar(30) not null,password varchar(30) not null,email varchar(30) unique,phno bigint not null);
insert into user(uname,password,email,phno)values('Akshaya N','7772689','akshayanatesan7772@gmail.com','9514152789');
insert into user(uname,password,email,phno)values('Atharsha P','45321875','atharsha@gmail.com','8870455742');
insert into user(uname,password,email,phno)values('Jayasasirekha M','547962','jsr@gmail.com','7540921364');
insert into user(uname,password,email,phno)values('Kavya R','0952','kr@gmail.com','9087563412');
insert into user(uname,password,email,phno)values('Madhu Priya','653112','madhupriya@gmail.com','1234567890');
insert into user(uname,password,email,phno)values('KarpagaYalini R','2102136','yalini@gmail.com','1234650987');
insert into user(uname,password,email,phno)values('Kavika S','430931','ks@gmail.com','1234567089');
insert into user(uname,password,email,phno)values('Sanjana S Pillai','12064','ssp@gmail.com','9876504123');
insert into user(uname,password,email,phno)values('Poornisha Kumar','321496','poorrniii@gmail.com','8647503291');
insert into user(uname,password,email,phno)values('Priyanka Naidu','127643','pn@gmail.com','1234890657');
insert into user(uname,password,email,phno)values('Pradeepa Shivani','65428','ps@gmail.com','9870563421');
Select * from user;
update user set email='sp@gmail.com' where uid=2;
delete from user where uid=1;
Select * from user where email is not null;
create table student(sid int auto_increment primary key,sname varchar(30) not null,address varchar(30) not null,dept varchar(30) not null);
INSERT INTO student (sname, address, dept) VALUES
('Alice Johnson', '123 Main St', 'Computer Science'),
('Bob Smith', '456 Maple Ave', 'Computer Science'),
('Charlie Brown', '789 Oak Dr', 'Physics'),
('Diana Prince', '321 Cedar Ln', 'Biology'),
('Ethan Hunt', '654 Elm St', 'Biology'),
('Fiona Gallagher', '987 Pine Rd', 'Engineering'),
('George Clooney', '159 Birch Pl', 'Economics'),
('Hannah Montana', '753 Walnut St', 'Psychology'),
('Ivan Drago', '852 Cherry Ln', 'Computer Science'),
('Jane Doe', '951 Aspen Blvd', 'Engineering');
Select * from student where dept in('Computer Science','Engineering','Psychology');
Select * from student where sid between 1 and 5;
Select * from student order by sname;
Select * from student order by sname desc;
Select * from student order by sname asc limit 3;
create table employee(empid int auto_increment primary key,empname varchar(30) not null,eaddress varchar(30) not null,salary decimal(7,2) not null);
INSERT INTO employee (empname, eaddress, salary) VALUES
('John Doe', '101 Main St', 55000.00),
('Jane Smith', '202 Elm St', 62000.00),
('Alice Johnson', '303 Oak St', 47000.00),
('Bob Brown', '404 Pine St', 75000.00),
('Cathy Davis', '505 Maple St', 53000.00),
('David Wilson', '606 Cedar St', 69000.00),
('Emma Thomas', '707 Walnut St', 71000.00),
('Frank Harris', '808 Cherry St', 48000.00),
('Grace Lee', '909 Birch St', 56000.00),
('Henry Clark', '1010 Spruce St', 78000.00);
Select sum(salary) from employee;
Select avg(salary) from employee;
Select count(*) from employee;
Select min(salary),max(salary) from employee;
Select count(empname) from employee;
create table department(deptid int auto_increment primary key,deptname varchar(30) not null);
alter table student add deptid int,add constraint foreign key(deptid) references department(deptid);
INSERT INTO department (deptid, deptname) VALUES
(1, 'Computer Science'),
(2, 'Mathematics'),
(3, 'Physics'),
(4, 'Biology'),
(5, 'Engineering');
-- Adding deptid values to student table with duplicates
UPDATE student SET deptid = 1 WHERE sid IN (1, 2, 9);    -- Computer Science
UPDATE student SET deptid = 2 WHERE sid = 3;             -- Mathematics
UPDATE student SET deptid = 3 WHERE sid = 4;             -- Physics
UPDATE student SET deptid = 4 WHERE sid IN (5, 6);       -- Biology
UPDATE student SET deptid = 5 WHERE sid IN (7, 10);      -- Engineering
UPDATE student SET deptid = 2 WHERE sid = 8;             -- Mathematics (duplicate)
SELECT student.sid, student.sname, student.address, department.deptname FROM student INNER JOIN department ON student.deptid = department.deptid;
SELECT student.sid, student.sname, student.address, department.deptname FROM student LEFT JOIN department ON student.deptid = department.deptid;
SELECT student.sid, student.sname, student.address, department.deptname FROM student RIGHT JOIN department ON student.deptid = department.deptid;
