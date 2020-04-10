create table users
(
  id           int primary key auto_increment,
  username     varchar(50) UNIQUE,
  password     varchar(50),
  role_id      int(2),
  created_date datetime default current_timestamp(),
  status       int(2)   default 1
);

create table roles
(
  id     int primary key auto_increment,
  name   varchar(50),
  status int(2) default 1
);

create table customer
(
  id            int primary key auto_increment,
  name          varchar(50),
  surname       varchar(50),
  customer_code varchar(50),
  email         varchar(50),
  address       varchar(50),
  created_date  datetime default current_timestamp(),
  phone         varchar(50),
  merchant_type int(10),
  status        int(2)   default 1
);

create table merchant
(
  id     int primary key auto_increment,
  name   varchar(50),
  status int(2) default 1
);

create table product
(
  id              int primary key auto_increment,
  name            varchar(50),
  category_id     int,
  description     varchar(50),
  price           decimal(50),
  created_date    datetime default current_timestamp(),
  payment_type_id int,
  status          int(2)   default 1
);

create table category
(
  id     int primary key auto_increment,
  name   varchar(50),
  status int(2) default 1
);

create table payment_type
(
  id     int primary key auto_increment,
  name   varchar(50),
  status int(2) default 1
);


