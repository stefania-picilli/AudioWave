DROP DATABASE IF EXISTS AudioWave;
CREATE DATABASE AudioWave;

USE AudioWave;

DROP USER IF EXISTS 'AudioWave'@'localhost';
CREATE USER 'AudioWave'@'localhost' IDENTIFIED BY 'AudioWave';
GRANT ALL ON AudioWave.* TO 'AudioWave'@'localhost';


DROP TABLE IF EXISTS Utente;
CREATE TABLE Utente(

email			VARCHAR(128)	NOT NULL,
password		VARCHAR(256)	NOT NULL,
ruolo			ENUM ('utente', 'admin') DEFAULT 'utente',
nome 			VARCHAR(128)	NOT NULL,
cognome			VARCHAR(128)	NOT NULL,
dataDiNascita	DATE,
cellulare		VARCHAR(20),

PRIMARY KEY(email)

);

DROP TABLE IF EXISTS Ordine;
CREATE TABLE Ordine(

numeroOrdine	INT				NOT NULL AUTO_INCREMENT,
data			DATE 			NOT NULL,
indirizzo		VARCHAR(256)	NOT NULL,
statoOrdine		ENUM ('Pagato', 'Spedito', 'Consegnato')		DEFAULT 'Pagato',
costoTotale		DOUBLE 			NOT NULL,
metodoPagamento VARCHAR(5)		NOT NULL,
email			VARCHAR(256)	NOT NULL,

PRIMARY KEY(numeroOrdine),
FOREIGN KEY(email) REFERENCES Utente(email) ON DELETE cascade ON UPDATE cascade

);

DROP TABLE IF EXISTS Categoria;
CREATE TABLE Categoria(

ID			INT 			NOT NULL AUTO_INCREMENT,
nome		VARCHAR(128)	NOT NULL,

PRIMARY KEY(ID)

);


DROP TABLE IF EXISTS Prodotto;
CREATE TABLE Prodotto(

codiceProdotto	INT				NOT NULL AUTO_INCREMENT,
nome			VARCHAR(128)	NOT NULL,
immagine		VARCHAR(256) 	NOT NULL,
marca			VARCHAR(128)	NOT NULL,
descrizione		VARCHAR(1500)	NOT NULL,
prezzo 		 	DOUBLE			NOT NULL,
disponibilita	INT 			NOT NULL,
IVA 			DOUBLE 			NOT NULL,
categoriaID		INT 			NOT NULL,

PRIMARY KEY(codiceProdotto),
FOREIGN KEY(categoriaID) REFERENCES Categoria(ID) ON DELETE cascade ON UPDATE cascade

);

DROP TABLE IF EXISTS ProdottoAcquistato;
CREATE TABLE ProdottoAcquistato(

ID				INT 			NOT NULL AUTO_INCREMENT,
numeroOrdine	INT				NOT NULL,	
nome			VARCHAR(128)	NOT NULL,
marca			VARCHAR(128)	NOT NULL,
immagine		VARCHAR(245)	NOT NULL,
prezzo 			DOUBLE 			NOT NULL,
IVA 			DOUBLE			NOT NULL,
quantita 		INT 			NOT NULL,
codiceProdotto 	INT ,

PRIMARY KEY(ID, numeroOrdine),
FOREIGN KEY(codiceProdotto) REFERENCES Prodotto(codiceProdotto) ON DELETE set null ON UPDATE cascade,
FOREIGN KEY(numeroOrdine) REFERENCES Ordine(numeroOrdine) ON DELETE cascade ON UPDATE cascade

);

DROP TABLE IF EXISTS Spedizione;
CREATE TABLE Spedizione(

IDSpedizione	INT 			NOT NULL AUTO_INCREMENT,
corriere		VARCHAR(256)	NOT NULL,
dataPartenza	DATE			NOT NULL,
dataArrivo		DATE			NOT NULL,
numeroOrdine	INT				NOT NULL,

PRIMARY KEY(IDSpedizione),
FOREIGN KEY(numeroOrdine) REFERENCES Ordine(numeroOrdine) ON DELETE cascade ON UPDATE cascade

);



