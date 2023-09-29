create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(250) not null unique,
    autor varchar(100) not null,
    curso varchar(100) not null,
    data_criacao timestamp not null,
    status varchar(50) default 'Aberto' not null,
    primary key(id)
);