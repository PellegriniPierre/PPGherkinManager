create table wp_wpmailsmtp_tasks_meta
(
    id     bigint auto_increment
        primary key,
    action varchar(255) not null,
    data   longtext     not null,
    date   datetime     not null
)
    collate = utf8mb4_unicode_520_ci;

