create table wp_rm_notes
(
    note_id          int auto_increment
        primary key,
    submission_id    int          not null,
    notes            longtext     null,
    status           varchar(255) null,
    publication_date datetime     not null,
    published_by     bigint       null,
    last_edit_date   datetime     null,
    last_edited_by   bigint       null,
    note_options     longtext     null
)
    collate = utf8mb4_unicode_520_ci;

