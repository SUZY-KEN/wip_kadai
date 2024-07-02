CREATE TABLE IF NOT EXISTS houses(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50)NOT NULL,
	image_name VARCHAR(255),
	description VARCHAR(255),
	price INT NOT NULL,
	capacity INT NOT NULL,
	postal_code VARCHAR(50)NOT NULL,
	address VARCHAR(255)NOT NULL,
	phone_number VARCHAR(255) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 );
	

	
create table if not exists roles(
id INT not null PRIMARY KEY  AUTO_INCREMENT,
name VARCHAR (50) not null
) 	;
	
create table if not exists users(
id INT  not null primary key AUTO_INCREMENT ,
name VARCHAR (50) not null,
furigana VARCHAR (50) not null,
postal_code VARCHAR (50) not null,
address VARCHAR  (255) not null,
phone_number VARCHAR (50) not null,
email VARCHAR (255) not null,
password VARCHAR (255) not null,
role_id INT not null,
enable boolean not null,
created_at DATETIME not null DEFAULT  CURRENT_TIMESTAMP ,
uodate_at DATETIME  not null DEFAULT  CURRENT_TIMESTAMP  ON UPDATE  CURRENT_TIMESTAMP 
);


