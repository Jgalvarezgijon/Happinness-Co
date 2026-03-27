CREATE VIEW vw_GaleriasEventosPasados AS
SELECT 
	g.id AS idGaleria,
	g.titulo AS tituloGaleria,
	g.idEvento,
	e.titulo AS tituloEvento,
	e.fecha AS fechaEvento
FROM galeria g
JOIN eventos e 
ON g.idEvento = e.id
WHERE e.fecha < '2026-02-28';
