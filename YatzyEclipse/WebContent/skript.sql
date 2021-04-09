
DROP SCHEMA IF EXISTS yatzy  CASCADE;
CREATE SCHEMA yatzy;
SET search_path = yatzy;

CREATE TABLE Resultat 
(
   spillID INTEGER, --Finn ut
   brukernavn varchar, --Finn ut 
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
   PRIMARY KEY (spillID, brukernavn)
);

CREATE TABLE Bruker
(	
	spillerId SERIAL,
	navn varchar,
	score INTEGER, 
	passord varchar, 
	email varchar, 
	PRIMARY KEY (brukernavn)
);

CREATE TABLE Spill
( 
 spillID SERIAL,
 spillNavn varchar,
 PRIMARY KEY (spillID)
);

ALTER TABLE Resultat ADD constraint Res_fk  FOREIGN KEY (spillID) REFERENCES Spill(spillID);
ALTER TABLE Resultat ADD constraint Res_fk2  FOREIGN KEY (spillerId) REFERENCES Bruker(brukenavn);











