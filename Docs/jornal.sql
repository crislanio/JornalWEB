# Crislânio de Souza Macêdo
# Sugestão de sql JDBC
# SQL command to create the tables:
create database jornal;
create database journal;

use jornal;

select *from secao;
select *from usuario;

insert into usuario (login,senha,nome, email) values ('Airton','123', 'Airton','airton@gmail.com');
insert into usuario (login,senha,nome, email) values ('Crislanio','123', 'Crislanio','crislanio@gmail.com');
insert into usuario (login,senha,nome, email) values ('Naruto','123', 'Naruto','crislanio@gmail.com');


insert into secao (id,titulo,descricao) values (2,'esporte', 'secao de esporte');
insert into secao (id,titulo,descricao) values (10,'entretenimento', 'secao de entretenimento');

insert into role (login, role) values ('Airton','jornalista');
insert into role (login, role) values ('Crislanio','editor');
insert into role (login, role) values ('Naruto','editor');
insert into role (login, role) values ('Pedro','editor');



select *from role;

CREATE TABLE usuario (
      login VARCHAR(20) NOT NULL,
      senha VARCHAR(20) NOT NULL,
      nome VARCHAR(50) NOT NULL,
      email VARCHAR(50) NOT NULL,
PRIMARY KEY(login));

CREATE TABLE role (
      login VARCHAR(20) NOT NULL,
      role VARCHAR(20) NOT NULL,
PRIMARY KEY(login,role),
FOREIGN KEY (login) REFERENCES usuario(login)
                     ON DELETE CASCADE);

CREATE TABLE secao (
      id BIGINT AUTO_INCREMENT NOT NULL,
      titulo VARCHAR(20) NOT NULL,
      descricao VARCHAR(100) NOT NULL,
PRIMARY KEY(id));

CREATE TABLE noticia (
      id BIGINT AUTO_INCREMENT NOT NULL,
      titulo VARCHAR(50) NOT NULL,
      subtitulo VARCHAR(150) NOT NULL,
      texto VARCHAR(500) NOT NULL,
      autor VARCHAR(20) NOT NULL,
      data_noticia TIMESTAMP NOT NULL,
      id_secao BIGINT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (autor) REFERENCES usuario(login)
                     ON DELETE CASCADE,
FOREIGN KEY (id_secao) REFERENCES secao(id)
                     ON DELETE CASCADE);

CREATE TABLE cometario (
      id BIGINT AUTO_INCREMENT NOT NULL,
      noticia BIGINT NOT NULL,
      autor VARCHAR(20) NOT NULL,
      texto VARCHAR(100) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (autor) REFERENCES usuario(login)
                     ON DELETE CASCADE,
FOREIGN KEY (noticia) REFERENCES noticia(id)
                     ON DELETE CASCADE);

CREATE TABLE classificado (
      id BIGINT AUTO_INCREMENT NOT NULL,
      titulo VARCHAR(50) NOT NULL,
      texto VARCHAR(250) NOT NULL,
      preco FLOAT NOT NULL,
      telefone VARCHAR(20) NOT NULL,
      melhor_oferta FLOAT,
      data_oferta TIMESTAMP,
      autor_oferta VARCHAR(20),
 PRIMARY KEY(id),
 FOREIGN KEY (autor_oferta) REFERENCES usuario(login)
                     ON DELETE SET NULL);
