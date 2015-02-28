insert into users (id,username, password, enabled) values (1,'user', 'user', true);
insert into users (id,username, password, enabled) values (2,'John', 'walrus', true);
insert into users (id,username, password, enabled) values (3,'Paul', 'wings', true);
insert into users (id,username, password, enabled) values (4,'George', 'Wilbury', true);
insert into users (id,username, password, enabled) values (5,'Ringo', 'NoMore', true);

insert into authorities (username, authority) values ('user', 'ROLE_ADMIN');
