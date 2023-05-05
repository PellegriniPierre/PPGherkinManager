create table wp_wc_category_lookup
(
    category_tree_id bigint unsigned not null,
    category_id      bigint unsigned not null,
    primary key (category_tree_id, category_id)
)
    collate = utf8mb4_unicode_520_ci;

