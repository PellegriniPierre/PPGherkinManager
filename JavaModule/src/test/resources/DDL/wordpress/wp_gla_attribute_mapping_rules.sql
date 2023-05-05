create table wp_gla_attribute_mapping_rules
(
    id                      bigint auto_increment
        primary key,
    attribute               varchar(255) not null,
    source                  varchar(100) not null,
    category_condition_type varchar(10)  not null,
    categories              text         null
)
    collate = utf8mb4_unicode_520_ci;

