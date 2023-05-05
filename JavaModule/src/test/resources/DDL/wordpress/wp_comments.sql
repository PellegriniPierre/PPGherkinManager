create table wp_comments
(
    comment_ID           bigint unsigned auto_increment
        primary key,
    comment_post_ID      bigint unsigned default 0                     not null,
    comment_author       tinytext                                      not null,
    comment_author_email varchar(100)    default ''                    not null,
    comment_author_url   varchar(200)    default ''                    not null,
    comment_author_IP    varchar(100)    default ''                    not null,
    comment_date         datetime        default '0000-00-00 00:00:00' not null,
    comment_date_gmt     datetime        default '0000-00-00 00:00:00' not null,
    comment_content      text                                          not null,
    comment_karma        int             default 0                     not null,
    comment_approved     varchar(20)     default '1'                   not null,
    comment_agent        varchar(255)    default ''                    not null,
    comment_type         varchar(20)     default 'comment'             not null,
    comment_parent       bigint unsigned default 0                     not null,
    user_id              bigint unsigned default 0                     not null
)
    collate = utf8mb4_unicode_520_ci;

create index comment_approved_date_gmt
    on wp_comments (comment_approved, comment_date_gmt);

create index comment_author_email
    on wp_comments (comment_author_email(10));

create index comment_date_gmt
    on wp_comments (comment_date_gmt);

create index comment_parent
    on wp_comments (comment_parent);

create index comment_post_ID
    on wp_comments (comment_post_ID);

create index woo_idx_comment_type
    on wp_comments (comment_type);

