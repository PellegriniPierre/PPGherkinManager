create table wp_wc_order_stats
(
    order_id           bigint unsigned                               not null
        primary key,
    parent_id          bigint unsigned default 0                     not null,
    date_created       datetime        default '0000-00-00 00:00:00' not null,
    date_created_gmt   datetime        default '0000-00-00 00:00:00' not null,
    date_paid          datetime        default '0000-00-00 00:00:00' null,
    date_completed     datetime        default '0000-00-00 00:00:00' null,
    num_items_sold     int             default 0                     not null,
    total_sales        double          default 0                     not null,
    tax_total          double          default 0                     not null,
    shipping_total     double          default 0                     not null,
    net_total          double          default 0                     not null,
    returning_customer tinyint(1)                                    null,
    status             varchar(200)                                  not null,
    customer_id        bigint unsigned                               not null
)
    collate = utf8mb4_unicode_520_ci;

create index customer_id
    on wp_wc_order_stats (customer_id);

create index date_created
    on wp_wc_order_stats (date_created);

create index status
    on wp_wc_order_stats (status(191));

