create table wp_woocommerce_log
(
    log_id    bigint unsigned auto_increment
        primary key,
    timestamp datetime     not null,
    level     smallint(4)  not null,
    source    varchar(200) not null,
    message   longtext     not null,
    context   longtext     null
)
    collate = utf8mb4_unicode_520_ci;

create index level
    on wp_woocommerce_log (level);

