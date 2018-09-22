INSERT INTO escola (id, nome, descricao) VALUES (1, 'CEBCJEC', 'Colégio de Educação Básica José Epifânio das Chagas');
INSERT INTO escola (id, nome, descricao) VALUES (2, 'Escola Capitão', 'Escola de Eeducação Básica Capitão José Raimundo Evangelista');
INSERT INTO escola (id, nome, descricao) VALUES (3, 'Ana Clara', 'Escola de Eeducação Básica Ana Clara Andrade Nantua Bento');
INSERT INTO escola (id, nome, descricao) VALUES (4, 'Perboyre Girao', 'Escola de Eeducação Básica Prefeito Perboyre Girao');

INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (1, '2017/1', 'Alguma descrição sobre o período letivo.', 1);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (2, '2017/2', 'Alguma descrição sobre o período letivo.', 1);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (3, '2018/1', 'Alguma descrição sobre o período letivo.', 1);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (4, '2018/1', 'Alguma descrição sobre o período letivo.', 2);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (5, '2018/1', 'Alguma descrição sobre o período letivo.', 3);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (6, '2018/1', 'Alguma descrição sobre o período letivo.', 4);

INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (1, '1A - Primeiro A', 'Alguma descrição sobre a turma', 1);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (2, '2A - Segundo A', 'Alguma descrição sobre a turma', 1);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (3, '2B - Segundo B', 'Alguma descrição sobre a turma', 1);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (4, '1A - Primeiro A', 'Alguma descrição sobre a turma', 2);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (5, '2A - Segundo A', 'Alguma descrição sobre a turma', 2);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (6, '2B - Segundo B', 'Alguma descrição sobre a turma', 2);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (7, '1A - Primeiro A', 'Alguma descrição sobre a turma', 3);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (8, '2A - Segundo A', 'Alguma descrição sobre a turma', 3);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (9, '2B - Segundo B', 'Alguma descrição sobre a turma', 4);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (10, '1A - Primeiro A', 'Alguma descrição sobre a turma', 4);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (11, '2A - Segundo A', 'Alguma descrição sobre a turma', 5);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (12, '2B - Segundo B', 'Alguma descrição sobre a turma', 6);
