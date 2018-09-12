
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

-- RELACIONANDO USUÁRIO E PÁGINAS
INSERT INTO usuario_pagina (usuario_id, pagina_id) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9);

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