create table wp_posts
(
    ID                    bigint unsigned auto_increment
        primary key,
    post_author           bigint unsigned default 0                     not null,
    post_date             datetime        default '0000-00-00 00:00:00' not null,
    post_date_gmt         datetime        default '0000-00-00 00:00:00' not null,
    post_content          longtext                                      not null,
    post_title            text                                          not null,
    post_excerpt          text                                          not null,
    post_status           varchar(20)     default 'publish'             not null,
    comment_status        varchar(20)     default 'open'                not null,
    ping_status           varchar(20)     default 'open'                not null,
    post_password         varchar(255)    default ''                    not null,
    post_name             varchar(200)    default ''                    not null,
    to_ping               text                                          not null,
    pinged                text                                          not null,
    post_modified         datetime        default '0000-00-00 00:00:00' not null,
    post_modified_gmt     datetime        default '0000-00-00 00:00:00' not null,
    post_content_filtered longtext                                      not null,
    post_parent           bigint unsigned default 0                     not null,
    guid                  varchar(255)    default ''                    not null,
    menu_order            int             default 0                     not null,
    post_type             varchar(20)     default 'post'                not null,
    post_mime_type        varchar(100)    default ''                    not null,
    comment_count         bigint          default 0                     not null
)
    collate = utf8mb4_unicode_520_ci;

create index post_author
    on wp_posts (post_author);

create index post_name
    on wp_posts (post_name(191));

create index post_parent
    on wp_posts (post_parent);

create index type_status_date
    on wp_posts (post_type, post_status, post_date, ID);

