create table wp_rm_front_users
(
    id                 int(11) unsigned auto_increment
        primary key,
    email              varchar(255) null,
    otp_code           varchar(255) not null,
    last_activity_time datetime     null,
    created_date       datetime     null,
    expiry             datetime     null,
    attempts           int(3)       null,
    type               varchar(2)   null
)
    collate = utf8mb4_unicode_520_ci;

