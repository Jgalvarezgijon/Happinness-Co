CREATE VIEW vw_EventosFavoritosUsuario2Post280226 AS
SELECT e.*
FROM eventos e
JOIN favoritos f ON e.id = f.idEvento
JOIN usuarios u ON f.idUsuario = u.id
WHERE u.id = 2
AND fecha > '2026-02-28';