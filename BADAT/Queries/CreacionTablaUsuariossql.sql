USE HappinessCO;

CREATE TABLE usuarios(
	id INT IDENTITY(1,1),
	nombre VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,

	CONSTRAINT PK_usuarios PRIMARY KEY (id),
	CONSTRAINT UQ_email UNIQUE (email),
	CONSTRAINT CK_password CHECK (LEN(password) >= 8),
	CONSTRAINT CK_email CHECK (email LIKE '%@%.%')
);

