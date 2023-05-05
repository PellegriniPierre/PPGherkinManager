create table wp_rm_sent_mails
(
    mail_id          int auto_increment
        primary key,
    type             int                  not null,
    `to`             varchar(255)         null,
    sub              longtext             null,
    body             longtext             null,
    sent_on          datetime             null,
    headers          varchar(255)         null,
    form_id          int                  null,
    exdata           varchar(255)         null,
    is_read_by_user  tinyint(1) default 0 not null,
    was_sent_success tinyint(1) default 1 not null
)
    collate = utf8mb4_unicode_520_ci;

