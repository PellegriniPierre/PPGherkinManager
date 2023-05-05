create table wp_rm_sessions
(
    id        varchar(128) not null
        primary key,
    data      mediumtext   not null,
    timestamp int(255)     not null
)
    collate = utf8mb4_unicode_520_ci;

