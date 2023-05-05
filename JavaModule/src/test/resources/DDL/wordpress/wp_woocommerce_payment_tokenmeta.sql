create table wp_woocommerce_payment_tokenmeta
(
    meta_id          bigint unsigned auto_increment
        primary key,
    payment_token_id bigint unsigned not null,
    meta_key         varchar(255)    null,
    meta_value       longtext        null
)
    collate = utf8mb4_unicode_520_ci;

create index meta_key
    on wp_woocommerce_payment_tokenmeta (meta_key(32));

create index payment_token_id
    on wp_woocommerce_payment_tokenmeta (payment_token_id);

