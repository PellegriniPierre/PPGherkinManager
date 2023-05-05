create table wp_rm_forms
(
    form_id                 int(6) unsigned auto_increment
        primary key,
    form_name               varchar(1000) null,
    form_type               int(6)        null,
    form_user_role          varchar(1000) null,
    default_user_role       varchar(255)  null,
    form_should_send_email  tinyint(1)    null,
    form_redirect           varchar(10)   null,
    form_redirect_to_page   varchar(500)  null,
    form_redirect_to_url    varchar(500)  null,
    form_should_auto_expire tinyint(1)    null,
    form_options            text          null,
    published_pages         text          null,
    created_on              datetime      null,
    created_by              int(6)        null,
    modified_on             datetime      null,
    modified_by             int(6)        null
)
    collate = utf8mb4_unicode_520_ci;

