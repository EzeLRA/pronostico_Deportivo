CREATE database pronosticos;

use pronosticos;

create table pronosticos(
	fase int4,
    ronda int4,
    persona varchar(45),
    equipo1 varchar(45),
    gana1 boolean,
    empata boolean,
    gana2 boolean,
    equipo2 varchar(45)
);

insert into pronosticos (fase,ronda,persona,equipo1,gana1,empata,gana2,equipo2)
values (1,1,'Mariana','Argentina',true,false,false,'Arabia Saudita');

	insert into pronosticos (fase,ronda,persona,equipo1,gana1,empata,gana2,equipo2)
	values(1,1,'Pedro','Arabia Saudita',false,true,false,'Polonia');