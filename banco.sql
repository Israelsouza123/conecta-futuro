CREATE DATABASE IF NOT EXISTS freeladaquebrada;
USE freeladaquebrada;
CREATE TABLE prestador (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(120) NOT NULL,
  telefone VARCHAR(30) NOT NULL,
  bairro VARCHAR(80) NOT NULL,
  especialidade VARCHAR(80) NOT NULL
);
CREATE TABLE servico (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(120) NOT NULL,
  descricao TEXT,
  preco DECIMAL(10,2) NOT NULL,
  prestador_id BIGINT NOT NULL,
  FOREIGN KEY (prestador_id) REFERENCES prestador(id) ON DELETE CASCADE
);
CREATE TABLE avaliacao (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  cliente VARCHAR(120) NOT NULL,
  nota INT NOT NULL CHECK (nota BETWEEN 1 AND 5),
  comentario TEXT,
  servico_id BIGINT NOT NULL,
  FOREIGN KEY (servico_id) REFERENCES servico(id) ON DELETE CASCADE
);
INSERT INTO prestador (nome, telefone, bairro, especialidade) VALUES
 ('Dona Cida Costuras','(11) 98888-1111','Capão Redondo','Costura'),
 ('Jeferson Elétrica','(11) 97777-2222','Cidade Tiradentes','Eletricista');
INSERT INTO servico (titulo, descricao, preco, prestador_id) VALUES
 ('Ajuste de roupas','Barra, cintura e reparos',25.00,1),
 ('Instalação de chuveiro','Com material do cliente',80.00,2);
INSERT INTO avaliacao (cliente, nota, comentario, servico_id) VALUES ('Marta',5,'Trabalho caprichado!',1);
