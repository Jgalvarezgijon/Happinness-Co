USE HappinessCo;

CREATE TABLE favoritos(
	idUsuario INT NOT NULL,
	idEvento INT NOT NULL,

	CONSTRAINT PK_favorito PRIMARY KEY (idUsuario, idEvento),
	CONSTRAINT FK_favorito_usuario FOREIGN KEY (idUsuario) REFERENCES usuarios(id)
	ON DELETE CASCADE,
	CONSTRAINT FK_favorito_evento FOREIGN KEY (idEvento) REFERENCES eventos(id)
	ON DELETE CASCADE
);