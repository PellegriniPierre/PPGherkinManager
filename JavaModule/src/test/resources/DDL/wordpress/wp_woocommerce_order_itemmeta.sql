create table wp_woocommerce_order_itemmeta
(
    meta_id       bigint unsigned auto_increment
        primary key,
    order_item_id bigint unsigned not null,
    meta_key      varchar(255)    null,
    meta_value    longtext        null
)
    collate = utf8mb4_unicode_520_ci;

create index meta_key
    on wp_woocommerce_order_itemmeta (meta_key(32));

create index order_item_id
    on wp_woocommerce_order_itemmeta (order_item_id);

