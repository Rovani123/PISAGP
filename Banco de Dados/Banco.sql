
-- MySQL Script generated by MySQL Workbench
-- Tue May  7 07:36:10 2024
-- Version: 1.0

DROP DATABASE IF EXISTS BSAGP;
CREATE DATABASE IF NOT EXISTS BSAGP;

USE BSAGP;

CREATE TABLE IF NOT EXISTS Produtos 
(
    idProduto INT NOT NULL AUTO_INCREMENT,
    nomeProduto VARCHAR(20) NOT NULL,
    preco DECIMAL(4,2) NOT NULL,
    quantidadeEstoque INT NOT NULL,
    categoria VARCHAR(12) NOT NULL,
    PRIMARY KEY (idProduto)
);

CREATE TABLE IF NOT EXISTS Promocoes 
(
    idPromocao INT NOT NULL AUTO_INCREMENT,
    desconto DECIMAL(4,2) NOT NULL,
    dataInicio DATE NOT NULL,
    dataTermino DATE NOT NULL,
    PRIMARY KEY (idPromocao)
);

CREATE TABLE IF NOT EXISTS Funcionarios 
(
    idFuncionario INT NOT NULL AUTO_INCREMENT,
    nomeFuncionario VARCHAR(45) NOT NULL,
    usuarioFuncionario VARCHAR(45) NOT NULL,
    senha VARCHAR(16) NOT NULL,
    administrador BOOLEAN NOT NULL, 
    PRIMARY KEY (idFuncionario)
);

CREATE TABLE IF NOT EXISTS Clientes 
(
    idCliente INT NOT NULL AUTO_INCREMENT,
    nomeCliente VARCHAR(45) NOT NULL,
    cpfCliente BIGINT NOT NULL,
    PRIMARY KEY (idCliente)
);


CREATE TABLE IF NOT EXISTS Vendas 
(
    idVenda INT NOT NULL AUTO_INCREMENT,
    idFuncionario INT,
    idCliente INT NULL,
    metodoPagamento VARCHAR(10) NOT NULL,
    PRIMARY KEY (idVenda),
    FOREIGN KEY (idFuncionario) REFERENCES Funcionarios (idFuncionario),
    FOREIGN KEY (idCliente) REFERENCES Clientes (idCliente)
);

CREATE TABLE IF NOT EXISTS Carrinho 
(
    idCarrinho INT NOT NULL AUTO_INCREMENT,
    idProduto INT NOT NULL,
    idVenda INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (idCarrinho),
    FOREIGN KEY (idProduto) REFERENCES Produtos (idProduto),
    FOREIGN KEY (idVenda) REFERENCES Vendas (idVenda)
);

CREATE TABLE IF NOT EXISTS ProdutosPromocao 
(
    idProdutosPromocao INT NOT NULL AUTO_INCREMENT,
    idProduto INT NOT NULL,
    idPromocao INT NOT NULL,
    PRIMARY KEY (idProdutosPromocao),
    FOREIGN KEY (idProduto) REFERENCES Produtos (idProduto),
    FOREIGN KEY (idPromocao) REFERENCES Promocoes (idPromocao)
);
