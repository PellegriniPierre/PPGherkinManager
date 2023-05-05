create table wp_actionscheduler_groups
(
    group_id bigint unsigned auto_increment
        primary key,
    slug     varchar(255) not null
)
    collate = utf8mb4_unicode_520_ci;

create index slug
    on wp_actionscheduler_groups (slug(191));

