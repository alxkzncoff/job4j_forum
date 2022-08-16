CREATE TABLE IF NOT EXISTS messages(
    id SERIAL PRIMARY KEY,
    msg TEXT
);

CREATE TABLE IF NOT EXISTS posts(
    id SERIAL PRIMARY KEY,
    name VARCHAR(1000),
    description TEXT,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now()
);

INSERT INTO posts(name, description) VALUES ('О чем форум.', 'Описание форума');
INSERT INTO posts(name, description) VALUES ('Правила форума.', 'Свод правил форума.');
INSERT INTO posts(name, description) VALUES ('Беседка.', 'Свободное общение.');