USE HappinessCo;

CREATE TABLE galeria(
	id INT IDENTITY(1,1),
	titulo VARCHAR(50) NOT NULL,
	idEvento INT NOT NULL,

	CONSTRAINT PK_galeria PRIMARY KEY (id),
	CONSTRAINT UQ_galeria UNIQUE (idEvento),
	CONSTRAINT FK_galeria_evento FOREIGN KEY (idEvento) REFERENCES eventos(id)
	ON DELETE CASCADE
);