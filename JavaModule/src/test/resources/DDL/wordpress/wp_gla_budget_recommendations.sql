create table wp_gla_budget_recommendations
(
    id                bigint auto_increment
        primary key,
    currency          varchar(3) not null,
    country           varchar(2) not null,
    daily_budget_low  int        not null,
    daily_budget_high int        not null,
    constraint country_currency
        unique (country, currency)
)
    collate = utf8mb4_unicode_520_ci;

