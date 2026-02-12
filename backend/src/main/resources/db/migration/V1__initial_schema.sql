CREATE SEQUENCE ingredient_seq START WITH 1 INCREMENT BY 50;

-- Tables
CREATE TABLE ingredient (
    created_at TIMESTAMP(6),
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    price BIGINT,
    calories BIGINT,
    name VARCHAR(255),
    notes TEXT
);
