CREATE TABLE `cstudio_activity` (
  `id`             BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `modified_date`  DATETIME     NOT NULL,
  `creation_date`  DATETIME     NOT NULL,
  `summary`        TEXT         NOT NULL,
  `summary_format` VARCHAR(255) NOT NULL,
  `content_id`     TEXT         NOT NULL,
  `site_network`   VARCHAR(255) NOT NULL,
  `activity_type`  VARCHAR(255) NOT NULL,
  `content_type`   VARCHAR(255) NOT NULL,
  `post_user_id`   VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cstudio_activity_user_idx` (`post_user_id`),
  KEY `cstudio_activity_site_idx` (`site_network`),
  KEY `cstudio_activity_content_idx` (`content_id`(255))
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE `cstudio_DEPENDENCY` (
  `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `site`        VARCHAR(35) NOT NULL,
  `source_path` TEXT        NOT NULL,
  `target_path` TEXT        NOT NULL,
  `type`        VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cstudio_dependency_site_idx` (`site`),
  KEY `cstudio_dependency_sourcepath_idx` (`source_path`(255))
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE `cstudio_objectstate` (
  `object_id`         VARCHAR(255)  NOT NULL,
  `site`              VARCHAR(50)   NOT NULL,
  `path`              VARCHAR(2000) NOT NULL,
  `state`             VARCHAR(255)  NOT NULL,
  `system_processing` BIT(1)        NOT NULL,
  PRIMARY KEY (`object_id`),
  KEY `cstudio_objectstate_object_idx` (`object_id`)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE `cstudio_pagenavigationordersequence` (
  `folder_id` VARCHAR(100) NOT NULL,
  `site`      VARCHAR(50)  NOT NULL,
  `path`      VARCHAR(255) NOT NULL,
  `max_count` FLOAT        NOT NULL,
  PRIMARY KEY (`folder_id`),
  KEY `cstudio_pagenavigationorder_folder_idx` (`folder_id`)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE `cstudio_copytoenvironment` (
  `id`               BIGINT       NOT NULL AUTO_INCREMENT,
  `site`             VARCHAR(50)  NOT NULL,
  `environment`      VARCHAR(20)  NOT NULL,
  `path`             TEXT         NOT NULL,
  `oldpath`          TEXT         NULL,
  `username`         VARCHAR(255) NULL,
  `scheduleddate`    DATETIME     NOT NULL,
  `state`            VARCHAR(50)  NOT NULL,
  `action`           VARCHAR(20)  NOT NULL,
  `contenttypeclass` VARCHAR(20)  NULL,
  PRIMARY KEY (`id`),
  INDEX `cstudio_cte_site_idx` (`site` ASC),
  INDEX `cstudio_cte_environment_idx` (`environment` ASC),
  INDEX `cstudio_cte_path_idx` (`path`(250) ASC),
  INDEX `cstudio_cte_sitepath_idx` (`site` ASC, `path`(250) ASC),
  INDEX `cstudio_cte_state_idx` (`state` ASC)
);

CREATE TABLE `cstudio_publishtotarget` (
  `id`               BIGINT       NOT NULL AUTO_INCREMENT,
  `site`             VARCHAR(50)  NOT NULL,
  `environment`      VARCHAR(20)  NOT NULL,
  `path`             TEXT         NOT NULL,
  `oldpath`          TEXT         NULL,
  `username`         VARCHAR(255) NOT NULL,
  `version`          BIGINT       NOT NULL,
  `action`           VARCHAR(20)  NOT NULL,
  `contenttypeclass` VARCHAR(20)  NULL,
  PRIMARY KEY (`id`),
  INDEX `cstudio_ptt_site_idx` (`site` ASC),
  INDEX `cstudio_ptt_environment_idx` (`environment` ASC),
  INDEX `cstudio_ptt_path` (`path`(250) ASC),
  INDEX `cstudio_ptt_sitepath_idx` (`site` ASC, `path`(250) ASC)
);

CREATE TABLE `cstudio_deploymentsynchistory` (
  `id`               BIGINT       NOT NULL AUTO_INCREMENT,
  `syncdate`         DATETIME     NOT NULL,
  `site`             VARCHAR(50)  NOT NULL,
  `environment`      VARCHAR(20)  NOT NULL,
  `path`             TEXT         NOT NULL,
  `target`           VARCHAR(50)  NOT NULL,
  `username`         VARCHAR(255) NOT NULL,
  `contenttypeclass` VARCHAR(25)  NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cs_depsynchist_site_idx` (`site` ASC),
  INDEX `cs_depsynchist_env_idx` (`environment` ASC),
  INDEX `cs_depsynchist_path_idx` (`path`(250) ASC),
  INDEX `cs_depsynchist_sitepath_idx` (`site` ASC, `path`(250) ASC),
  INDEX `cs_depsynchist_target_idx` (`target` ASC),
  INDEX `cs_depsynchist_user_idx` (`username` ASC),
  INDEX `cs_depsynchist_ctc_idx` (`contenttypeclass` ASC)
);