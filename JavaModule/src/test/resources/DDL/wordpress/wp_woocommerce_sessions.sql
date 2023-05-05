create table wp_woocommerce_sessions
(
    session_id     bigint unsigned auto_increment
        primary key,
    session_key    char(32)        not null,
    session_value  longtext        not null,
    session_expiry bigint unsigned not null,
    constraint session_key
        unique (session_key)
)
    collate = utf8mb4_unicode_520_ci;

