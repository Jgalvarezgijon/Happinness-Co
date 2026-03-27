USE HappinessCo;

CREATE TABLE eventos(
	id INT IDENTITY(1,1),
	titulo VARCHAR(100) NOT NULL,
	ubicacion VARCHAR(50) NOT NULL,
	descripcion VARCHAR(300) NOT NULL,
	fecha DATE NOT NULL,

	CONSTRAINT PK_eventos PRIMARY KEY (id),
	CONSTRAINT UQ_evento UNIQUE (titulo, fecha)
);
