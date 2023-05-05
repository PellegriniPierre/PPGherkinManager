create table wp_rm_stats
(
    stat_id       int auto_increment
        primary key,
    form_id       int(6)       null,
    user_ip       varchar(50)  null,
    ua_string     varchar(255) null,
    browser_name  varchar(50)  null,
    visited_on    varchar(50)  null,
    submitted_on  varchar(50)  null,
    time_taken    int          null,
    submission_id int(6)       null
)
    collate = utf8mb4_unicode_520_ci;

