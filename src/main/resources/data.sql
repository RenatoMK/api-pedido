insert into parametro_imposto  ( TAXA_IMPOSTO , DH_ALTERACAO , DH_INCLUSAO , DESCRICAO_IMPOSTO ) 
values (0.3, TIMESTAMP '2023-10-10 14:30:45.123456', TIMESTAMP '2023-10-10 14:30:45.123456' , 'Imposto informado pela Receita Federal');

INSERT INTO "PUBLIC"."PEDIDO" VALUES
(1001, 1, NULL, NULL, TIMESTAMP '2025-03-09 13:04:01.863102', 15.81, 30, 'Criado'),
(1002, 10, NULL, NULL, TIMESTAMP '2025-03-09 13:08:02.835602', 472.32, 31, 'Criado'),
(1003, 25, NULL, NULL, TIMESTAMP '2025-03-09 13:08:35.174602', 973.23, 32, 'Criado');

INSERT INTO "PUBLIC"."PEDIDOS_ITEM" VALUES
(1001, NULL, NULL, TIMESTAMP '2025-03-09 13:04:01.863102', 1001, 2, 52.70, 1001),
(1002, NULL, NULL, TIMESTAMP '2025-03-09 13:08:02.835602', 11, 2, 52.70, 1002),
(1003, NULL, NULL, TIMESTAMP '2025-03-09 13:08:02.835602', 121, 4, 1521.70, 1002),
(1004, NULL, NULL, TIMESTAMP '2025-03-09 13:08:35.174602', 31, 12, 200.70, 1003),
(1005, NULL, NULL, TIMESTAMP '2025-03-09 13:08:35.174602', 121, 4, 1521.70, 1003),
(1006, NULL, NULL, TIMESTAMP '2025-03-09 13:08:35.174602', 121, 4, 1521.70, 1003);

