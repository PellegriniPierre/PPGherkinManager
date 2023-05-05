create table wp_actionscheduler_claims
(
    claim_id         bigint unsigned auto_increment
        primary key,
    date_created_gmt datetime default '0000-00-00 00:00:00' null
)
    collate = utf8mb4_unicode_520_ci;

create index date_created_gmt
    on wp_actionscheduler_claims (date_created_gmt);

