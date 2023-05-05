create table wp_gla_shipping_times
(
    id      bigint auto_increment
        primary key,
    country varchar(2)       not null,
    time    bigint default 0 not null
)
    collate = utf8mb4_unicode_520_ci;

create index country
    on wp_gla_shipping_times (country);

