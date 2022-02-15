
/*
 * A senha decodificada é senha: pass e o username: user
 * */
CREATE TABLE user (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `password` varchar(100) NOT NULL,
  `roles` varchar(50) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO user
(active, password, roles, user_name)
VALUES(1, '$2a$10$efjReUqKAkt2LlypJb71h.Y3S1B0.QhSX4z0BDjjbzmHfW0foiIhK', 'ADM', 'admin');

INSERT INTO user
(active, password, roles, user_name)
VALUES(1, '$2a$10$efjReUqKAkt2LlypJb71h.Y3S1B0.QhSX4z0BDjjbzmHfW0foiIhK', 'USER', 'user');

