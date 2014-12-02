create table pizza(
	id tinyint not null AUTO_INCREMENT,
	nimi varchar(25) not null,
	hinta decimal(5,2) not null,
	tarjolla boolean not null,
	primary key (id)
);

create table tayte(
	id tinyint not null AUTO_INCREMENT,
	nimi varchar(25) not null,
	primary key (id)
);

create table juoma(
	id tinyint not null AUTO_INCREMENT,
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
	id int not null AUTO_INCREMENT,
	asiakas_id tinyint not null,
	kokonaishinta double not null,
	primary key (id),
	foreign key (asiakas_id) references asiakas(id)
	
);


create table asiakas(
	id tinyint not null AUTO_INCREMENT,
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
	id tinyint not null AUTO_INCREMENT,
	pizza_id tinyint,
	juoma_id tinyint,
	kpl int not null,
	hinta double not null,
	oreg boolean not null,
	vsip boolean not null,
	tilaus_id int not null,
	primary key (id),
	foreign key (pizza_id) references pizza(id),
	foreign key (juoma_id) references juoma(id),
	foreign key (tilaus_id) references tilaus(id)
);
