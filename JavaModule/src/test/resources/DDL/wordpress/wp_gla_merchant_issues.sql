create table wp_gla_merchant_issues
(
    id                   bigint auto_increment
        primary key,
    product_id           bigint                        not null,
    issue                varchar(200)                  not null,
    code                 varchar(100)                  not null,
    severity             varchar(20) default 'warning' not null,
    product              varchar(100)                  not null,
    action               text                          not null,
    action_url           varchar(1024)                 not null,
    applicable_countries text                          not null,
    source               varchar(10) default 'mc'      not null,
    type                 varchar(10) default 'product' not null,
    created_at           datetime                      not null
)
    collate = utf8mb4_unicode_520_ci;

