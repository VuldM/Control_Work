USE human_friends;

CREATE TABLE young_animals SELECT * FROM
    (SELECT 
        type_id, name, birthday, commands
    FROM
        hamsters UNION SELECT 
        type_id, name, birthday, commands
    FROM
        dogs UNION SELECT 
        type_id, name, birthday, commands
    FROM
        cats UNION SELECT 
        type_id, name, birthday, commands
    FROM
        horses_donkeys) AS choice
WHERE
    choice.birthday BETWEEN NOW() - INTERVAL 3 YEAR AND NOW() - INTERVAL 1 YEAR;
    
ALTER TABLE young_animals
	ADD age TEXT;
    
UPDATE young_animals 
SET 
    age = CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()),
            ' years ',
            TIMESTAMPDIFF(MONTH,
                birthday,
                CURDATE()) % 12,
            ' month');
