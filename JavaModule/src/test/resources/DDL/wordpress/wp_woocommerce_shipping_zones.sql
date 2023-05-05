create table wp_woocommerce_shipping_zones
(
    zone_id    bigint unsigned auto_increment
        primary key,
    zone_name  varchar(200)    not null,
    zone_order bigint unsigned not null
)
    collate = utf8mb4_unicode_520_ci;

