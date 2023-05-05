create table wp_wc_customer_lookup
(
    customer_id      bigint unsigned auto_increment
        primary key,
    user_id          bigint unsigned         null,
    username         varchar(60)  default '' not null,
    first_name       varchar(255)            not null,
    last_name        varchar(255)            not null,
    email            varchar(100)            null,
    date_last_active timestamp               null,
    date_registered  timestamp               null,
    country          char(2)      default '' not null,
    postcode         varchar(20)  default '' not null,
    city             varchar(100) default '' not null,
    state            varchar(100) default '' not null,
    constraint user_id
        unique (user_id)
)
    collate = utf8mb4_unicode_520_ci;

create index email
    on wp_wc_customer_lookup (email);

