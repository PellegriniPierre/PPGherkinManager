create table wp_rm_paypal_logs
(
    id            int(6) unsigned auto_increment
        primary key,
    submission_id int(6)       null,
    form_id       int(6)       null,
    invoice       varchar(50)  null,
    txn_id        varchar(600) null,
    status        varchar(200) null,
    total_amount  double       null,
    currency      varchar(5)   null,
    log           longtext     null,
    posted_date   varchar(50)  null,
    pay_proc      varchar(50)  null,
    bill          longtext     null,
    ex_data       longtext     null
)
    collate = utf8mb4_unicode_520_ci;

