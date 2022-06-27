

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
	id serial,
	name VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);


DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles (
	rule_id integer NOT NULL,
	user_id integer NOT NULL,

    PRIMARY KEY(rule_id, user_id),

    CONSTRAINT FK_UR_U FOREIGN KEY (user_id)
    REFERENCES users (username)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT FK_UR_R FOREIGN KEY (rule_id)
    REFERENCES roles (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO roles (name)
VALUES
    ('ADMIN'),
    ('USER');





