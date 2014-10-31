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
	pizza_id tinyint not null,
	juoma_id tinyint not null,
	tilaaja varchar(25) not null,
	osoite varchar(30) not null, 
	ptm varchar(30) not null,
	puh varchar(15) not null, 
	misc varchar(100) not null,
	primary key (id),
	foreign key (pizza_id) references pizza(id),
	foreign key (juoma_id) references juoma(id)
	
);

