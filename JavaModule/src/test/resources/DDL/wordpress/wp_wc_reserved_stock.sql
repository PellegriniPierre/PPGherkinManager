create table wp_wc_reserved_stock
(
    order_id       bigint                                 not null,
    product_id     bigint                                 not null,
    stock_quantity double   default 0                     not null,
    timestamp      datetime default '0000-00-00 00:00:00' not null,
    expires        datetime default '0000-00-00 00:00:00' not null,
    primary key (order_id, product_id)
)
    collate = utf8mb4_unicode_520_ci;

