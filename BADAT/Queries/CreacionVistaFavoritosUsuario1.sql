CREATE VIEW vw_EventosFavoritosUsuario1 AS
SELECT 
	e.*
FROM usuarios u
JOIN favoritos f ON u.id = f.idUsuario
JOIN eventos e ON f.idEvento = e.id
WHERE u.id = 1;