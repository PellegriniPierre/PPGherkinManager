create table wp_usermeta
(
    umeta_id   bigint unsigned auto_increment
        primary key,
    user_id    bigint unsigned default 0 not null,
    meta_key   varchar(255)              null,
    meta_value longtext                  null
)
    collate = utf8mb4_unicode_520_ci;

create index meta_key
    on wp_usermeta (meta_key(191));

create index user_id
    on wp_usermeta (user_id);

