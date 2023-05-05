create table wp_wc_tax_rate_classes
(
    tax_rate_class_id bigint unsigned auto_increment
        primary key,
    name              varchar(200) default '' not null,
    slug              varchar(200) default '' not null,
    constraint slug
        unique (slug(191))
)
    collate = utf8mb4_unicode_520_ci;

