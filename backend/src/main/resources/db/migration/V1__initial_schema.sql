CREATE SEQUENCE ingredient_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE recipe_ingredient_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE recipe_seq START WITH 1 INCREMENT BY 50;

-- Tables
CREATE TABLE ingredient (
    created_at TIMESTAMP(6),
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    price BIGINT,
    calories BIGINT,
    name VARCHAR(255),
    notes TEXT
);

CREATE TABLE recipe (
    created_at TIMESTAMP(6),
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    instructions TEXT,
    name VARCHAR(255)
);

CREATE TABLE recipe_ingredient (
       id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
       amount BIGINT,
       ingredient_id BIGINT,
       recipe_id BIGINT NOT NULL
);

-- Foreign Keys
ALTER TABLE recipe_ingredient
    ADD CONSTRAINT fk_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(id),
    ADD CONSTRAINT fk_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(id);
