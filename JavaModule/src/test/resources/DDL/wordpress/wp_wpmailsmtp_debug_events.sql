create table wp_wpmailsmtp_debug_events
(
    id         int unsigned auto_increment
        primary key,
    content    text                                       null,
    initiator  text                                       null,
    event_type tinyint unsigned default 0                 not null,
    created_at timestamp        default CURRENT_TIMESTAMP not null
)
    collate = utf8mb4_unicode_520_ci;

