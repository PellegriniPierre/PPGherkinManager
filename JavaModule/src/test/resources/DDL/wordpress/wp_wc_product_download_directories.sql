create table wp_wc_product_download_directories
(
    url_id  bigint unsigned auto_increment
        primary key,
    url     varchar(256)         not null,
    enabled tinyint(1) default 0 not null
)
    collate = utf8mb4_unicode_520_ci;

create index url
    on wp_wc_product_download_directories (url(191));

