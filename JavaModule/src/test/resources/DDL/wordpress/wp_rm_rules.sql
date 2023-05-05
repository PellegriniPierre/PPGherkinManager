create table wp_rm_rules
(
    rule_id    int(6) unsigned auto_increment
        primary key,
    type       int(6)        null,
    attr_name  varchar(255)  null,
    attr_value varchar(1000) null,
    operator   varchar(20)   null,
    meta       text          null
)
    collate = utf8mb4_unicode_520_ci;

