create table wp_rm_reports_notifications
(
    id                 int(6) unsigned auto_increment
        primary key,
    notification_title text       null,
    notification_type  text       null,
    form_id            int(6)     null,
    login_status       text       null,
    payment_status     text       null,
    sent_to            text       null,
    admin_id           int(6)     null,
    receivers          text       null,
    cron_type          text       null,
    first_exe          text       null,
    last_exe           text       null,
    enable             int(6)     null,
    email_subject      text       null,
    email_content      mediumtext null
)
    collate = utf8mb4_unicode_520_ci;

