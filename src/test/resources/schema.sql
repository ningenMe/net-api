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

CREATE TABLE `problems` (
  `problem_id` integer(10) unsigned AUTO_INCREMENT NOT NULL,
  `url` varchar(511) NOT NULL,
  `problem_name` varchar(511) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `estimation` int(10) unsigned NOT NULL DEFAULT '0',
  `deleted_time` timestamp NULL DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`problem_id`),
  UNIQUE `url` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `genres` (
  `genre_id` integer(10) unsigned AUTO_INCREMENT NOT NULL,
  `genre_name` varchar(511) NOT NULL,
  `path` char(255) NOT NULL,
  `genre_order` int(11) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`genre_id`),
  UNIQUE KEY `path_unique` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `topics` (
  `topic_id` integer(10) unsigned AUTO_INCREMENT NOT NULL,
  `genre_id` int(10) unsigned NOT NULL,
  `topic_name` varchar(511) NOT NULL,
  `topic_order` int(11) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`topic_id`),
  FOREIGN KEY `genre_id_foreign` (`genre_id`) REFERENCES `genres` (`genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `relation_topics_tasks` (
  `topic_id` integer(10) unsigned  NOT NULL,
  `problem_id` integer(10) unsigned  NOT NULL,
  PRIMARY KEY (`topic_id`,`problem_id`),
  KEY `problem_id` (`problem_id`),
  FOREIGN KEY `topic_id_foreign` (`topic_id`) REFERENCES `topics` (`topic_id`),
  FOREIGN KEY `problem_id_foreign` (`problem_id`) REFERENCES `problems` (`problem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- insert into genres (genre_id, genre_name, path, genre_order) select genre_id, genre_name, label, genre_order from compro_category_genres where compro_category_genres.deleted_time is null;
-- insert into topics (topic_id, genre_id, topic_name, topic_order) select topic_id, genre_id, topic_name, topic_order from compro_category_topics where compro_category_topics.deleted_time is null;
