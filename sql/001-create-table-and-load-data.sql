drop table IF EXISTS names;

create TABLE names (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL,
 PRIMARY KEY(id)
);


insert into names (name) values ("本間");
insert into names (name) values ("中嶋");
insert into names (name) values ("伊藤");
