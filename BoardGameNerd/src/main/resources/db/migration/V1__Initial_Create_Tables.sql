CREATE TABLE authorities
(
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL
);

CREATE TABLE persistent_logins
(
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) PRIMARY KEY NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL
);

CREATE TABLE users
(
    id BIGINT PRIMARY KEY NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(60) NOT NULL,
    email VARCHAR(100) NOT NULL,
    enabled BOOL NOT NULL,
    account_non_expired BOOL NOT NULL DEFAULT TRUE,
    account_non_locked BOOL NOT NULL DEFAULT TRUE,
    credentials_non_expired BOOL NOT NULL DEFAULT TRUE
);

ALTER TABLE users ADD CONSTRAINT ix_users_username UNIQUE (username);
ALTER TABLE users ADD CONSTRAINT ix_users_email UNIQUE (email);
ALTER TABLE authorities ADD CONSTRAINT ix_auth_username UNIQUE (username, authority);

ALTER TABLE authorities ADD FOREIGN KEY (username) REFERENCES users (username);

CREATE SEQUENCE hibernate_sequence INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 4 CACHE 1;
