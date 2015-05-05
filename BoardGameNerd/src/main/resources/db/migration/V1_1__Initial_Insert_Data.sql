/* Insert users */
INSERT INTO users (id, username, password, email, enabled) VALUES (1, 'admin', '$2a$10$WPLpJBsWtP4pxLy30FG7MeaKHV2.dIZd0He1Zkh3VHs02/CKnEjim', 'm.asakura@casema.nl', true);
INSERT INTO users (id, username, password, email, enabled) VALUES (2, 'test', '$2a$10$revBo75w74cQsvUvnRt8T.8oKCOADuGIBs1/chDgGWInC0GSj8LOa', 'guybrush_4@hotmail.com', true);
INSERT INTO users (id, username, password, email, enabled) VALUES (3, 'machiel', '$2a$10$VJi5evrfjM5lfpFOfehM7u/nD1tf.HjxQR/aKLPF/rRlrNd68LIwu', 'machiel@live.nl', true);

/* Insert authorities */
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_EDITOR');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_CONTRIBUTOR');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO authorities (username, authority) VALUES ('test', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('test', 'ROLE_EDITOR');

INSERT INTO authorities (username, authority) VALUES ('machiel', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('machiel', 'ROLE_CONTRIBUTOR');

