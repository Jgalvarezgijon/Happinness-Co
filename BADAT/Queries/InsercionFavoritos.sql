USE HappinessCo;

INSERT INTO favoritos(idUsuario, idEvento)
VALUES
(1, 1), (1, 2), (1, 4), --Usuario 1 tiene como favoritos los eventos pasados (1, 2) y el evento futuro (4)
(2, 2), (2, 3), (2, 5), --Usuario 2 tiene como favoritos los eventos pasados (2, 3) y el evento futuro (5)
(3, 1), (3, 3), (3, 6); --Usuario 3 tiene como favoritos los eventos pasados (2) y los eventos futuros (4, 5)