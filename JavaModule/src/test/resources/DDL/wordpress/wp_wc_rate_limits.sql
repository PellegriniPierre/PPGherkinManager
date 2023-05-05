create table wp_wc_rate_limits
(
    rate_limit_id        bigint unsigned auto_increment
        primary key,
    rate_limit_key       varchar(200)           not null,
    rate_limit_expiry    bigint unsigned        not null,
    rate_limit_remaining smallint(10) default 0 not null,
    constraint rate_limit_key
        unique (rate_limit_key(191))
)
    collate = utf8mb4_unicode_520_ci;

