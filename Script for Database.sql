CREATE DATABASE IF NOT EXISTS test;
GRANT ALL PRIVILEGES ON test.* TO root@localhost;
use test;
CREATE TABLE todo
(
    id		INT PRIMARY KEY AUTO_INCREMENT,
    descr	VARCHAR(100),
    stat	VARCHAR(11) default 'Uncompleted',
    created	TIMESTAMP DEFAULT NOW()
);

insert into test.todo (descr) values ('First TODO');
insert into test.todo (descr) values ('Second TODO');
insert into test.todo (descr, stat) values ('Third TODO', 'Completed');