create table wp_rm_task_exe_log
(
    texe_log_id int(6) unsigned auto_increment
        primary key,
    task_id     int(6)   null,
    action      int(6)   null,
    sub_ids     longtext null,
    user_ids    longtext null,
    meta        text     null
)
    collate = utf8mb4_unicode_520_ci;

