
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean NOT NULL,
    PRIMARY KEY (username)
);

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities(
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,
    CONSTRAINT authorities_idx UNIQUE (username, authority),
    CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username)
    REFERENCES users (username)
);

DROP TABLE IF EXISTS another_words;
CREATE TABLE another_words (
	another_word_id serial,
    another_word VARCHAR(100) NOT NULL,
    PRIMARY KEY(another_word_id)
);

DROP TABLE IF EXISTS translater_words;
CREATE TABLE translater_words (
	translater_word_id serial,
    translater_word VARCHAR(100) NOT NULL,
    PRIMARY KEY(translater_word_id)
);

DROP TABLE IF EXISTS translater_rules;
CREATE TABLE translater_rules (
	rules_id serial,
	users VARCHAR(50) NOT NULL,
    translater_title VARCHAR(100) NOT NULL,
    translater_rule VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(rules_id),

    CONSTRAINT FK_TR_US FOREIGN KEY (users)
    REFERENCES users (username)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS translater;
CREATE TABLE translater (
    translater_id serial,
	another_word_id integer NOT NULL,
	rule integer NOT NULL,
    translater_word_id integer NOT NULL,
    PRIMARY KEY (translater_id),

    CONSTRAINT FK_T_AW FOREIGN KEY (another_word_id)
    REFERENCES another_words (another_word_id)
    ON DELETE CASCADE ON UPDATE NO ACTION,

    CONSTRAINT FK_T_TW FOREIGN KEY (translater_word_id)
    REFERENCES translater_words (translater_word_id)
    ON DELETE CASCADE ON UPDATE NO ACTION,

    CONSTRAINT FK_R_R FOREIGN KEY (rule)
    REFERENCES translater_rules (rules_id)
    ON DELETE CASCADE ON UPDATE NO ACTION
);
