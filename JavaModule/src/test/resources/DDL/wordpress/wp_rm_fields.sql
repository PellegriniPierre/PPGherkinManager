create table wp_rm_fields
(
    field_id                int(6) unsigned auto_increment
        primary key,
    form_id                 int(6)                    null,
    page_no                 int(6) unsigned default 1 not null,
    field_label             text                      null,
    field_type              text                      null,
    field_value             mediumtext                null,
    field_order             int(6)                    null,
    field_show_on_user_page tinyint(1)                null,
    is_field_primary        tinyint(1)      default 0 not null,
    field_is_editable       tinyint(1)      default 0 not null,
    is_deletion_allowed     tinyint(1)      default 1 not null,
    field_options           mediumtext                null
)
    collate = utf8mb4_unicode_520_ci;

