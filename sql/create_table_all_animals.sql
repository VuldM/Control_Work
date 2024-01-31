USE human_friends;

CREATE TABLE all_animals SELECT type_id,
    name,
    birthday,
    commands,
    'prev_table - dogs' AS prev_table FROM
    dogs 
UNION SELECT 
    type_id,
    name,
    birthday,
    commands,
    'prev_table - cats' AS prev_table
FROM
    cats 
UNION SELECT 
    type_id,
    name,
    birthday,
    commands,
    'prev_table - hamsters' AS prev_table
FROM
    hamsters 
UNION SELECT 
    type_id,
    name,
    birthday,
    commands,
    'prev_table - horses_donkeys' AS prev_table
FROM
    horses_donkeys;
    
ALTER TABLE all_animals ADD COLUMN id SERIAL PRIMARY KEY;


-- DROP TABLE all_animals;