create table wp_wc_admin_note_actions
(
    action_id     bigint unsigned auto_increment
        primary key,
    note_id       bigint unsigned not null,
    name          varchar(255)    not null,
    label         varchar(255)    not null,
    query         longtext        not null,
    status        varchar(255)    not null,
    actioned_text varchar(255)    not null,
    nonce_action  varchar(255)    null,
    nonce_name    varchar(255)    null
)
    collate = utf8mb4_unicode_520_ci;

create index note_id
    on wp_wc_admin_note_actions (note_id);

