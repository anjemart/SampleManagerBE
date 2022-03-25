create sequence if not exists hibernate_sequence;

create table if not exists sample(
    id int GENERATED ALWAYS AS IDENTITY,
    external_id varchar(100) NOT NULL,
    name varchar(100) NOT NULL
);

create table if not exists customer(
    id int GENERATED ALWAYS AS IDENTITY,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    home_phone varchar(20),
    cell_phone varchar(20),
    email varchar(100)
);

create table if not exists checked_out_sample(
    id int GENERATED ALWAYS AS IDENTITY,
    sample_id int,
    customer_id int,
    created_on timestamptz Default now(),
    last_modified_on timestamptz Default now()
);