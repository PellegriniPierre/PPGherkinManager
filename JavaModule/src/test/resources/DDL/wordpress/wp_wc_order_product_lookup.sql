create table wp_wc_order_product_lookup
(
    order_item_id         bigint unsigned                        not null
        primary key,
    order_id              bigint unsigned                        not null,
    product_id            bigint unsigned                        not null,
    variation_id          bigint unsigned                        not null,
    customer_id           bigint unsigned                        null,
    date_created          datetime default '0000-00-00 00:00:00' not null,
    product_qty           int                                    not null,
    product_net_revenue   double   default 0                     not null,
    product_gross_revenue double   default 0                     not null,
    coupon_amount         double   default 0                     not null,
    tax_amount            double   default 0                     not null,
    shipping_amount       double   default 0                     not null,
    shipping_tax_amount   double   default 0                     not null
)
    collate = utf8mb4_unicode_520_ci;

create index customer_id
    on wp_wc_order_product_lookup (customer_id);

create index date_created
    on wp_wc_order_product_lookup (date_created);

create index order_id
    on wp_wc_order_product_lookup (order_id);

create index product_id
    on wp_wc_order_product_lookup (product_id);

