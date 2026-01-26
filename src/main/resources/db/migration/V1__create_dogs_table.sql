create table dogs
(
    id         bigserial
        constraint dogs_pk
            primary key,
    name       varchar(255)                           not null,
    breed      varchar(255)                           not null,
    age        smallint                               not null,
    created_at timestamp with time zone default now() not null
);