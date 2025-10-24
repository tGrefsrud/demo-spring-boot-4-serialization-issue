CREATE TABLE draft (
                       id BIGSERIAL PRIMARY KEY,
                       data JSONB NOT NULL
);

INSERT INTO draft (data) VALUES ('{"message": "Hello World"}'::jsonb);