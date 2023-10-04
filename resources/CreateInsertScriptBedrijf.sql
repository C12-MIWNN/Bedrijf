CREATE SCHEMA `Bedrijf`;
USE `Bedrijf`;
--
-- Tabel structuur voor tabel `Afdeling`
--
CREATE TABLE `Afdeling` (
  `afdelingsnaam` varchar(45) NOT NULL,
  `afdelingsplaats` varchar(45) NOT NULL,
  PRIMARY KEY (`afdelingsnaam`)
) ;
--
-- Tabel structuur voor tabel `Persoon`
--
CREATE TABLE `Persoon` (
  `personeelsnummer` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(45) NOT NULL,
  `woonplaats` varchar(45) NOT NULL,
  `afdeling` varchar(45) NOT NULL,
  PRIMARY KEY (`personeelsnummer`),
  KEY `fk_Persoon_Afdeling_idx` (`afdeling`),
  CONSTRAINT `fk_Persoon_Afdeling` FOREIGN KEY (`afdeling`) REFERENCES `Afdeling` (`afdelingsnaam`)
) ;
--
-- Tabel structuur voor tabel `Werknemer`
--
CREATE TABLE `Werknemer` (
  `personeelsnummer` int(11) NOT NULL,
  `maandsalaris` decimal(8,2) NOT NULL,
  
  PRIMARY KEY (`personeelsnummer`),
  KEY `fk_Werknemer_Figuur_idx` (`personeelsnummer`),
  CONSTRAINT `fk_Werknemer_Persoon` FOREIGN KEY (`personeelsnummer`) REFERENCES `Persoon` (`personeelsnummer`)
) ;

insert into afdeling values ('Uitvoering', 'Hilversum');
insert into afdeling values ('Support', 'Amsterdam');
insert into afdeling values ('Management', 'Almere');
insert into afdeling values ('Documentatie', 'Gouda');
insert into afdeling values ('Projecten', 'Almere');
insert into afdeling values ('Interne Audit', 'Almere');
insert into afdeling values ('Beveiliging', 'Almere');
insert into afdeling values ('Beleid', 'Almere');
insert into afdeling values ('Secretariaat', 'Amsterdam');
insert into afdeling values ('IT Ontwikkeling', 'Amsterdam');
insert into afdeling values ('IT Productie', 'Amsterdam');
insert into afdeling values ('Public Relations', 'Hilversum');
insert into afdeling values ('Communicatie', 'Hilversum');
insert into afdeling values ('Sociale Media', 'Hilversum');
insert into afdeling values ('Archief', 'Gouda');
insert into afdeling values ('Data mining', 'Gouda');
insert into afdeling values ('Procesmanagemnt', 'Gouda');
insert into afdeling values ('Quality Management', 'Gouda');

insert into persoon(`naam`, `woonplaats`, `afdeling`) values ('Mark', 'Den Haag', 'Management');
insert into persoon(`naam`, `woonplaats`, `afdeling`) values ('Caroline', 'Delft', 'Support');
insert into persoon(`naam`, `woonplaats`, `afdeling`) values ('Klaas', 'Diemen', 'Documentatie');
insert into persoon(`naam`, `woonplaats`, `afdeling`) values ('Ronald', 'Zaandam', 'Uitvoering');
insert into persoon(`naam`, `woonplaats`, `afdeling`) values ('Angelique', 'Rotterdam', 'Management');
insert into persoon(`naam`, `woonplaats`, `afdeling`) values ('Jannie', 'Utrecht', 'Uitvoering');
insert into persoon(`naam`, `woonplaats`, `afdeling`) values ('Anne', 'Zwolle', 'Uitvoering');

insert into werknemer values (1, 10000);
insert into werknemer values (2, 4000);
insert into werknemer values (3, 2000);
insert into werknemer values (4, 3000);
insert into werknemer values (5, 2500);
insert into werknemer values (6, 3500);

CREATE USER 'userBedrijf'@'localhost' IDENTIFIED BY 'userBedrijfPW';
GRANT ALL PRIVILEGES ON Bedrijf . * TO 'userBedrijf'@'localhost';