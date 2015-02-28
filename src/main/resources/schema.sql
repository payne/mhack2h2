create table users (
  id int,
  username varchar(256),
  password varchar(256),
  enabled boolean
);

create table authorities (
  username varchar(256),
  authority varchar(256)
);

