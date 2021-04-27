-- DROP SCHEMA cats CASCADE;
CREATE SCHEMA cats
    CREATE TABLE IF NOT EXISTS cats_table (
                                id BIGINT PRIMARY KEY not null UNIQUE,
                                image VARCHAR(255) not null,
                                name VARCHAR(100) not null,
                                votes INTEGER
    );