-- Initialize database on startup. See
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html#howto-initialize-a-database-using-spring-jdbc
-- for explanation. This is a cool spring feature :-).


-- Remove everything.
DELETE FROM COMMENT;
DELETE FROM POST;
DELETE FROM USER_;

-- Insert new users.
INSERT INTO USER_ (id, email, PASSWORD) VALUES
  (1, 'alexander', 'password'),
  (2, 'klaus', 'kleber');

-- Add some posts.
INSERT INTO POST (id, title, content,  AUTHOR_ID, time_of_creation) VALUES
  (1, 'title-1', 'content-1', 1, CURRENT_TIMESTAMP ),
  (2, 'title-2', 'content-2', 2, CURRENT_TIMESTAMP );

-- Add some comments to posts.
INSERT INTO COMMENT (id, AUTHOR_ID, POST_ID, content, time_of_creation) VALUES
  (1, 1, 1, 'comment-1', CURRENT_TIMESTAMP);