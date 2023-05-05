create table wp_rm_submission_fields
(
    sub_field_id  int(6) unsigned auto_increment
        primary key,
    submission_id int(6) null,
    field_id      int(6) null,
    form_id       int(6) null,
    value         text   null
)
    collate = utf8mb4_unicode_520_ci;

