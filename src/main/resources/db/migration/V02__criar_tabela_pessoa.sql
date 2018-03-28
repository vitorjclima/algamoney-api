CREATE TABLE pessoa(
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  ativo BOOLEAN NOT NULL,
  logradouro VARCHAR(30),
  numero INTEGER,
  complemento VARCHAR(30),
  bairro VARCHAR(30),
  cidade VARCHAR(30),
  estado VARCHAR(30),
  cep VARCHAR(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cidade, estado, cep)
values ('Joao', true, 'Rua Kiyoshi', 10, 'Apto 1', 'Centro', 'Sao Paulo', 'SP', '12345000');
INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cidade, estado, cep)
values ('Maria', false, 'Rua Enomoto', 20, 'Apto 2', 'Centro', 'Sao Paulo', 'SP', '12345000');