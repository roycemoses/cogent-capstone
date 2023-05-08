DROP DATABASE do_connect;
CREATE DATABASE do_connect;

USE do_connect;


-- *** USER QUERIES ***
DROP TABLE IF EXISTS user_table;
CREATE TABLE user_table (
	id int NOT NULL AUTO_INCREMENT,
    email varchar(40),
    name varchar(40),
    password varchar(40),
    user_name varchar(40),
    user_type varchar(40),
	PRIMARY KEY (id)
);
SELECT * FROM user_table;
DELETE FROM user_table WHERE name='user1';
INSERT INTO user_table (id, email, name, password, user_name, user_type) VALUES (1, 'user1@gmail.com', 'user1', 'pwd1', 'user1_user', 'admin');
UPDATE user_table SET name='User9', user_type='user' WHERE id='1';

-- *** QUESTION QUERIES ***
CREATE TABLE question_table (
	id int NOT NULL AUTO_INCREMENT,
    datetime varchar(40),
    description_question varchar(40),
    image_src varchar(40),
    qapproved_by varchar(40),
    qcreated_by varchar(40),
    status varchar(40),
    title varchar(40),
    topic varchar(40),
	PRIMARY KEY (id)
);
SELECT * FROM question_table;
DELETE FROM question_table WHERE status='pending';
INSERT INTO question_table (id, datetime, description_question, image_src, qapproved_by, qcreated_by, status, title, topic) VALUES (2, '05/08/2023 04:22:20', 'What is the capital city of France?', 'assets/test_image1.png', 'Jane Smith', 'John Doe', 'pending', 'French Capital', 'Geography');
UPDATE question_table SET topic='Art' WHERE qapproved_by='John Doe';

-- *** ANSWER QUERIES ***
CREATE TABLE answer_table (
	id int NOT NULL AUTO_INCREMENT,
    approved_by varchar(40),
    created_by varchar(40),
    datetime varchar(40),
    description_answer varchar(40),
    image_src varchar(40),
    status varchar(40),
    question_id varchar(40),
	PRIMARY KEY (id)
);
SELECT * FROM answer_table;
DELETE FROM answer_table WHERE question_id='7';
INSERT INTO answer_table (id, approved_by, created_by, datetime, description_answer, image_src, status, question_id) VALUES (11, 'Jane Smith', 'John Doe', '05/08/2023 15:25:27', 'The capital city of France is Paris.', 'assets/test_image1.png', 'accepted', '6');
UPDATE answer_table SET status='accepted' WHERE created_by='Alice Lee';

-- *** CHAT QUERIES ***
CREATE TABLE chat_table (
	id int NOT NULL AUTO_INCREMENT,
    datetime varchar(40),
    from_user varchar(40),
    message varchar(500),
    to_user varchar(40),
	PRIMARY KEY (id)
);
SELECT * FROM chat_table;
DELETE FROM chat_table WHERE from_user='user1';
INSERT INTO chat_table (id, datetime, from_user, message, to_user) VALUES (15, '05/08/2023 15:25:27', 'gyanendra', 'i like cats', 'user1');
UPDATE chat_table SET message='i like dogs' WHERE id='20';

SELECT * FROM user_table;
SELECT * FROM question_table;
SELECT * FROM answer_table;
SELECT * FROM chat_table;
DELETE FROM question_table WHERE created_by='user1';
