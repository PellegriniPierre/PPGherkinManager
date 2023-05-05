create table wp_rm_submissions
(
    submission_id int(6) unsigned auto_increment
        primary key,
    form_id       int(6)               null,
    data          text                 null,
    user_email    varchar(250)         null,
    child_id      int(6)     default 0 not null,
    last_child    int(6)     default 0 not null,
    is_read       tinyint(1) default 0 not null,
    submitted_on  datetime             null,
    unique_token  varchar(250)         null
)
    collate = utf8mb4_unicode_520_ci;

