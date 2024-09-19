CREATE TABLE IF NOT EXISTS users (
    id bigint auto_increment,
    nome varchar(255),
    email varchar(255),
    senha varchar(255),
    avatar VARCHAR(255),
    primary key (id)
);