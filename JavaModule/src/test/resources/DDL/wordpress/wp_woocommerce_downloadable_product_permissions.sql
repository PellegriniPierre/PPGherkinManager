create table wp_woocommerce_downloadable_product_permissions
(
    permission_id       bigint unsigned auto_increment
        primary key,
    download_id         varchar(36)                                   not null,
    product_id          bigint unsigned                               not null,
    order_id            bigint unsigned default 0                     not null,
    order_key           varchar(200)                                  not null,
    user_email          varchar(200)                                  not null,
    user_id             bigint unsigned                               null,
    downloads_remaining varchar(9)                                    null,
    access_granted      datetime        default '0000-00-00 00:00:00' not null,
    access_expires      datetime                                      null,
    download_count      bigint unsigned default 0                     not null
)
    collate = utf8mb4_unicode_520_ci;

create index download_order_key_product
    on wp_woocommerce_downloadable_product_permissions (product_id, order_id, order_key(16), download_id);

create index download_order_product
    on wp_woocommerce_downloadable_product_permissions (download_id, order_id, product_id);

create index order_id
    on wp_woocommerce_downloadable_product_permissions (order_id);

create index user_order_remaining_expires
    on wp_woocommerce_downloadable_product_permissions (user_id, order_id, downloads_remaining, access_expires);

