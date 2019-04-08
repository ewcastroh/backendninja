-- QUERIES TO START WITH A USER

-- USERS TABLE
SELECT * FROM mydb.users;

INSERT INTO mydb.users(username, password, enabled)
VALUES('user', '$2a$10$001mEbzFpQD7nZaBgEjJQumNJfMC7r0KvpMILJRjWpxki5MOfq.Xe', true);


-- USER_ROLES TABLE
SELECT * FROM mydb.user_roles;

INSERT INTO mydb.user_roles(user_role_id, username, role)
VALUES(1, 'user', 'ROLE_USER');