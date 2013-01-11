# Users schema
 
# --- !Ups
 
CREATE TABLE AULA (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    NOME varchar(255) NOT NULL,
    DESCRICAO varchar(255) NOT NULL,
    ID_SALA bigint(20) NOT NULL,
    NUMERO INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_SALA) REFERENCES SALA(ID)
);

CREATE TABLE SALA (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    NOME varchar(255) NOT NULL,
    DISCIPLINA varchar(255),
    DESCRICAO varchar(255),
    ESCOLA varchar(255),
    ID_PROFESSOR bigint(20) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_PROFESSOR) REFERENCES PROFESSOR(ID)
);


CREATE TABLE PROFESSOR (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    NOME varchar(255) NOT NULL,
    TELEFONE varchar(255),
    DESCRICAO varchar(1000),
    EMAIL varchar(255),
    SENHA varchar(255),
    PRIMARY KEY (ID)
);

 
# --- !Downs
 
DROP TABLE AULA;

DROP TABLE SALA;

DROP TABLE PROFESSOR;