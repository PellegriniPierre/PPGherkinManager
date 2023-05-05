create table wp_woocommerce_attribute_taxonomies
(
    attribute_id      bigint unsigned auto_increment
        primary key,
    attribute_name    varchar(200)     not null,
    attribute_label   varchar(200)     null,
    attribute_type    varchar(20)      not null,
    attribute_orderby varchar(20)      not null,
    attribute_public  int(1) default 1 not null
)
    collate = utf8mb4_unicode_520_ci;

create index attribute_name
    on wp_woocommerce_attribute_taxonomies (attribute_name(20));

