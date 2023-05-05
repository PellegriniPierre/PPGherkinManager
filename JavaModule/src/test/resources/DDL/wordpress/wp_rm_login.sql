create table wp_rm_login
(
    id    int(6) unsigned auto_increment
        primary key,
    m_key varchar(255) null,
    value text         null
)
    collate = utf8mb4_unicode_520_ci;

