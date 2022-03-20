CREATE TABLE `problems`
(
    `problem_id`   integer(10) unsigned AUTO_INCREMENT NOT NULL,
    `url`          varchar(511)                            NOT NULL,
    `problem_name` varchar(511) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
    `estimation`   int(10) unsigned NOT NULL DEFAULT '0',
    `deleted_time` timestamp NULL DEFAULT NULL,
    `created_time` timestamp                               NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp                               NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`problem_id`),
    UNIQUE `url` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `genres`
(
    `genre_id`     integer(10) unsigned AUTO_INCREMENT NOT NULL,
    `genre_name`   varchar(511) NOT NULL,
    `path`         char(255)    NOT NULL,
    `genre_order`  int(11) NOT NULL,
    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_time` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`genre_id`),
    UNIQUE KEY `path_unique` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `topics`
(
    `topic_id`     integer(10) unsigned AUTO_INCREMENT NOT NULL,
    `genre_id`     int(10) unsigned NOT NULL,
    `topic_name`   varchar(511) NOT NULL,
    `topic_order`  int(11) NOT NULL,
    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_time` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`topic_id`),
    FOREIGN KEY `genre_id_foreign` (`genre_id`) REFERENCES `genres` (`genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `relation_topics_problems`
(
    `topic_id`   integer(10) unsigned NOT NULL,
    `problem_id` integer(10) unsigned NOT NULL,
    PRIMARY KEY (`topic_id`, `problem_id`),
    KEY          `problem_id` (`problem_id`),
    FOREIGN KEY `topic_id_foreign` (`topic_id`) REFERENCES `topics` (`topic_id`),
    FOREIGN KEY `problem_id_foreign` (`problem_id`) REFERENCES `problems` (`problem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `atcoder_users`
(
    `atcoder_id`             varchar(255) NOT NULL,
    `topcoder_id`            varchar(255)          DEFAULT NULL,
    `codeforces_id`          varchar(255)          DEFAULT NULL,
    `yukicoder_id`           varchar(255)          DEFAULT NULL,
    `rank`                   int(255) DEFAULT NULL,
    `country`                varchar(255)          DEFAULT NULL,
    `affiliation`            varchar(255)          DEFAULT NULL,
    `current_rate`           int(255) DEFAULT NULL,
    `highest_rate`           int(255) DEFAULT NULL,
    `current_performance`    int(255) DEFAULT NULL,
    `highest_performance`    int(255) DEFAULT NULL,
    `first_participate_time` timestamp NULL DEFAULT NULL,
    `last_participate_time`  timestamp NULL DEFAULT NULL,
    `deleted_time`           timestamp NULL DEFAULT NULL,
    `created_time`           timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time`           timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`atcoder_id`),
    KEY                      `updated_time` (`updated_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `atcoder_user_contests`
(
    `atcoder_id`          varchar(255) NOT NULL,
    `contest_name_en`     varchar(255) NOT NULL,
    `is_rated`            tinyint(1) DEFAULT NULL,
    `place`               int(11) DEFAULT NULL,
    `old_rating`          int(11) DEFAULT NULL,
    `new_rating`          int(11) DEFAULT NULL,
    `performance`         int(11) DEFAULT NULL,
    `contest_type`        varchar(255)          DEFAULT NULL,
    `contest_screen_name` varchar(255)          DEFAULT NULL,
    `contest_name`        varchar(255)          DEFAULT NULL,
    `end_time`            timestamp NULL DEFAULT NULL,
    `deleted_time`        timestamp NULL DEFAULT NULL,
    `created_time`        timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time`        timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`atcoder_id`, `contest_name_en`),
    KEY                   `contest_name_en` (`contest_name_en`),
    KEY                   `end_time` (`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `atcoder_user_histories`
(
    `atcoder_id`   varchar(256) NOT NULL,
    `contest_id`   varchar(256) NOT NULL,
    `is_rated`     tinyint(1) DEFAULT NULL,
    `place`        int(11) DEFAULT NULL,
    `old_rating`   int(11) DEFAULT NULL,
    `new_rating`   int(11) DEFAULT NULL,
    `performance`  int(11) DEFAULT NULL,
    `deleted_time` timestamp NULL DEFAULT NULL,
    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`atcoder_id`, `contest_id`),
    KEY            `contest_id` (`contest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `healthchecks`
(
    `id` integer NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
