create table wp_wc_product_meta_lookup
(
    product_id     bigint                          not null
        primary key,
    sku            varchar(100)  default ''        null,
    virtual        tinyint(1)    default 0         null,
    downloadable   tinyint(1)    default 0         null,
    min_price      decimal(19, 4)                  null,
    max_price      decimal(19, 4)                  null,
    onsale         tinyint(1)    default 0         null,
    stock_quantity double                          null,
    stock_status   varchar(100)  default 'instock' null,
    rating_count   bigint        default 0         null,
    average_rating decimal(3, 2) default 0.00      null,
    total_sales    bigint        default 0         null,
    tax_status     varchar(100)  default 'taxable' null,
    tax_class      varchar(100)  default ''        null
)
    collate = utf8mb4_unicode_520_ci;

create index downloadable
    on wp_wc_product_meta_lookup (downloadable);

create index min_max_price
    on wp_wc_product_meta_lookup (min_price, max_price);

create index onsale
    on wp_wc_product_meta_lookup (onsale);

create index stock_quantity
    on wp_wc_product_meta_lookup (stock_quantity);

create index stock_status
    on wp_wc_product_meta_lookup (stock_status);

create index virtual
    on wp_wc_product_meta_lookup (virtual);

