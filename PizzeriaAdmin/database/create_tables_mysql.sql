create table pizza(
	id tinyint not null,
	nimi varchar(25) not null,
	hinta decimal(5,2) not null,
	tarjolla boolean not null,
	primary key (id)
);

create table tayte(
	id tinyint not null,
	nimi varchar(25) not null,
	primary key (id)
);

create table juoma(
	id tinyint not null,
	nimi varchar(25) not null,
	hinta decimal(5,2) not null,
	tarjolla boolean not null,
	primary key (id)
);

create table pizzatayte(
	id tinyint not null,
	pizza_id tinyint not null,
	tayte_id tinyint not null,
	primary key (id),
	foreign key (tayte_id) references tayte(id),
	foreign key (pizza_id) references pizza(id)
);



create table tilaus(
	id int not null,
	asiakas_id tinyint not null,
	tilausrivi_id tinyint not null,
	kokonaishinta double not null,
	primary key (id),
	foreign key (asiakas_id) references asiakas(id),
	foreign key (tilausrivi_id) references tilausrivi(id)
	
);


create table asiakas(
	id tinyint not null,
	etunimi varchar(15) not null,
	sukunimi varchar(30) not null,
	yritys varchar(30) not null,
	puhelin varchar(30) not null,
	sposti varchar(30) not null,
	osoite varchar(30) not null,
	postinumero varchar(5) not null,
	kaupunki varchar(10) not null,
	primary key (id)

);

create table tilausrivi(
	id tinyint not null,
	pizza_id tinyint not null,
	juoma_id tinyint not null,
	kpl int not null,
	hinta double not null,
	oreg boolean not null,
	vsip boolean not null,
	primary key (id),
	foreign key (pizza_id) references pizza(id),
	foreign key (juoma_id) references juoma(id)

);

CREATE TABLE webuser (
	id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(255) NOT NULL UNIQUE KEY,
	password_hash VARCHAR(255) NOT NULL,
	salt VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO webuser (id, username, password_hash, salt)
VALUES ('1','admin','D5AevqWWK3yja6C/2C/BtkpizQwof0XUT3NnytdBzpgGs2O2cPjgda4Wsr5fb10wwVEzsYO+T5M5oadfY7Ggsw==','zJC1+pwT1D0=');
