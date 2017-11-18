-- Tipos de Servico
insert into tbl_ref_tp_servico (nome, valor, descricao)  
values 	('Tipo de Serviço 01', 5, 'Observação para o tipos de serviço 01'),
		('Tipo de Serviço 02', 5, 'Observação para o tipos de serviço 02'),
		('Tipo de Serviço 03', 5, 'Observação para o tipos de serviço 03'),
		('Tipo de Serviço 04', 5, 'Observação para o tipos de serviço 04'),
		('Tipo de Serviço 05', 5, 'Observação para o tipos de serviço 05'),
		('Tipo de Serviço 06', 5, 'Observação para o tipos de serviço 06'),
		('Tipo de Serviço 07', 5, 'Observação para o tipos de serviço 07'),
		('Tipo de Serviço 08', 5, 'Observação para o tipos de serviço 08'),
		('Tipo de Serviço 09', 5, 'Observação para o tipos de serviço 09'),
		('Tipo de Serviço 10', 5, 'Observação para o tipos de serviço 10'),
		('Tipo de Serviço 11', 5, 'Observação para o tipos de serviço 11'),
		('Tipo de Serviço 12', 5, 'Observação para o tipos de serviço 12'),
		('Tipo de Serviço 13', 5, 'Observação para o tipos de serviço 013'),
		('Tipo de Serviço 14', 5, 'Observação para o tipos de serviço 014'),
		('Tipo de Serviço 15', 5, 'Observação para o tipos de serviço 015'),
		('Tipo de Serviço 16', 5, 'Observação para o tipos de serviço 016')
;

-- Utilizadores
INSERT INTO tbl_utilizador (id, nome, email, senha) values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO tbl_utilizador (id, nome, email, senha) values (2, 'Maria Silva', 'maria@algamoney.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO tbl_permissao (id, descricao) values (1, 'ROLE_CADASTRAR_TIPO_DE_SERVICO');
INSERT INTO tbl_permissao (id, descricao) values (2, 'ROLE_PESQUISAR_TIPO_DE_SERVICO');
INSERT INTO tbl_permissao (id, descricao) values (3, 'ROLE_EXCLUIR_TIPO_DE_SERVICO');

-- Permissões admin
INSERT INTO tbl_utilizador_permissao (id_utilizador, id_permissao) values (1, 1);
INSERT INTO tbl_utilizador_permissao (id_utilizador, id_permissao) values (1, 2);
INSERT INTO tbl_utilizador_permissao (id_utilizador, id_permissao) values (1, 3);

-- Permissões maria
INSERT INTO tbl_utilizador_permissao (id_utilizador, id_permissao) values (2, 2);
