CREATE TABLE team (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO team (name) VALUES ('Sao paulo');
INSERT INTO team (name) VALUES ('Guarani');
INSERT INTO team (name) VALUES ('Bayer');
INSERT INTO team (name) VALUES ('Barcelona');
INSERT INTO team (name) VALUES ('Santos');