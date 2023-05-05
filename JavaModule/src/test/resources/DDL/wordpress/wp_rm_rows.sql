create table wp_rm_rows
(
    row_id      int(6) unsigned auto_increment
        primary key,
    form_id     int(6) unsigned           null,
    page_no     int(6) unsigned default 1 not null,
    columns     text                      null,
    class       text                      null,
    gutter      int(6) unsigned           null,
    bmargin     int(6) unsigned           null,
    width       int(6) unsigned           null,
    heading     text                      null,
    subheading  text                      null,
    field_ids   text                      null,
    row_order   int(6) unsigned           null,
    row_options mediumtext                null
)
    collate = utf8mb4_unicode_520_ci;

