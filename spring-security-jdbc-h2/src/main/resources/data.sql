insert into users (username, password, enabled) values ('walker', '$2a$10$46W30iLJ5CJFvZ.7d/PCh.FDhy1UCw5Lq40nLeOqL1saqLNXEPMmG', true);
insert into users (username, password, enabled) values ('admin', '$2a$10$YtaThe4ZEvNzdd0d83YJIujnXzCowBzEhvJBLA153VMhKvH5rvhdC', true);

insert into authorities (username, authority) values ('walker', 'ROLE_USER');
insert into authorities (username, authority) values ('admin', 'ROLE_USER');
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');