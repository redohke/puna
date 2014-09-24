create table pizza(
	id tinyint not null,
	nimi varchar(25) not null,
	hinta decimal(5,2) not null,
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
	primary key (id)
);

create table taytepizza(
	id tinyint not null,
	pizza_id tinyint not null,
	tayte_id tinyint not null,
	primary key (id)
	foreign key (tayte_id) references tayte(id)
	foreign key (pizza_id) references pizza(id)
);