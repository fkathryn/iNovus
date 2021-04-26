CREATE SCHEMA cats
    CREATE TABLE cats_table (
                                id bigint PRIMARY KEY not null unique,
                                images varchar(255)
                                name varchar(100) not null,
                                votes integer,
    );