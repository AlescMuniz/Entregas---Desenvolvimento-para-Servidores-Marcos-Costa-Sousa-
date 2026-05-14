-- CRIAÇÃO DO BANCO DE DADOS BD_LOGIN
CREATE DATABASE IF NOT EXISTS bd_login;

-- SELECIONANDO O BANCO DE DADOS
USE bd_login;

-- CRIANDO A TABELA DE LOGIN
CREATE TABLE IF NOT EXISTS usuario (
    usuario VARCHAR(10) PRIMARY KEY,
    nome    VARCHAR(30) DEFAULT '',
    senha   CHAR(32)    DEFAULT ''
);

-- INSERINDO UM USUÁRIO DE TESTE (senha: batatinha)
INSERT INTO usuario (usuario, nome, senha)
VALUES ('marcao', 'Marcos Costa', MD5('batatinha'));
