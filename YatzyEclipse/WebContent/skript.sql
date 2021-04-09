
DROP SCHEMA IF EXISTS yatzy  CASCADE;
CREATE SCHEMA yatzy;
SET search_path = yatzy;

CREATE TABLE Resultat 
(
   spillID INTEGER, --Finn ut
   spillerId INTEGER, --Finn ut 
   enere INTEGER, 
   toere INTEGER,    
   treere INTEGER, 
   firere INTEGER, 
   femere INTEGER,
   seksere INTEGER, 
   sum1 INTEGER, 
   bonus INTEGER, 
   etPar INTEGER, 
   toPar INTEGER, 
   treLike INTEGER, 
   fireLike INTEGER, 
   litenStraight INTEGER, 
   storStraight INTEGER, 
   hus INTEGER, 
   sjanse INTEGER, 
   yatzy INTEGER, 
   totalSum INTEGER, 
   PRIMARY KEY (spillID, spillerId)
);

CREATE TABLE Bruker
(	
	spillerId SERIAL,
	navn varchar,
	score INTEGER, 
	passord varchar, 
	email varchar, 
	brukernavn varchar,
	PRIMARY KEY (spillerId)
);

CREATE TABLE Spill
( 
 spillID SERIAL,
 spillNavn varchar,
 admin varchar,
 PRIMARY KEY (spillID)
);












