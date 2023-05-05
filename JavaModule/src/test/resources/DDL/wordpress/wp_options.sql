create table wp_options
(
    option_id    bigint unsigned auto_increment
        primary key,
    option_name  varchar(191) default ''    not null,
    option_value longtext                   not null,
    autoload     varchar(20)  default 'yes' not null,
    constraint option_name
        unique (option_name)
)
    collate = utf8mb4_unicode_520_ci;

create index autoload
    on wp_options (autoload);

