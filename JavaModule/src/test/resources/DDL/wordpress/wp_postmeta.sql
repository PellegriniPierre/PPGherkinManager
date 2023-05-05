create table wp_postmeta
(
    meta_id    bigint unsigned auto_increment
        primary key,
    post_id    bigint unsigned default 0 not null,
    meta_key   varchar(255)              null,
    meta_value longtext                  null
)
    collate = utf8mb4_unicode_520_ci;

create index meta_key
    on wp_postmeta (meta_key(191));

create index post_id
    on wp_postmeta (post_id);

