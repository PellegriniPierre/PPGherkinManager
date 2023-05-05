create table wp_wc_product_attributes_lookup
(
    product_id             bigint      not null,
    product_or_parent_id   bigint      not null,
    taxonomy               varchar(32) not null,
    term_id                bigint      not null,
    is_variation_attribute tinyint(1)  not null,
    in_stock               tinyint(1)  not null,
    primary key (product_or_parent_id, term_id, product_id, taxonomy)
)
    collate = utf8mb4_unicode_520_ci;

create index is_variation_attribute_term_id
    on wp_wc_product_attributes_lookup (is_variation_attribute, term_id);

