CREATE TYPE category AS ENUM ('BREAD', 'CODE', 'DRAG');

CREATE TABLE questionnaires
(
    id   integer PRIMARY KEY,
    name varchar NOT NULL
);

CREATE TABLE sections
(
    id               integer PRIMARY KEY,
    questionnaire_id integer REFERENCES questionnaires (id) ON DELETE CASCADE,
    title            varchar NOT NULL
);

CREATE TABLE questions
(
    id          integer PRIMARY KEY,
    section_id  integer REFERENCES sections (id) ON DELETE CASCADE,
    category    category NOT NULL,
    label       text     NOT NULL,
    answer      text,
    reviewed_by varchar
);