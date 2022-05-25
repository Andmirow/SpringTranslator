INSERT INTO english_words (english_word)
VALUES  ('tree'),
        ('true');


INSERT INTO russian_words (russian_word)
VALUES  ('дерево'),
        ('правда'),
        ('истина');


INSERT INTO numeric_words (numeric_word)
VALUES  ('11083'),
        ('12457');


INSERT INTO english_transtator (english_id, russian_id)
VALUES  (1,1),
        (2, 2),
        (2,3);


INSERT INTO numeric_transtator (english_id, numeric_id)
VALUES  (1, 1),
        (2, 2);


INSERT INTO flywaydb.english_transtator(english_id, russian_id)
VALUES  (
	(SELECT english_id FROM flywaydb.english_words
		WHERE english_word = 'bush'),
	(SELECT russian_id FROM flywaydb.russian_words
	WHERE russian_word = 'куст'));