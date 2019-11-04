CREATE TABLE `local`
(
    id   int primary key AUTO_INCREMENT,
    name varchar(150)
);

CREATE TABLE `user`
(
    id   int primary key AUTO_INCREMENT,
    name varchar(150)
);

CREATE TABLE `extra`
(
    id int primary key AUTO_INCREMENT,
    user_id  int,
    local_id int
);



ALTER TABLE `extra`
    ADD CONSTRAINT `FK_extra-local` FOREIGN KEY (local_id) REFERENCES `local` (id);
ALTER TABLE `extra`
    ADD CONSTRAINT `FK_extra-user` FOREIGN KEY (user_id) REFERENCES `user` (id);
