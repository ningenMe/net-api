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

CREATE TABLE `comic_pages` (
                               `url` varchar(511) NOT NULL,
                               `name` varchar(511) NOT NULL DEFAULT '',
                               `processed_time` timestamp NOT NULL,
                               `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               `deleted_time` timestamp NULL DEFAULT NULL,
                               PRIMARY KEY (`url`),
                               KEY `processed_time` (`processed_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `creators` (
                            `creator_id` integer(10) unsigned AUTO_INCREMENT NOT NULL,
                            `creator_name` varchar(511) NOT NULL,
                            `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            `deleted_time` timestamp NULL DEFAULT NULL,
                            PRIMARY KEY (`creator_id`),
                            UNIQUE KEY `creator_name_unique` (`creator_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `publishers` (
                              `publisher_id` integer(10) unsigned AUTO_INCREMENT NOT NULL,
                              `publisher_name` varchar(511) NOT NULL,
                              `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              `deleted_time` timestamp NULL DEFAULT NULL,
                              PRIMARY KEY (`publisher_id`),
                              UNIQUE KEY `publisher_name_unique` (`publisher_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `works` (
                         `work_id` integer(10) unsigned AUTO_INCREMENT NOT NULL,
                         `work_name` varchar(511) NOT NULL,
                         `publisher_name` varchar(511) NOT NULL,
                         `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         `deleted_time` timestamp NULL DEFAULT NULL,
                         PRIMARY KEY (`work_id`),
                         UNIQUE KEY `work_name_unique` (`work_name`),
                         FOREIGN KEY `publisher_name_foreign` (`publisher_name`) REFERENCES `publishers` (`publisher_name`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comics` (
                          `comic_id` integer(10) unsigned AUTO_INCREMENT NOT NULL,
                          `isbn13` varchar(13) NOT NULL,
                          `url` varchar(511) NOT NULL,
                          `work_id` integer(10) unsigned NOT NULL,
                          `comic_name` varchar(511) NOT NULL,
                          `published_date` date NOT NULL,
                          `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          `deleted_time` timestamp NULL DEFAULT NULL,
                          PRIMARY KEY (`comic_id`),
                          UNIQUE KEY `isbn13_unique` (`isbn13`),
                          KEY `published_date` (`published_date`),
                          FOREIGN KEY `work_id_foreign` (`work_id`) REFERENCES `works` (`work_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `relation_creators_works` (
                                            `creator_id` integer(10) unsigned NOT NULL,
                                            `work_id` integer(10) unsigned NOT NULL,
                                            PRIMARY KEY (`creator_id`,`work_id`),
                                            KEY `work_id` (`work_id`),
                                            FOREIGN KEY `creator_id_foreign` (`creator_id`) REFERENCES `creators` (`creator_id`) ON DELETE CASCADE,
                                            FOREIGN KEY `work_id_foreign` (`work_id`) REFERENCES `works` (`work_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
