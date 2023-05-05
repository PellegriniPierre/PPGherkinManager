create table wp_rm_tasks
(
    task_id    int(6) unsigned auto_increment
        primary key,
    form_id    int(6)               null,
    name       varchar(255)         null,
    `desc`     varchar(1000)        null,
    must_rules text                 null,
    any_rules  text                 null,
    is_active  tinyint(1) default 1 null,
    actions    text                 null,
    task_order int(6)               null,
    meta       text                 null
)
    collate = utf8mb4_unicode_520_ci;

