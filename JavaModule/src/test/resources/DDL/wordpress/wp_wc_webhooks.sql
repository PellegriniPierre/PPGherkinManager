create table wp_wc_webhooks
(
    webhook_id        bigint unsigned auto_increment
        primary key,
    status            varchar(200)                               not null,
    name              text                                       not null,
    user_id           bigint unsigned                            not null,
    delivery_url      text                                       not null,
    secret            text                                       not null,
    topic             varchar(200)                               not null,
    date_created      datetime     default '0000-00-00 00:00:00' not null,
    date_created_gmt  datetime     default '0000-00-00 00:00:00' not null,
    date_modified     datetime     default '0000-00-00 00:00:00' not null,
    date_modified_gmt datetime     default '0000-00-00 00:00:00' not null,
    api_version       smallint(4)                                not null,
    failure_count     smallint(10) default 0                     not null,
    pending_delivery  tinyint(1)   default 0                     not null
)
    collate = utf8mb4_unicode_520_ci;

create index user_id
    on wp_wc_webhooks (user_id);

