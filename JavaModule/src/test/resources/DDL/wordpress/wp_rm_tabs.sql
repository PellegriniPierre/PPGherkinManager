create table wp_rm_tabs
(
    tab_id      int(6) unsigned auto_increment
        primary key,
    tab_label   text       null,
    tab_icon    text       null,
    tab_class   text       null,
    tab_status  int(6)     null,
    tab_content mediumtext null
)
    collate = utf8mb4_unicode_520_ci;

