USE HappinessCo;

CREATE TABLE imagenes(
	id INT IDENTITY(1,1),
	titulo VARCHAR(50) NOT NULL,
	imagen VARCHAR(255) NOT NULL,
	idGaleria INT NOT NULL,

	CONSTRAINT PK_imagenes PRIMARY KEY (id),
	CONSTRAINT FK_imagenes_galeria FOREIGN KEY (idGaleria) REFERENCES galeria(id)
	ON DELETE CASCADE
);