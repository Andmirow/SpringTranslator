
INSERT INTO users
VALUES
('admin', '{noop}admin', true),
('user', '{noop}123', true);


INSERT INTO authorities
VALUES
    ('admin', 'ROLE_ADMIN'),
    ('admin', 'ROLE_USER'),
    ('user', 'ROLE_USER');


INSERT INTO another_words (another_word)
VALUES  ('tree'),
        ('true'),
        ('11083'),
        ('12457');

INSERT INTO translater_words (translater_word)
VALUES  ('дерево'),
        ('правда'),
        ('истина');

INSERT INTO translater_rules (users, translater_title, translater_rule)
VALUES  ('user','numerical transleter','\d{5}'),
        ('admin','numerical transleter','\d{5}'),
        ('admin','english transleter','\D{4}'),
        ('admin','russian transleter',NULL);


INSERT INTO translater (rule,another_word_id, translater_word_id)
VALUES  (1,1,1),
        (1,2,2),
        (1,2,3),
        (2,2,3);

