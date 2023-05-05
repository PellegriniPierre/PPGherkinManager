create table wp_woocommerce_api_keys
(
    key_id          bigint unsigned auto_increment
        primary key,
    user_id         bigint unsigned not null,
    description     varchar(200)    null,
    permissions     varchar(10)     not null,
    consumer_key    char(64)        not null,
    consumer_secret char(43)        not null,
    nonces          longtext        null,
    truncated_key   char(7)         not null,
    last_access     datetime        null
)
    collate = utf8mb4_unicode_520_ci;

create index consumer_key
    on wp_woocommerce_api_keys (consumer_key);

create index consumer_secret
    on wp_woocommerce_api_keys (consumer_secret);

