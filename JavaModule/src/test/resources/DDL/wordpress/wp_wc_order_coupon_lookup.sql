create table wp_wc_order_coupon_lookup
(
    order_id        bigint unsigned                        not null,
    coupon_id       bigint                                 not null,
    date_created    datetime default '0000-00-00 00:00:00' not null,
    discount_amount double   default 0                     not null,
    primary key (order_id, coupon_id)
)
    collate = utf8mb4_unicode_520_ci;

create index coupon_id
    on wp_wc_order_coupon_lookup (coupon_id);

create index date_created
    on wp_wc_order_coupon_lookup (date_created);

