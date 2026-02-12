-- Optional: TRUNCATE for clean slate
TRUNCATE TABLE ingredient RESTART IDENTITY CASCADE;

-- Insert ingredients without fixed IDs
INSERT INTO ingredient (name, price, calories, created_at, notes) VALUES
    ('Haferflocken', 170, 370, '2025-04-08 21:11:16.680558', NULL),
    ('Bananen', 229, 89, '2025-04-08 21:14:10.109388', NULL),
    ('TK Beerenmischung', 990, 50, '2025-04-08 21:19:24.731278', NULL),
    ('Hafermilch', 30, 45, '2025-04-08 21:17:07.555021', 'Selbstgemacht - Preis anhand Haferflocken'),
    ('Erdnussbutter', 675, 588, '2025-04-08 21:13:38.193864', 'Selbstgemacht - Preis anhand Erdnüsse'),
    ('Dymatize Elite 100% Whey Protein', 2576, 380, '2025-04-08 21:26:45.259077', NULL),
    ('TK Ananaswürfel', 1090, 50, '2025-04-08 22:05:25.275693', NULL),
    ('TK Avocadospalten', 1490, 160, '2025-04-08 22:05:25.275693', NULL),
    ('Ingwer', 1660, 80, '2025-04-08 22:05:25.275693', NULL),
    ('Gurke', 170, 15, '2025-04-08 22:05:25.275693', NULL),
    ('Zitronensaft', 290, 22, '2025-04-08 22:05:25.275693', NULL),
    ('Chia Samen', 795, 486, '2025-04-08 22:05:25.275693', NULL),
    ('Kiwi', 379, 61, '2025-04-08 22:05:25.275693', NULL),
    ('Blattspinat', 598, 23, '2025-04-08 22:05:25.275693', NULL),
    ('Wasser', 15, 0, '2025-04-08 22:08:29.070508', NULL),
    ('Quinoa', 798, 368, '2025-04-08 22:14:47.151273', NULL),
    ('Brokkoli', 358, 34, '2025-04-08 22:17:14.157132', NULL),
    ('Tofu', 190, 120, '2025-04-08 22:36:47.979674', NULL),
    ('Karotten', 140, 41, '2025-04-08 22:36:47.979674', NULL),
    ('Knoblauch', 279, 149, '2025-04-08 22:36:47.979674', NULL),
    ('Curry Pulver', 6980, 325, '2025-04-08 22:36:47.979674', NULL),
    ('Soja Sauce', 1527, 60, '2025-04-08 22:36:47.979674', NULL);
