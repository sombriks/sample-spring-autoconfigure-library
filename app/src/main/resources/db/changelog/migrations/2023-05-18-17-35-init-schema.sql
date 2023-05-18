--liquibase formatted sql
--changeset sombriks:id

create table todos (
    id integer not null primary key auto_increment,
    description varchar(255) not null
);

-- rollback drop table todos;
