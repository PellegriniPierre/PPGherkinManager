create table wp_rm_login_log
(
    id             int(6) unsigned auto_increment
        primary key,
    email          varchar(255) null,
    username_used  varchar(255) null,
    time           datetime     null,
    status         int(1)       null,
    ip             varchar(255) null,
    browser        varchar(255) null,
    type           varchar(10)  null,
    ban            int(1)       null,
    result         varchar(255) null,
    failure_reason varchar(255) null,
    ban_til        datetime     null,
    login_url      varchar(255) null,
    social_type    varchar(50)  null
)
    collate = utf8mb4_unicode_520_ci;

