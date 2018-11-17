-- ESCOLA
INSERT INTO escola (id, nome, descricao, versao, status) VALUES (1,'CEBCJEC','Colégio de Educação Básica José Epifânio das Chagas', 0, 'ATIVO');
INSERT INTO escola (id, nome, descricao, versao, status) VALUES (2,'Escola Capitão','Escola de Eeducação Básica Capitão José Raimundo Evangelista', 0, 'ATIVO');
INSERT INTO escola (id, nome, descricao, versao, status) VALUES (3,'Ana Clara','Escola de Eeducação Básica Ana Clara Andrade Nantua Bento', 0, 'ATIVO');
INSERT INTO escola (id, nome, descricao, versao, status) VALUES (4,'Perboyre Girao','Escola de Eeducação Básica Prefeito Perboyre Girao', 0, 'ATIVO');

-- PERÍODO LETIVO
INSERT INTO periodo_letivo (id, nome, descricao, escola_id, versao, status) VALUES (1,'2017/1','Alguma descrição sobre o período letivo.', 1, 0, 'ATIVO');
INSERT INTO periodo_letivo (id, nome, descricao, escola_id, versao, status) VALUES (2,'2017/2','Alguma descrição sobre o período letivo.', 1, 0, 'ATIVO');
INSERT INTO periodo_letivo (id, nome, descricao, escola_id, versao, status) VALUES (3,'2018/1','Alguma descrição sobre o período letivo.', 1, 0, 'ATIVO');
INSERT INTO periodo_letivo (id, nome, descricao, escola_id, versao, status) VALUES (4,'2018/1','Alguma descrição sobre o período letivo.', 2, 0, 'ATIVO');
INSERT INTO periodo_letivo (id, nome, descricao, escola_id, versao, status) VALUES (5,'2018/1','Alguma descrição sobre o período letivo.', 3, 0, 'ATIVO');
INSERT INTO periodo_letivo (id, nome, descricao, escola_id, versao, status) VALUES (6,'2018/1','Alguma descrição sobre o período letivo.', 4, 0, 'ATIVO');

-- TURMA
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (1,'1A - Primeiro A','Alguma descrição sobre a turma', 1 , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (2,'2A - Segundo A','Alguma descrição sobre a turma', 1  , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (3,'2B - Segundo B','Alguma descrição sobre a turma', 1  , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (4,'1A - Primeiro A','Alguma descrição sobre a turma', 2 , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (5,'2A - Segundo A','Alguma descrição sobre a turma', 2  , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (6,'2B - Segundo B','Alguma descrição sobre a turma', 2  , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (7,'1A - Primeiro A','Alguma descrição sobre a turma', 3 , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (8,'2A - Segundo A','Alguma descrição sobre a turma', 3  , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (9,'2B - Segundo B','Alguma descrição sobre a turma', 4  , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (10,'1A - Primeiro A','Alguma descrição sobre a turma', 4, 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (11,'2A - Segundo A','Alguma descrição sobre a turma', 5 , 0, 'ATIVO');
INSERT INTO turma (id, nome, descricao, periodo_letivo_id, versao, status) VALUES (12,'2B - Segundo B','Alguma descrição sobre a turma', 6 , 0, 'ATIVO');

-- PROFESSOR
INSERT INTO professor (id, nome, versao, status) VALUES(1,'Wilton Aureliano', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(2,'Neide Lima', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(3,'Alex Wilton', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(4,'Aline Mysna', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(5,'Amanda Miller', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(6,'Junior Oliveira', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(7,'Ian Lucas', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(8,'David Emanuell', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(9,'Cícero Aureliano', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(10,'Maria Ambrosina', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(11,'Francisco Alves', 0, 'ATIVO');
INSERT INTO professor (id, nome, versao, status) VALUES(12,'Maria José', 0, 'ATIVO');

-- DISCIPLINA
INSERT INTO disciplina (id, nome, versao, status) VALUES(1,'Português', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(2,'Matemática', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(3,'Biologia', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(4,'Química', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(5,'História', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(6,'Geografia', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(7,'Inglês', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(8,'Espanhol', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(9,'Geometria', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(10,'Filosofia', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(11,'Física', 0, 'ATIVO');
INSERT INTO disciplina (id, nome, versao, status) VALUES(12,'Educação Física', 0, 'ATIVO');

-- RELAÇÃO PROFESSOR-DISCIPLINA
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (1, 1);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (1, 2);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (2, 2);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (2, 3);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (3, 3);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (3, 4);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (3, 5);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (4, 4);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (4, 5);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (5, 5);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (5, 6);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (6, 6);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (6, 7);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (6, 8);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (6, 9);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (6, 10);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (6, 11);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (7, 7);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (8, 8);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (9, 9);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (10, 10);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (11, 11);
INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (12, 12);

-- ALUNO
INSERT INTO aluno (id, nome, versao, status) VALUES (1,'Adélia Querino', 0, 'ATIVO');
INSERT INTO aluno (id, nome, versao, status) VALUES (2,'Aldo Delgado', 0, 'ATIVO');
INSERT INTO aluno (id, nome, versao, status) VALUES (3,'Anind Felipe', 0, 'ATIVO');
INSERT INTO aluno (id, nome, versao, status) VALUES (4,'Anita Mascarenhas', 0, 'ATIVO');
INSERT INTO aluno (id, nome, versao, status) VALUES (5,'Antônio Veríssimo', 0, 'ATIVO');
INSERT INTO aluno (id, nome, versao, status) VALUES (6,'Belmira Trindade', 0, 'ATIVO');
INSERT INTO aluno (id, nome, versao, status) VALUES (7,'Benedito Nóbrega', 0, 'ATIVO');
INSERT INTO aluno (id, nome, versao, status) VALUES (8,'Bukake Severo', 0, 'ATIVO');
 
-- INSERT INTO aluno (id, nome, versao, status) VALUES (9,'Carmem Paranaguá', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (10,'Carmem Teves', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (11,'Catarina Castelo', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (12,'Cleusa Torquato', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (13,'Clóvis Cortés', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (14,'David Grande', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (15,'Davide Batata', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (16,'Elia Simão', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (17,'Elias Robalo', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (18,'Emílio Bandeira', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (19,'Estefânia Gravato', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (20,'Eudes Viégas', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (21,'Eunice Assis', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (22,'Fabiana Muniz', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (23,'Gregório Imbassaí', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (24,'Gregório Siqueira', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (25,'Honório Brito', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (26,'Hélio Vila-Chã', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (27,'Ilma Mortágua', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (28,'Inês Caires', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (29,'Isaura Viera', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (30,'Manuela Lopes', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (31,'Maíra Vilhena', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (32,'Natividade Quental', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (33,'NoêmiaCarrasqueira', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (34,'Paulina Peseiro', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (35,'Paulino Varanda', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (36,'Paulino Vianna', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (37,'Quitéria Hierro', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (38,'Rogério Camelo', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (39,'Ronaldo Alves', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (40,'Ruca Novalles', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (41,'Rudi Estrela', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (42,'Rúben Cerveira', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (43,'SidônioLeal', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (44,'Soeiro Gouveia', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (45,'Tainá Soares', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (46,'Urânia Gracia', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (47,'Valéria Parracho', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (48,'Vanda Valle', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (49,'Violeta Lira', 0, 'ATIVO');
-- INSERT INTO aluno (id, nome, versao, status) VALUES (50,'Zuleide Seabra', 0, 'ATIVO');
 

-- RELAÇÃO TURMA-ALUNO
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 1);
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 2);
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 3);
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 4);
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 5);

-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 6);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 7);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 8);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 9);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 10);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 11);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 12);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 13);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 14);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 15);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 16);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 17);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 18);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 19);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 20);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 21);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 22);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 23);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 24);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 25);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 26);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 27);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 28);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 29);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 30);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 31);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 32);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 33);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 34);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 35);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 36);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 37);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 38);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 39);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 40);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 41);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 42);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 43);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 44);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 45);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 46);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 47);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 48);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 49);
-- INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 50);

-- PROVA
INSERT INTO prova (id, titulo, observacao, versao, status, turma_id) VALUES (1, 'Prova de matemática', 'Observações da prova...', 0, 'ATIVO', 1);

INSERT INTO questao (id, enunciado, prova_id, versao, status) VALUES (1, 'Quanto é 1 + 1?', 1, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (1, '1', 0, 1, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (2, '2', 1, 1, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (3, '3', 0, 1, 0, 'ATIVO');


INSERT INTO questao (id, enunciado, prova_id, versao, status) VALUES (2, 'Quanto é 2 + 2?', 1, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (4, '4', 1, 2, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (5, '2', 0, 2, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (6, '3', 0, 2, 0, 'ATIVO');


INSERT INTO questao (id, enunciado, prova_id, versao, status) VALUES (3, 'Quanto é 3 + 3?', 1, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (7, '1', 0, 3, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (8, '2', 0, 3, 0, 'ATIVO');
INSERT INTO alternativa (id, descricao, resposta, questao_id, versao, status) VALUES (9, '6', 1, 3, 0, 'ATIVO');


INSERT INTO gabarito (id, status, versao, observacao, titulo, prova_id) VALUES (1, 'ATIVO', 0, 'Observações sobre o gabarito da prova de matemática',  'Gabarito da prova de matemática', 1);

		
INSERT INTO gabarito_questao_alternativa (id, status, versao, gabarito_id, questao_id, alternativa_id) VALUES (1, 'ATIVO', 0, 1, 1, 2);
INSERT INTO gabarito_questao_alternativa (id, status, versao, gabarito_id, questao_id, alternativa_id) VALUES (2, 'ATIVO', 0, 1, 2, 4);
INSERT INTO gabarito_questao_alternativa (id, status, versao, gabarito_id, questao_id, alternativa_id) VALUES (3, 'ATIVO', 0, 1, 3, 9);

