--Usikker på ka schema osv skal heite????? -> finn ut 
DROP SCHEMA IF EXISTS yatzy  CASCADE;
CREATE SCHEMA yatzy;
SET search_path = yatzy;
--test thea
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

   FOREIGN KEY(spillID) FROM ... , --Finn ut
   FOREIGN KEY(spillerId) FROM Spiller (spillerId) ,
   PRIMARY KEY (spillID, spillerId)
);

CREATE TABLE Spiller
(	
	spillerId SERIAL INTEGER,
	navn varchar,
	score INTEGER, 
	passord varchar, 
	email varchar, 
	brukernavn varchar
);

CREATE TABLE Spill
( -- trenger vi dette?
);












