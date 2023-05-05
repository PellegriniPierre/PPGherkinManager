create table wp_gla_shipping_rates
(
    id       bigint auto_increment
        primary key,
    country  varchar(2)       not null,
    currency varchar(3)       not null,
    rate     double default 0 not null,
    options  text             null
)
    collate = utf8mb4_unicode_520_ci;

create index country
    on wp_gla_shipping_rates (country);

create index currency
    on wp_gla_shipping_rates (currency);

