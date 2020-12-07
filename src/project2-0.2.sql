-- 创建数据库project2
show databases;
create database if not exists project2;
use project2;

-- 角色表
create table if not exists tb_role(
role_id int primary key auto_increment,
role_name varchar(100) not null,
role_create_time datetime not null,
constraint uk_tb_role_role_name unique(role_name)
)engine=innodb default charset=utf8;
-- 
#删除角色表
-- drop table tb_role;
#角色表插入数据
insert into tb_role (role_name,role_create_time) values('管理员',now());
insert into tb_role (role_name,role_create_time) values('普通用户',now());
insert into tb_role (role_name,role_create_time) values('人事专员',now());


-- 部门表
create table if not exists tb_department(
dep_id int primary key auto_increment,
dep_no varchar(100) not null,
dep_name varchar(100) not null,
location varchar(300) not null,
leader varchar(100) not null,
dep_create_time datetime not null,
constraint uk_tb_department_dep_no unique(dep_no),
constraint uk_tb_department_dep_name unique(dep_name)
)engine=innodb default charset=utf8;


-- 菜单表
create table if not exists tb_menu(
menu_id int primary key auto_increment,
menu_name varchar(100) not null,
href_url varchar(300) not null,
parent_id int not null,
menu_create_time datetime not null,
constraint uk_tb_menu_menu_name unique(menu_name),
constraint uk_tb_menu_href_url unique(href_url)
)engine=innodb default charset=utf8;
#删除菜单表
drop table tb_menu;
#菜单表插入数据 
-- insert into tb_menu(menu_name,href_url,parent_id,menu_create_time) values ();

-- 权限表
create table if not exists tb_permission(
per_id int primary key auto_increment,
role_id int not null,
menu_id int not null,
per_create_time datetime not null,
constraint fk_tb_permission_role_id foreign key(role_id) references tb_role(role_id),
constraint fk_tb_permission_menu_id foreign key(menu_id) references tb_menu(menu_id)
)engine=innodb default charset=utf8;
#删除权限表
-- drop table tb_permission;

-- 员工表
create table if not exists tb_employee(
emp_id int primary key auto_increment,
emp_no varchar(100) not null,
emp_name varchar(100) not null,
dep_no varchar(100) not null,
sex varchar(100) not null,
age int not null,
education varchar(100) not null,
email varchar(100) not null,
telphone varchar(100) not null,
address varchar(200) not null,
entry_time date not null,
emp_create_time datetime not null,
constraint uk_tb_employee_emp_no unique(emp_no),
constraint uk_tb_employee_emp_name unique(emp_name),
constraint uk_tb_employee_email unique(email),
constraint uk_tb_employee_telphone unique(telphone),
constraint ck_tb_employee_sex check(sex in('男','女','第三性别')),
constraint ck_tb_employee_age check(age>=18),
constraint ck_tb_employee_education check(education in('文盲','小学','初中','高中','中专','大专','本科','硕士','博士')),
constraint ck_tb_employee_email check(email like '@[a-z]+.com'),
constraint ck_tb_employee_telphone check(telphone like '[1][35678][0-9]{9}'),
constraint fk_tb_employee_dep_no foreign key(dep_no) references tb_department(dep_no)
)engine=innodb default charset=utf8;
#删除员工表 
drop table tb_employee;

-- 用户表
create table if not exists tb_user(
user_id int primary key auto_increment,
login_account varchar(100) not null,
login_password varchar(100) not null,
emp_no varchar(100) not null,
role_id int not null,
user_status varchar(100) not null,
user_create_time datetime null,
constraint uk_tb_user_login_account unique(login_account),
constraint ch_tb_user_user_status check(user_status in('正常','注销')),
constraint fk_tb_user_emp_no foreign key(emp_no) references tb_employee(emp_no),
constraint fk_tb_user_role_id foreign key(role_id) references tb_role(role_id)
)engine=innodb default charset=utf8;
#删除用户表
-- drop table tb_user;

-- 请假表
create table if not exists tb_holiday(
hol_id int primary key auto_increment,
hol_no varchar(100) not null,
emp_no varchar(100) not null,
hol_type varchar(100) not null,
hol_reason varchar(300) not null,
start_time datetime not null,
end_time datetime not null,
hol_status varchar(100) not null,
hol_create_time datetime not null,
constraint uk_tb_holiday_hol_no unique(hol_no),
constraint ck_tb_holiday_hol_status check(hol_status in('未提交','已提交')),
constraint ck_tb_holiday_hol_type check(hol_type in('事假','婚假','年假','调休','病假','丧假')),
constraint ck_tb_holiday_end_time check(end_time>=start_time),
constraint ck_tb_holiday_start_time check(start_time<=end_time),
constraint fk_tb_holoday_emp_no foreign key(emp_no) references tb_employee(emp_no)
)engine=innodb default charset=utf8;

#删除请假表
-- drop table tb_holiday;


#报销表
create table if not exists tb_account(
acc_id int primary key auto_increment,
emp_no varchar(100) not null,
acc_type varchar(100) not null,
money double not null,
acc_status varchar(100) not null,
acc_create_time datetime not null,
constraint ck_tb_account_money check(money>0),
constraint ck_tb_account_acc_status check(acc_status in('未提交','已提交','审核','审查','审批')),
constraint ck_tb_account_acc_type check(acc_type in('差旅费','招待费','办公费')),
constraint fk_tb_account_emp_no foreign key(emp_no) references tb_employee(emp_no)
)engine=innodb default charset=utf8;


-- 配置表
create table if not exists tb_config(
con_id int primary key auto_increment,
con_type varchar(100) not null,
con_key varchar(100) not null,
con_page  varchar(100) not null,
con_create_time datetime not null
)engine=innodb default charset=utf8;






