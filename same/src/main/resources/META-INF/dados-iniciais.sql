-- ESCOLA
INSERT INTO escola (id, nome, descricao, versao, status) VALUES (1,'CEBCJEC','Colégio de Educação Básica José Epifânio das Chagas', 0, 'ATIVO');
INSERT INTO escola (id, nome, descricao, versao, status) VALUES (2,'Escola Capitão','Escola de Eeducação Básica Capitão José Raimundo Evangelista', 0, 'ATIVO');
INSERT INTO escola (id, nome, descricao, versao, status) VALUES (3,'Ana Clara','Escola de Eeducação Básica Ana Clara Andrade Nantua Bento', 0, 'ATIVO');
INSERT INTO escola (id, nome, descricao, versao, status) VALUES (4,'Perboyre Girao','Escola de Eeducação Básica Prefeito Perboyre Girao', 0, 'ATIVO');

-- PERÍODO LETIVO
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (1,'2017/1','Alguma descrição sobre o período letivo.', 1);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (2,'2017/2','Alguma descrição sobre o período letivo.', 1);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (3,'2018/1','Alguma descrição sobre o período letivo.', 1);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (4,'2018/1','Alguma descrição sobre o período letivo.', 2);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (5,'2018/1','Alguma descrição sobre o período letivo.', 3);
INSERT INTO periodo_letivo (id, nome, descricao, escola_id) VALUES (6,'2018/1','Alguma descrição sobre o período letivo.', 4);

-- TURMA
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (1,'1A - Primeiro A','Alguma descrição sobre a turma', 1);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (2,'2A - Segundo A','Alguma descrição sobre a turma', 1);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (3,'2B - Segundo B','Alguma descrição sobre a turma', 1);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (4,'1A - Primeiro A','Alguma descrição sobre a turma', 2);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (5,'2A - Segundo A','Alguma descrição sobre a turma', 2);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (6,'2B - Segundo B','Alguma descrição sobre a turma', 2);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (7,'1A - Primeiro A','Alguma descrição sobre a turma', 3);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (8,'2A - Segundo A','Alguma descrição sobre a turma', 3);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (9,'2B - Segundo B','Alguma descrição sobre a turma', 4);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (10,'1A - Primeiro A','Alguma descrição sobre a turma', 4);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (11,'2A - Segundo A','Alguma descrição sobre a turma', 5);
INSERT INTO turma (id, nome, descricao, periodo_letivo_id) VALUES (12,'2B - Segundo B','Alguma descrição sobre a turma', 6);

-- PROFESSOR
INSERT INTO professor (id, nome) VALUES(1,'Wilton Aureliano');
INSERT INTO professor (id, nome) VALUES(2,'Neide Lima');
INSERT INTO professor (id, nome) VALUES(3,'Alex Wilton');
INSERT INTO professor (id, nome) VALUES(4,'Aline Mysna');
INSERT INTO professor (id, nome) VALUES(5,'Amanda Miller');
INSERT INTO professor (id, nome) VALUES(6,'Junior Oliveira');
INSERT INTO professor (id, nome) VALUES(7,'Ian Lucas');
INSERT INTO professor (id, nome) VALUES(8,'David Emanuell');
INSERT INTO professor (id, nome) VALUES(9,'Cícero Aureliano');
INSERT INTO professor (id, nome) VALUES(10,'Maria Ambrosina');
INSERT INTO professor (id, nome) VALUES(11,'Francisco Alves');
INSERT INTO professor (id, nome) VALUES(12,'Maria José');

-- DISCIPLINA
INSERT INTO disciplina (id, nome) VALUES(1,'Português');
INSERT INTO disciplina (id, nome) VALUES(2,'Matemática');
INSERT INTO disciplina (id, nome) VALUES(3,'Biologia');
INSERT INTO disciplina (id, nome) VALUES(4,'Química');
INSERT INTO disciplina (id, nome) VALUES(5,'História');
INSERT INTO disciplina (id, nome) VALUES(6,'Geografia');
INSERT INTO disciplina (id, nome) VALUES(7,'Inglês');
INSERT INTO disciplina (id, nome) VALUES(8,'Espanhol');
INSERT INTO disciplina (id, nome) VALUES(9,'Geometria');
INSERT INTO disciplina (id, nome) VALUES(10,'Filosofia');
INSERT INTO disciplina (id, nome) VALUES(11,'Física');
INSERT INTO disciplina (id, nome) VALUES(12,'Educação Física');

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
INSERT INTO aluno (id, nome) VALUES (1,'Adélia Querino');
INSERT INTO aluno (id, nome) VALUES (2,'Aldo Delgado');
INSERT INTO aluno (id, nome) VALUES (3,'Anind Felipe');
INSERT INTO aluno (id, nome) VALUES (4,'Anita Mascarenhas');
INSERT INTO aluno (id, nome) VALUES (5,'Antônio Veríssimo');
INSERT INTO aluno (id, nome) VALUES (6,'Belmira Trindade');
INSERT INTO aluno (id, nome) VALUES (7,'Benedito Nóbrega');
INSERT INTO aluno (id, nome) VALUES (8,'Bukake Severo');
INSERT INTO aluno (id, nome) VALUES (9,'Carmem Paranaguá');
INSERT INTO aluno (id, nome) VALUES (10,'Carmem Teves');
INSERT INTO aluno (id, nome) VALUES (11,'Catarina Castelo');
INSERT INTO aluno (id, nome) VALUES (12,'Cleusa Torquato');
INSERT INTO aluno (id, nome) VALUES (13,'Clóvis Cortés');
INSERT INTO aluno (id, nome) VALUES (14,'David Grande');
INSERT INTO aluno (id, nome) VALUES (15,'Davide Batata');
INSERT INTO aluno (id, nome) VALUES (16,'Elia Simão');
INSERT INTO aluno (id, nome) VALUES (17,'Elias Robalo');
INSERT INTO aluno (id, nome) VALUES (18,'Emílio Bandeira');
INSERT INTO aluno (id, nome) VALUES (19,'Estefânia Gravato');
INSERT INTO aluno (id, nome) VALUES (20,'Eudes Viégas');
INSERT INTO aluno (id, nome) VALUES (21,'Eunice Assis');
INSERT INTO aluno (id, nome) VALUES (22,'Fabiana Muniz');
INSERT INTO aluno (id, nome) VALUES (23,'Gregório Imbassaí');
INSERT INTO aluno (id, nome) VALUES (24,'Gregório Siqueira');
INSERT INTO aluno (id, nome) VALUES (25,'Honório Brito');
INSERT INTO aluno (id, nome) VALUES (26,'Hélio Vila-Chã');
INSERT INTO aluno (id, nome) VALUES (27,'Ilma Mortágua');
INSERT INTO aluno (id, nome) VALUES (28,'Inês Caires');
INSERT INTO aluno (id, nome) VALUES (29,'Isaura Viera');
INSERT INTO aluno (id, nome) VALUES (30,'Manuela Lopes');
INSERT INTO aluno (id, nome) VALUES (31,'Maíra Vilhena');
INSERT INTO aluno (id, nome) VALUES (32,'Natividade Quental');
INSERT INTO aluno (id, nome) VALUES (33,'NoêmiaCarrasqueira');
INSERT INTO aluno (id, nome) VALUES (34,'Paulina Peseiro');
INSERT INTO aluno (id, nome) VALUES (35,'Paulino Varanda');
INSERT INTO aluno (id, nome) VALUES (36,'Paulino Vianna');
INSERT INTO aluno (id, nome) VALUES (37,'Quitéria Hierro');
INSERT INTO aluno (id, nome) VALUES (38,'Rogério Camelo');
INSERT INTO aluno (id, nome) VALUES (39,'Ronaldo Alves');
INSERT INTO aluno (id, nome) VALUES (40,'Ruca Novalles');
INSERT INTO aluno (id, nome) VALUES (41,'Rudi Estrela');
INSERT INTO aluno (id, nome) VALUES (42,'Rúben Cerveira');
INSERT INTO aluno (id, nome) VALUES (43,'SidônioLeal');
INSERT INTO aluno (id, nome) VALUES (44,'Soeiro Gouveia');
INSERT INTO aluno (id, nome) VALUES (45,'Tainá Soares');
INSERT INTO aluno (id, nome) VALUES (46,'Urânia Gracia');
INSERT INTO aluno (id, nome) VALUES (47,'Valéria Parracho');
INSERT INTO aluno (id, nome) VALUES (48,'Vanda Valle');
INSERT INTO aluno (id, nome) VALUES (49,'Violeta Lira');
INSERT INTO aluno (id, nome) VALUES (50,'Zuleide Seabra');

-- RELAÇÃO TURMA-ALUNO
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 1)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 2)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 3)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 4)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 5)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 6)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 7)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 8)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 9)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (1, 10)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 11)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 12)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 13)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 14)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 15)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 16)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 17)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 18)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 19)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (2, 20)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 21)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 22)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 23)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 24)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 25)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 26)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 27)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 28)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 29)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (3, 30)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 31)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 32)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 33)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 34)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 35)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 36)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 37)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 38)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 39)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (4, 40)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 41)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 42)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 43)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 44)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 45)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 46)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 47)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 48)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 49)
INSERT INTO turma_aluno(turma_id, aluno_id) VALUES (5, 50)

-- PROVA
INSERT INTO prova (id, titulo, observacao) VALUES (1, 'Prova de matemática', 'Observações da prova...');
INSERT INTO questao_prova (id, enunciado, prova_id) VALUES (1, 'Quanto é 1 + 1?', 1);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (1, '1', 0, 1);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (2, '2', 1, 1);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (3, '3', 0, 1);

-- -- QUESTÃO-PROVA
INSERT INTO questao_prova (id, enunciado, prova_id) VALUES (2, 'Quanto é 2 + 2?', 1);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (4, '4', 1, 2);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (5, '2', 0, 2);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (6, '3', 0, 2);

-- -- ALTERNATIVA-QUESTÃO
INSERT INTO questao_prova (id, enunciado, prova_id) VALUES (3, 'Quanto é 3 + 3?', 1);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (7, '1', 0, 3);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (8, '2', 0, 3);
INSERT INTO alternativa_prova (id, descricao, resposta, questao_prova_id) VALUES (9, '6', 1, 3);

-- GABARITO
INSERT INTO gabarito (id, titulo, observacao) VALUES (1, 'Gabarito da prova de matemática', 'Observações dogabarito...');
INSERT INTO questao_gabarito (id, enunciado, gabarito_id) VALUES (1, 'Questão 1', 1);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (1, 'A', 0, 1);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (2, 'B', 1, 1);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (3, 'C', 0, 1);

-- -- QUESTÃO-GABARITO
INSERT INTO questao_gabarito (id, enunciado, gabarito_id) VALUES (2, 'Questão 2', 1);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (4, 'A', 1, 2);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (5, 'B', 0, 2);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (6, 'C', 0, 2);

-- -- ALTERNATIVA-GABARITO
INSERT INTO questao_gabarito (id, enunciado, gabarito_id) VALUES (3, 'Questão 3', 1);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (7, 'A', 0, 3);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (8, 'B', 0, 3);
INSERT INTO alternativa_gabarito (id, descricao, resposta, questao_gabarito_id) VALUES (9, 'C', 1, 3);


