create table wp_wc_order_tax_lookup
(
    order_id     bigint unsigned                        not null,
    tax_rate_id  bigint unsigned                        not null,
    date_created datetime default '0000-00-00 00:00:00' not null,
    shipping_tax double   default 0                     not null,
    order_tax    double   default 0                     not null,
    total_tax    double   default 0                     not null,
    primary key (order_id, tax_rate_id)
)
    collate = utf8mb4_unicode_520_ci;

create index date_created
    on wp_wc_order_tax_lookup (date_created);

create index tax_rate_id
    on wp_wc_order_tax_lookup (tax_rate_id);

