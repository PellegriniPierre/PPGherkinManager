create table wp_woocommerce_payment_tokens
(
    token_id   bigint unsigned auto_increment
        primary key,
    gateway_id varchar(200)              not null,
    token      text                      not null,
    user_id    bigint unsigned default 0 not null,
    type       varchar(200)              not null,
    is_default tinyint(1)      default 0 not null
)
    collate = utf8mb4_unicode_520_ci;

create index user_id
    on wp_woocommerce_payment_tokens (user_id);

