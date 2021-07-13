CREATE TABLE `application_metas` (
  `application_meta_id` varchar(255) NOT NULL,
  `deleted_time` timestamp NULL DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`application_meta_id`, `created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `net_users` (
  `net_user_id` varchar(255) NOT NULL,
  `password`    varchar(255) NOT NULL,
  `role`        varchar(255) NOT NULL,
  `deleted_time` timestamp NULL DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`net_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `blogs` (
  `url`   varchar(255) NOT NULL,
  `date`  varchar(255) NOT NULL,
  `type`  varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `liked` integer(10) NOT NULL DEFAULT 0,
  `deleted_time` timestamp NULL DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
