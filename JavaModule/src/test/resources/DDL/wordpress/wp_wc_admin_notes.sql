create table wp_wc_admin_notes
(
    note_id       bigint unsigned auto_increment
        primary key,
    name          varchar(255)                               not null,
    type          varchar(20)                                not null,
    locale        varchar(20)                                not null,
    title         longtext                                   not null,
    content       longtext                                   not null,
    content_data  longtext                                   null,
    status        varchar(200)                               not null,
    source        varchar(200)                               not null,
    date_created  datetime     default '0000-00-00 00:00:00' not null,
    date_reminder datetime                                   null,
    is_snoozable  tinyint(1)   default 0                     not null,
    layout        varchar(20)  default ''                    not null,
    image         varchar(200)                               null,
    is_deleted    tinyint(1)   default 0                     not null,
    is_read       tinyint(1)   default 0                     not null,
    icon          varchar(200) default 'info'                not null
)
    collate = utf8mb4_unicode_520_ci;

