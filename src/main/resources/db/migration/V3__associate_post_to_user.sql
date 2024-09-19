ALTER TABLE posts
ADD COLUMN user_id BIGINT;

ALTER TABLE posts
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id) REFERENCES users(id);

INSERT INTO users (nome, email, senha, avatar) VALUES
('Alice', 'alice@gmail.com', '$2a$12$4TgHfKR9lQibgu65IkAxDO1FN7ubGk42sk8iPvpZ.Dcf4Qnyzmtei', 'https://avatar.iran.liara.run/username?username=Alice' ),
('Bob', 'bob@gmail.com', '$2a$12$4TgHfKR9lQibgu65IkAxDO1FN7ubGk42sk8iPvpZ.Dcf4Qnyzmtei', 'https://avatar.iran.liara.run/username?username=Bob');

UPDATE posts SET user_id = (SELECT id FROM users WHERE email = 'alice@gmail.com') WHERE id IN (1, 2, 4, 5, 9);
UPDATE posts SET user_id = (SELECT id FROM users WHERE email = 'bob@gmail.com') WHERE id IN (3, 6, 10, 7, 8);