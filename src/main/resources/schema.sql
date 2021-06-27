CREATE TABLE `application_metas` (
  `application_meta_id` varchar(255) NOT NULL,
  `deleted_time` timestamp NULL DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`application_meta_id`, `created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
