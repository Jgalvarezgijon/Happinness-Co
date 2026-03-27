CREATE VIEW vw_ImagenesEvento120126 AS
SELECT i.*
FROM eventos e
JOIN galeria g ON e.id = g.idEvento
JOIN imagenes i ON g.id = i.idGaleria
WHERE e.fecha = '2026-01-12';