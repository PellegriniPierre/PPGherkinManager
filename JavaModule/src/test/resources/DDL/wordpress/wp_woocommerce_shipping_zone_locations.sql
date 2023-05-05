create table wp_woocommerce_shipping_zone_locations
(
    location_id   bigint unsigned auto_increment
        primary key,
    zone_id       bigint unsigned not null,
    location_code varchar(200)    not null,
    location_type varchar(40)     not null
)
    collate = utf8mb4_unicode_520_ci;

create index location_id
    on wp_woocommerce_shipping_zone_locations (location_id);

create index location_type_code
    on wp_woocommerce_shipping_zone_locations (location_type(10), location_code(20));

