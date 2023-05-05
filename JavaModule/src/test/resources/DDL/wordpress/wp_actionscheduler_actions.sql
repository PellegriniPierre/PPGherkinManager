create table wp_actionscheduler_actions
(
    action_id            bigint unsigned auto_increment
        primary key,
    hook                 varchar(191)                                  not null,
    status               varchar(20)                                   not null,
    scheduled_date_gmt   datetime        default '0000-00-00 00:00:00' null,
    scheduled_date_local datetime        default '0000-00-00 00:00:00' null,
    args                 varchar(191)                                  null,
    schedule             longtext                                      null,
    group_id             bigint unsigned default 0                     not null,
    attempts             int             default 0                     not null,
    last_attempt_gmt     datetime        default '0000-00-00 00:00:00' null,
    last_attempt_local   datetime        default '0000-00-00 00:00:00' null,
    claim_id             bigint unsigned default 0                     not null,
    extended_args        varchar(8000)                                 null
)
    collate = utf8mb4_unicode_520_ci;

create index args
    on wp_actionscheduler_actions (args);

create index claim_id_status_scheduled_date_gmt
    on wp_actionscheduler_actions (claim_id, status, scheduled_date_gmt);

create index group_id
    on wp_actionscheduler_actions (group_id);

create index hook
    on wp_actionscheduler_actions (hook);

create index last_attempt_gmt
    on wp_actionscheduler_actions (last_attempt_gmt);

create index scheduled_date_gmt
    on wp_actionscheduler_actions (scheduled_date_gmt);

create index status
    on wp_actionscheduler_actions (status);

