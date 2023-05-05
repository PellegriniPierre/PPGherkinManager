create table wp_woocommerce_shipping_zone_methods
(
    zone_id      bigint unsigned      not null,
    instance_id  bigint unsigned auto_increment
        primary key,
    method_id    varchar(200)         not null,
    method_order bigint unsigned      not null,
    is_enabled   tinyint(1) default 1 not null
)
    collate = utf8mb4_unicode_520_ci;

