INSERT INTO recipe (name, instructions, created_at) VALUES
    ('High Cal Breakfast Smoothie', 'Alles rein einfach und mixen. Schnell trinken sonst werden die Oats hart und es wird schwierig zu trinken.', '2025-04-08 21:30:32.314184'),
    ('Green Smoothie', 'Alles einfach reinhauen und mixen', '2025-04-08 22:07:41.749522'),
    ('Quinoa Bowl', '1. Tofu würfeln und mit Currypulver, Salz und Zucker marinieren. Brokkoli in Röschen schneiden. ...', '2025-04-08 22:18:13.178265');

-- High Cal Breakfast Smoothie
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 100 FROM recipe r, ingredient i WHERE r.name = 'High Cal Breakfast Smoothie' AND i.name = 'Haferflocken';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 20 FROM recipe r, ingredient i WHERE r.name = 'High Cal Breakfast Smoothie' AND i.name = 'Bananen';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 50 FROM recipe r, ingredient i WHERE r.name = 'High Cal Breakfast Smoothie' AND i.name = 'TK Beerenmischung';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 30 FROM recipe r, ingredient i WHERE r.name = 'High Cal Breakfast Smoothie' AND i.name = 'Dymatize Elite 100% Whey Protein';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 50 FROM recipe r, ingredient i WHERE r.name = 'High Cal Breakfast Smoothie' AND i.name = 'Erdnussbutter';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 300 FROM recipe r, ingredient i WHERE r.name = 'High Cal Breakfast Smoothie' AND i.name = 'Hafermilch';

-- Quinoa Bowl
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 200 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Tofu';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 80 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Quinoa';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 250 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Brokkoli';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 200 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Karotten';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 10 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Ingwer';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 5 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Knoblauch';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 40 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Curry Pulver';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 15 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Soja Sauce';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 50 FROM recipe r, ingredient i WHERE r.name = 'Quinoa Bowl' AND i.name = 'Wasser';

-- Green Smoothie
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 15 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'Blattspinat';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 25 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'Gurke';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 35 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'Kiwi';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 40 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'TK Ananaswürfel';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 15 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'TK Avocadospalten';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 3 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'Ingwer';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 8 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'Zitronensaft';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 3 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'Chia Samen';
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount)
SELECT r.id, i.id, 100 FROM recipe r, ingredient i WHERE r.name = 'Green Smoothie' AND i.name = 'Wasser';

