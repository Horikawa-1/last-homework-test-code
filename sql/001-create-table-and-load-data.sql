DROP TABLE IF EXISTS names;

CREATE TABLE names (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL,
 PRIMARY KEY(id)
);


INSERT INTO names (name) VALUES ("masanori");
INSERT INTO names (name) VALUES ("takashi");
INSERT INTO names (name) VALUES ("nishimura");
INSERT INTO names (name) VALUES ("kotouge");
INSERT INTO names (name) VALUES ("zakoshisyoh");
