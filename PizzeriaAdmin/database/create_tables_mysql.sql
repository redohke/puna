CREATE TABLE tayte (
        id				int not null,
        nimi			nvarchar(25) not null,
        PRIMARY KEY 	(id)
);

CREATE TABLE pizza (
        id				int not null,
        nimi			nvarchar(25) not null,
        hinta			decimal(5,2) not null,
        PRIMARY KEY 	(id)
);

CREATE TABLE taytepizza (
        id				int not null,
       	pizza_id		int not null,
        tayte_id		int not null,
		PRIMARY KEY 	(id)
		FOREIGN KEY 	(tayte_id) REFERENCES tayte(id)
		FOREIGN KEY 	(pizaz_id) REFERENCES pizza(id)
);

CREATE TABLE juoma (
        id				int not null,
        nimi			nvarchar(50) not null,
        hinta			decimal(5,2) not null,
        PRIMARY KEY 	(id)
);
