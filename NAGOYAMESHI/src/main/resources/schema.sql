

create table if not exists categories(
id int not null auto_increment primary key,
name varchar (50)not null

);

create table if not exists restaurants(
id int not null auto_increment primary key,
name varchar (50) not null,
image varchar(255),
price int not null,
category_id int not null,
sales_date varchar(50),
description varchar (255),
address varchar(255) not null,
evalues int not null,
foreign key (category_id) references categories (id)

);

create table if not exists roles(
id int not null auto_increment primary key,
role_name varchar (50) not null

);


create table if not exists users(
id int not null auto_increment primary key,
name varchar (50) not null,
email varchar(255)  not null unique ,
password varchar(255) not null,
role_id int not null,
enabled BOOLEAN NOT NULL,
created_at datetime not null DEFAULT CURRENT_TIMESTAMP,
foreign key (role_id) references roles (id)

);




create table if not exists reviews(
id int not null auto_increment primary key,
name varchar (50) not null,
restaurant_id int  not null,
user_id int not null,
evalue int not null,
review_comment varchar (255) not null,
created_at datetime not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
foreign key (restaurant_id) references restaurants (id),
foreign key (user_id) references users(id)

);