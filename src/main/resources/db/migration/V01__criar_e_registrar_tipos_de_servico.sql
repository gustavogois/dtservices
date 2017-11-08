CREATE TABLE tbl_tipo_de_servico (
	id 			BIGINT(20) 		PRIMARY KEY AUTO_INCREMENT,
	nome 		VARCHAR(60)		NOT NULL,
	valor		DOUBLE,
	descricao	VARCHAR(300)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tbl_tipo_de_servico (nome, valor, descricao) values ('Arrombamento de Porta - Fechadura simples', 10, 'Valor default por porta arrombada');
INSERT INTO tbl_tipo_de_servico (nome, valor, descricao) values ('Arrombamento de Porta - Fechadura complexa', 50, 'Valor default por porta arrombada');
INSERT INTO tbl_tipo_de_servico (nome, valor, descricao) values ('Pintura', 5, 'Valor por m2');
