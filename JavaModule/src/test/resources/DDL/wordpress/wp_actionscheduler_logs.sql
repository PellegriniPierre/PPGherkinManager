create table wp_actionscheduler_logs
(
    log_id         bigint unsigned auto_increment
        primary key,
    action_id      bigint unsigned                        not null,
    message        text                                   not null,
    log_date_gmt   datetime default '0000-00-00 00:00:00' null,
    log_date_local datetime default '0000-00-00 00:00:00' null
)
    collate = utf8mb4_unicode_520_ci;

create index action_id
    on wp_actionscheduler_logs (action_id);

create index log_date_gmt
    on wp_actionscheduler_logs (log_date_gmt);

