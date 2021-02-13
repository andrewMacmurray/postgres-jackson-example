INSERT INTO questionnaires (id, name)
VALUES (1, 'Bread Questionnaire'),
       (2, 'Code Questionnaire');

INSERT INTO sections (id, questionnaire_id, title)
VALUES (1, 1, 'Section 1'),
       (2, 1, 'Section 2'),
       (3, 1, 'Section 3'),
       (4, 2, 'Section 1'),
       (5, 2, 'Section 2');

INSERT INTO questions (id, section_id, category, label, answer, reviewed_by)
VALUES (1, 1, 'BREAD', 'Do you love bread?', 'Absolutely', 'Paul Hollywood'),
       (2, 1, 'BREAD', 'Do you love baguettes', 'YES!', NULL),
       (3, 2, 'BREAD', 'Do you love rolls?', NULL, NULL),
       (4, 3, 'BREAD', 'Do you love bakeries?', 'Who doesnt!', 'Mary Bary'),
       (5, 4, 'CODE', 'What is your favourite programming language?', 'Perl...lol jk', NULL),
       (6, 5, 'DRAG', 'Favourite drag queens?', 'Trixie and Katya', 'Alyssa Edwards');
