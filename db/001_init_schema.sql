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

CREATE TABLE IF NOT EXISTS posts_messages(
    post_id INT REFERENCES posts(id),
    message_id INT REFERENCES messages(id)
);