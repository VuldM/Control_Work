-- DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;

USE human_friends;

CREATE TABLE `nursery` (
    `id` SERIAL PRIMARY KEY,
    `name` VARCHAR(60) NOT NULL
);

CREATE TABLE `animal_types` (
    `id` SERIAL PRIMARY KEY,
    `name` VARCHAR(60) NOT NULL,
    `nursery_id` BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (`nursery_id`)
        REFERENCES `nursery` (`id`)
);

CREATE TABLE `dogs` (
    `id` SERIAL PRIMARY KEY,
    `type_id` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `birthday` DATE NOT NULL,
    `commands` TEXT NOT NULL,
    FOREIGN KEY (`type_id`)
        REFERENCES `animal_types` (`id`)
);

CREATE TABLE `cats` (
    `id` SERIAL PRIMARY KEY,
    `type_id` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `birthday` DATE NOT NULL,
    `commands` TEXT NOT NULL,
    FOREIGN KEY (`type_id`)
        REFERENCES `animal_types` (`id`)
);

CREATE TABLE `hamsters` (
    `id` SERIAL PRIMARY KEY,
    `type_id` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `birthday` DATE NOT NULL,
    `commands` TEXT NOT NULL,
    FOREIGN KEY (`type_id`)
        REFERENCES `animal_types` (`id`)
);

CREATE TABLE `horses` (
    `id` SERIAL PRIMARY KEY,
    `type_id` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `birthday` DATE NOT NULL,
    `commands` TEXT NOT NULL,
    FOREIGN KEY (`type_id`)
        REFERENCES `animal_types` (`id`)
);

CREATE TABLE `camels` (
    `id` SERIAL PRIMARY KEY,
    `type_id` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `birthday` DATE NOT NULL,
    `commands` TEXT NOT NULL,
    FOREIGN KEY (`type_id`)
        REFERENCES `animal_types` (`id`)
);

CREATE TABLE `donkeys` (
    `id` SERIAL PRIMARY KEY,
    `type_id` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `birthday` DATE NOT NULL,
    `commands` TEXT NOT NULL,
    FOREIGN KEY (`type_id`)
        REFERENCES `animal_types` (`id`)
);

USE human_friends;
INSERT INTO `nursery`
	(name)
VALUES
	('pets_animals'),
	('pack_animals')
	;
    
INSERT INTO `animal_types`
	(name, nursery_id)
VALUES
	('dog', 1),
    ('cat', 1),
    ('hamster', 1),
    ('horse', 2),
    ('camel', 2),
	('donkey', 2)
	;
    
INSERT INTO `dogs`
	(type_id, name, birthday, commands)
VALUES
	(1, 'Бобик', '1988-08-11', 'give_me_paw, lie, sit'),
    (1, 'Чук', '1987-07-24', 'aport, voice, sit'),
    (1, 'Шарик', '2003-02-05', 'aport, give_me_paw'),
    (1, 'Гек', '1987-07-24', 'voice, lie, sit'),
	(1, 'Черныщ', '2017-06-12', 'aport, voice, lie')
	;
    
INSERT INTO `cats`
	(type_id, name, birthday, commands)
VALUES
	(2, 'Мурка', '1988-03-12', 'run, sleep, jump'),
    (2, 'Аша', '1989-12-20', 'run, sleep'),
    (2, 'Нюша', '1998-07-05', 'run, sleep'),
    (2, 'Пушистик', '2001-10-11', 'climb, sleep, jump'),
	(2, 'Муся', '2008-05-20', 'climb, sleep, jump')
	;
    
INSERT INTO `hamsters`
	(type_id, name, birthday, commands)
VALUES
	(3, 'Пушистик', '2020-08-05', 'wheelspin, stand'),
    (3, 'Кокос', '2021-03-15', 'wheelspin'),
    (3, 'Кнопка', '2021-08-07', 'wheelspin, stand'),
    (3, 'Боня', '2022-05-15', 'wheelspin'),
	(3, 'Винтик', '2021-03-25', 'wheelspin')
	;
    
INSERT INTO `horses`
	(type_id, name, birthday, commands)
VALUES
	(4, 'Рыжий', '1983-06-05', 'step, stand, trot, gallop'),
    (4, 'Восток', '1985-05-10', 'walk, stand, trot, gallop'),
    (4, 'Дон', '1984-12-11', 'greeting, stand, trot'),
    (4, 'Жалейка', '1986-01-15', 'walk, stand, trot, gallop'),
	(4, 'Чанчик', '1988-04-15', 'walk, stand, trot, gallop')
	;
    
INSERT INTO `camels`
	(type_id, name, birthday, commands)
VALUES
	(5, 'Лила', '2005-09-14', 'sit_down,  lie'),
    (5, 'Хлоя', '2010-09-15', 'sit_down, lie'),
    (5, 'Шпулька', '1997-10-01', 'sit_down, lie'),
    (5, 'Арлекин', '1999-06-23', 'sit_down, lie'),
	(5, 'Зембо', '2013-08-26', 'sit_down, lie')
	;
    
INSERT INTO `donkeys`
	(type_id, name, birthday, commands)
VALUES
	(6, 'Юрчик', '2021-07-29', 'stand, walk, lie'),
    (6, 'Рих', '2019-09-25', 'stand, walk, lie'),
    (6, 'Ролл', '2018-04-16', 'stand, walk, lie'),
    (6, 'Гектор', '2020-11-02', 'stand, walk, lie'),
	(6, 'Пикап', '2019-04-19', 'stand, walk, lie');



INSERT INTO `nursery`
	(name)
VALUES
	('pets'),
	('pack_animals')
	;
    
INSERT INTO `animal_types`
	(name, nursery_id)
VALUES
	('dog', 1),
    ('cat', 1),
    ('hamster', 1),
    ('horse', 2),
    ('camel', 2),
	('donkey', 2)
	;
    
INSERT INTO `dogs`
	(type_id, name, birthday, commands)
VALUES
	(1, 'Шарик', '2020-05-03', 'gav-gav, lie, sit'),
    (1, 'Бобик', '2018-06-23', 'aport, gav-gav, sit'),
    (1, 'Майло', '2021-10-15', 'aport, gav-gav'),
    (1, 'Ася', '2019-03-10', 'gav-gav, lie, sit'),
	(1, 'Ириска', '2018-09-08', 'aport, gav-gav, lie')
	;
    
INSERT INTO `cats`
	(type_id, name, birthday, commands)
VALUES
	(2, 'Мурзик', '2015-07-03', 'meow-meow, sleep, jump'),
    (2, 'Муся', '2019-05-22', 'meow-meow, sleep'),
    (2, 'Симба', '2018-11-17', 'meow-meow, sleep'),
    (2, 'Гарфилд', '2022-07-10', 'meow-meow, sleep, jump'),
	(2, 'Чубайс', '2020-09-05', 'meow-meow, sleep, jump')
	;
    
INSERT INTO `hamsters`
	(type_id, name, birthday, commands)
VALUES
	(3, 'Пушистик', '2020-08-05', 'wheelspin, stand'),
    (3, 'Кокос', '2021-03-15', 'wheelspin'),
    (3, 'Кнопка', '2021-08-07', 'wheelspin, stand'),
    (3, 'Боня', '2022-05-15', 'wheelspin'),
	(3, 'Винтик', '2021-03-25', 'wheelspin')
	;
    
INSERT INTO `horses`
	(type_id, name, birthday, commands)
VALUES
	(4, 'Богатырь', '2013-05-12', 'greeting, stand, walk, gallop'),
    (4, 'Ягодка', '2009-07-11', 'greeting, stand, walk, gallop'),
    (4, 'Глория', '2012-03-20', 'greeting, stand, walk'),
    (4, 'Винсент', '2011-04-04', 'greeting, stand, walk, gallop'),
	(4, 'Дункан', '2011-09-12', 'greeting, stand, walk, gallop')
	;
    
INSERT INTO `camels`
	(type_id, name, birthday, commands)
VALUES
	(5, 'Пол', '2003-04-18', 'spit, lie'),
    (5, 'Мисти', '2007-09-13', 'spit, lie'),
    (5, 'Вифсла', '2005-01-26', 'spit, lie'),
    (5, 'Тимон', '2006-08-14', 'spit, lie'),
	(5, 'Пумба', '2010-02-18', 'spit, lie')
	;
    
INSERT INTO `donkeys`
	(type_id, name, birthday, commands)
VALUES
	(6, 'Нэльсон', '2020-02-20', 'stand, walk, lie'),
    (6, 'Беатрикс', '2015-08-15', 'stand, walk, lie'),
    (6, 'Авалон', '2019-12-12', 'stand, walk, lie'),
    (6, 'Маркиз', '2017-07-12', 'stand, walk, lie'),
	(6, 'Нарцис', '2019-04-05', 'stand, walk, lie')
	;