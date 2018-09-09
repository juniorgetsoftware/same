
-- INSERINDO PERFIL
INSERT INTO perfil (id, status, versao, descricao, nome) VALUES (1, 'ATIVO', 0, 'ADMINISTRADOR', 'ADMINISTRADOR');

-- INSERINFO USUÁRIO
INSERT INTO usuario (id, status, versao, senha, perfil_id, nome_completo, email) VALUES (1, 'ATIVO', 0, '202cb962ac59075b964b07152d234b70', 1, 'Usuário administrador', 'user@admin');

-- INSERINDO PÁGINAS
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (1,'ATIVO',0,'Descrição','Cadastrar Página','CADASTRAR_PAGINA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (2,'ATIVO',0,'Descrição','Editar Página','EDITAR_PAGINA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (3,'ATIVO',0,'Descrição','Listar Página','LISTAR_PAGINA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (4,'ATIVO',0,'Descrição','Cadastrar Perfil','CADASTRAR_PERFIL');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (5,'ATIVO',0,'Descrição','Editar Perfil','EDITAR_PERFIL');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (6,'ATIVO',0,'Descrição','Listar Perfil','LISTAR_PERFIL');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (7,'ATIVO',0,'Descrição','Cadastrar Usuário','CADASTRAR_USUARIO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (8,'ATIVO',0,'Descrição','Editar Usuário','EDITAR_USUARIO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (9,'ATIVO',0,'Descrição','Listar Usuário','LISTAR_USUARIO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (10,'ATIVO',0,'Descrição','Cadastrar Pessoa','CADASTRAR_PESSOA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (11,'ATIVO',0,'Descrição','Editar Pessoa','EDITAR_PESSOA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (12,'ATIVO',0,'Descrição','Listar Pessoa','LISTAR_PESSOA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (13,'ATIVO',0,'Descrição','Cadastrar Atividade Eclesiástica','CADASTRAR_ATIVIDADE_ECLESIASTICA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (14,'ATIVO',0,'Descrição','Editar Atividade Eclesiástica','EDITAR_ATIVIDADE_ECLESIASTICA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (15,'ATIVO',0,'Descrição','Listar Atividade Eclesiástica','LISTAR_ATIVIDADE_ECLESIASTICA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (16,'ATIVO',0,'Descrição','Cadastrar Categoria Movimentação','CADASTRAR_CATEGORIA_MOVIMENTACAO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (17,'ATIVO',0,'Descrição','Editar Categoria Movimentação','EDITAR_CATEGORIA_MOVIMENTACAO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (18,'ATIVO',0,'Descrição','Listar Categoria Movimentação','LISTAR_CATEGORIA_MOVIMENTACAO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (19,'ATIVO',0,'Descrição','Cadastrar Movimentação','CADASTRAR_MOVIMENTACAO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (20,'ATIVO',0,'Descrição','Editar Movimentação','EDITAR_MOVIMENTACAO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (21,'ATIVO',0,'Descrição','Listar Movimentação','LISTAR_MOVIMENTACAO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (22,'ATIVO',0,'Descrição','Cadastrar Evento','CADASTRAR_EVENTO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (23,'ATIVO',0,'Descrição','Editar Evento','EDITAR_EVENTO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (24,'ATIVO',0,'Descrição','Listar Evento','LISTAR_EVENTO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (25,'ATIVO',0,'Cadastrar patrimônio','Cadastrar patrimônio','CADASTRAR_PATRIMONIO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (26,'ATIVO',0,'patrimônio','Editar patrimônio','EDITAR_PATRIMONIO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (27,'ATIVO',0,'Listar patrimônio','Listar patrimônio','LISTAR_PATRIMONIO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (28,'ATIVO',0,'Cadastrar Dízimo','Cadastrar Dízimo','CADASTRAR_DIZIMO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (29,'ATIVO',0,'Editar Dízimo','Editar Dízimo','EDITAR_DIZIMO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (30,'ATIVO',0,'Listar Dízimo','Listar Dízimo','LISTAR_DIZIMO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (31,'ATIVO',0,'Cadastrar cargo','Cadastrar cargo','CADASTRAR_CARGO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (32,'ATIVO',0,'Editar cargo','Editar cargo','EDITAR_CARGO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (33,'ATIVO',0,'Listar cargo','Listar cargo','LISTAR_CARGO');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (34,'ATIVO',0,'Cadastrar Diretoria','Cadastrar Diretoria','CADASTRAR_DIRETORIA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (35,'ATIVO',0,'Editar Diretoria','Editar Diretoria','EDITAR_DIRETORIA');
INSERT INTO pagina (id, status, versao, descricao, nome, nome_identificador) VALUES (36,'ATIVO',0,'Listar Diretoria','Listar Diretoria','LISTAR_DIRETORIA');


-- RELACIONANDO USUÁRIO E PÁGINAS
INSERT INTO usuario_pagina (usuario_id, pagina_id) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36);
 

-- RELACIONANDO PERFIL E PÁGINAS
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	1	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	2	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	3	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	4	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	5	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	6	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	7	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	8	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	9	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	10	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	11	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	12	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	13	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	14	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	15	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	16	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	17	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	18	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	19	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	20	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	21	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	22	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	23	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	24	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	25	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	26	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	27	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	28	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	29	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	30	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	31	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	32	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	33	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	34	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	35	);
INSERT INTO perfil_pagina(perfil_id, pagina_id) VALUES (1,	36	);