INSERT INTO _users (id, first_name, last_name, email, password)
VALUES (1, 'Viet', 'Tran', 'test@test.com', '$2a$12$OBnerD3ZrnkqY/ofkaxune1jnpUscFhTGCcuVA9x5lgAGAtr6Bss2');

INSERT INTO _users (id, first_name, last_name, email, password)
VALUES (2, 'Alex', 'T', 'alex@test.com', '$2a$12$OBnerD3ZrnkqY/ofkaxune1jnpUscFhTGCcuVA9x5lgAGAtr6Bss2');

INSERT INTO _users (id, first_name, last_name, email, password)
VALUES (3, 'Me', 'H', 'me@test.com', '$2a$12$OBnerD3ZrnkqY/ofkaxune1jnpUscFhTGCcuVA9x5lgAGAtr6Bss2');

INSERT INTO _user_roles(user_id, roles)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN'),
       (2, 'ROLE_USER'),
       (3, 'ROLE_ADMIN');

-- insert into post(id, description, user_id)
-- values (1, 'I want to learn AWS', 1);
--
-- insert into post(id, description, user_id)
-- values (2, 'I want to learn DevOps', 2);
--
-- insert into post(id, description, user_id)
-- values (3, 'I want to Get AWS Certified', 2);
--
-- insert into post(id, description, user_id)
-- values (4, 'I want to learn Multi Cloud', 3);

-- Insert into the 'content' table first
INSERT INTO content (title, description)
VALUES ('Video Title', 'Video Description');

-- Get the ID of the content we just inserted
SET @content_id = LAST_INSERT_ID();

-- Then insert into the 'video' table
INSERT INTO video (id, url, duration)
VALUES (@content_id, 'http://example.com/video', 120);

-- Insert into the 'content' table first
INSERT INTO content (title, description)
VALUES ('Article Title', 'Article Description');

-- Get the ID of the content we just inserted
SET @content_id = LAST_INSERT_ID();

-- Then insert into the 'article' table
INSERT INTO article (id, text, author)
VALUES (@content_id, 'Article Text', 'Article Author');

-- Insert into the 'content' table first
INSERT INTO content (title, description)
VALUES ('Article 2', 'Article Description 2');

-- Get the ID of the content we just inserted
SET @content_id = LAST_INSERT_ID();

-- Then insert into the 'article' table
INSERT INTO article (id, text, author)
VALUES (@content_id, 'Article Text 2', 'Article Author 2');

INSERT INTO post (id, type, content_id, user_id, created_at)
VALUES (1, 'Video', 1, 1, '2023-07-22 14:25:10');

INSERT INTO post (id, type, content_id, user_id, created_at)
VALUES (2, 'Article', 2, 1, '2023-07-22 15:30:15');

INSERT INTO post (id, type, content_id, user_id, created_at)
VALUES (3, 'Article', 3, 1, '2023-07-22 14:25:10');