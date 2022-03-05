create sequence if not exists hibernate_sequence;
create table if not exists sample(id int, external_id varchar(100), name varchar(100));