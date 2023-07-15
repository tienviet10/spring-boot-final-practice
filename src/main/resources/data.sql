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