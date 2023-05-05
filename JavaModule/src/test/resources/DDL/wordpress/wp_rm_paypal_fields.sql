create table wp_rm_paypal_fields
(
    field_id      int(6) unsigned auto_increment
        primary key,
    type          varchar(50)  null,
    name          varchar(256) null,
    value         longtext     null,
    class         varchar(256) null,
    option_label  longtext     null,
    option_price  longtext     null,
    option_value  longtext     null,
    description   longtext     null,
    `require`     longtext     null,
    `order`       int          null,
    extra_options longtext     null
)
    collate = utf8mb4_unicode_520_ci;

