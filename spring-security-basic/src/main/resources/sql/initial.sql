insert into user(id, age, name, password, username) values (1, 21, 'jack', '$2a$10$29ORv.eo9caE.QEQH0Z0d.KqYZrM/FgGPBJo34eQZYhrytyI2eQhO', 'admin');
insert into user(id, age, name, password, username) values (2, 22, 'user', '$2a$10$sBedryBzg4mNlBX87CfLuuZSfLWooK.X4ctQYXtxAOyRqZeY24k22', 'walker');

insert into authority(id, name) values (1, 'ROLE_USER');
insert into authority(id, name) values (2, 'ROLE_ADMIN');

insert into user_authority(user_id, authority_id) values (1, 1);
insert into user_authority(user_id, authority_id) values (1, 2);
insert into user_authority(user_id, authority_id) values (2, 1);