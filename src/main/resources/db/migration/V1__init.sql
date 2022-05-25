DROP TABLE IF EXISTS english_words;
CREATE TABLE english_words (
	english_id serial,
    english_word VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(english_id)
);

DROP TABLE IF EXISTS russian_words;
CREATE TABLE russian_words (
	russian_id serial,
    russian_word VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(russian_id)
);

DROP TABLE IF EXISTS numeric_words;
CREATE TABLE numeric_words (
	numeric_id serial,
    numeric_word VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(numeric_id)
);


DROP TABLE IF EXISTS english_transtator;
CREATE TABLE english_transtator (
    english_transtator_id serial,
	english_id integer NOT NULL,
    russian_id integer NOT NULL,
    PRIMARY KEY (english_transtator_id),

    CONSTRAINT FK_ET_ENG FOREIGN KEY (english_id)
    REFERENCES english_words (english_id)
    ON DELETE CASCADE ON UPDATE NO ACTION,

    CONSTRAINT FK_ET_RUS FOREIGN KEY (russian_id)
    REFERENCES russian_words (russian_id)
    ON DELETE CASCADE ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS numeric_transtator;
CREATE TABLE numeric_transtator (
    numeric_transtator_id serial,
	english_id integer NOT NULL,
    numeric_id integer NOT NULL,
    PRIMARY KEY (numeric_transtator_id),

    CONSTRAINT FK_NT_ENG FOREIGN KEY (english_id)
    REFERENCES english_words (english_id)
    ON DELETE CASCADE ON UPDATE NO ACTION,

    CONSTRAINT FK_NT_RUS FOREIGN KEY (numeric_id)
    REFERENCES numeric_words (numeric_id)
    ON DELETE CASCADE ON UPDATE NO ACTION
);