create table wp_woocommerce_order_items
(
    order_item_id   bigint unsigned auto_increment
        primary key,
    order_item_name text                    not null,
    order_item_type varchar(200) default '' not null,
    order_id        bigint unsigned         not null
)
    collate = utf8mb4_unicode_520_ci;

create index order_id
    on wp_woocommerce_order_items (order_id);

