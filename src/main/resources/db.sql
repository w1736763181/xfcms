create table T_USER (
  id int auto_increment primary key ,
  username varchar(20) not null unique,
  password varchar(100) not null,
  name varchar(10) ,
  gender tinyint(1) ,
  deleted tinyint(1) ,
  locked tinyint(1)
);

create table T_ROLE (
  id int auto_increment primary key ,
  role_key varchar(20) not null unique ,
  role_name varchar(20) not null unique ,
  deleted tinyint(1)
);

create table T_USER_ROLE(
  uid int not null,
  roleid int not null
);

create table T_FUN_ROLE (
  rid int not null,
  fid int not null
);

create table T_FUNCTIONS (
  id int auto_increment primary key ,
  fkey varchar(20) not null unique ,
  name varchar(20) not null ,
  pid int ,
  visible tinyint(1) not null
);

create table T_FUN_METHOD (
  id int auto_increment primary key ,
  fid int,
  controller varchar(30) not null,
  method varchar(30) not null
);
