USE human_friends;

DROP TABLE camels;

CREATE TABLE horses_donkeys
	SELECT type_id, name, birthday, commands
	FROM horses
	UNION
	SELECT type_id, name, birthday, commands
	FROM donkeys;

ALTER TABLE horses_donkeys
ADD COLUMN
	id SERIAL PRIMARY KEY;
    
DROP TABLE horses, donkeys;