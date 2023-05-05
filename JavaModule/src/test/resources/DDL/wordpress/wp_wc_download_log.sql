create table wp_wc_download_log
(
    download_log_id bigint unsigned auto_increment
        primary key,
    timestamp       datetime                not null,
    permission_id   bigint unsigned         not null,
    user_id         bigint unsigned         null,
    user_ip_address varchar(100) default '' null
)
    collate = utf8mb4_unicode_520_ci;

create index permission_id
    on wp_wc_download_log (permission_id);

create index timestamp
    on wp_wc_download_log (timestamp);

