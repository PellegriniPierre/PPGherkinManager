create table wp_woocommerce_tax_rates
(
    tax_rate_id       bigint unsigned auto_increment
        primary key,
    tax_rate_country  varchar(2)   default '' not null,
    tax_rate_state    varchar(200) default '' not null,
    tax_rate          varchar(8)   default '' not null,
    tax_rate_name     varchar(200) default '' not null,
    tax_rate_priority bigint unsigned         not null,
    tax_rate_compound int(1)       default 0  not null,
    tax_rate_shipping int(1)       default 1  not null,
    tax_rate_order    bigint unsigned         not null,
    tax_rate_class    varchar(200) default '' not null
)
    collate = utf8mb4_unicode_520_ci;

create index tax_rate_class
    on wp_woocommerce_tax_rates (tax_rate_class(10));

create index tax_rate_country
    on wp_woocommerce_tax_rates (tax_rate_country);

create index tax_rate_priority
    on wp_woocommerce_tax_rates (tax_rate_priority);

create index tax_rate_state
    on wp_woocommerce_tax_rates (tax_rate_state(2));

