drop table IF EXISTS names;

create TABLE names (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL,
 PRIMARY KEY(id)
);


insert into names (name) values ("masanori");
insert into names (name) values ("takashi");
insert into names (name) values ("nishimura");
insert into names (name) values ("kotouge");
insert into names (name) values ("zakoshisyoh");
