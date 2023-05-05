create table wp_woocommerce_tax_rate_locations
(
    location_id   bigint unsigned auto_increment
        primary key,
    location_code varchar(200)    not null,
    tax_rate_id   bigint unsigned not null,
    location_type varchar(40)     not null
)
    collate = utf8mb4_unicode_520_ci;

create index location_type_code
    on wp_woocommerce_tax_rate_locations (location_type(10), location_code(20));

create index tax_rate_id
    on wp_woocommerce_tax_rate_locations (tax_rate_id);

