CREATE SCHEMA `bookworm-db` ;

CREATE TABLE `billing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` int NOT NULL,
  `action` varchar(45) NOT NULL,
  `rent_id` int DEFAULT NULL,
  `lend_id` int DEFAULT NULL,
  `created_at` bigint NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKndrwyfu0qwotr8tab3619volc` (`book_id`),
  KEY `FKe79v509uw95dv80hes0bjkxjw` (`lend_id`),
  KEY `FKnv7ulx38pk2rxv3x65raemwr4` (`rent_id`),
  CONSTRAINT `FKe79v509uw95dv80hes0bjkxjw` FOREIGN KEY (`lend_id`) REFERENCES `lend` (`id`),
  CONSTRAINT `FKndrwyfu0qwotr8tab3619volc` FOREIGN KEY (`book_id`) REFERENCES `ebooks` (`id`),
  CONSTRAINT `FKnv7ulx38pk2rxv3x65raemwr4` FOREIGN KEY (`rent_id`) REFERENCES `rent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `action` varchar(45) NOT NULL,
  `rent_duration` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3peguacwbax49ny8hv8ptie0n` (`book_id`),
  CONSTRAINT `FK3peguacwbax49ny8hv8ptie0n` FOREIGN KEY (`book_id`) REFERENCES `ebooks` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ebooks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `booktitle` varchar(120) NOT NULL,
  `category` varchar(100) NOT NULL,
  `subcategory` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `publisher` varchar(200) NOT NULL,
  `author` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `availability` varchar(10) NOT NULL,
  `actions` varchar(300) NOT NULL,
  `img` blob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `booktitle_UNIQUE` (`booktitle`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `lend` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `package_id` int NOT NULL,
  `end_date` bigint NOT NULL,
  `created_at` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiurjv2lhsup5ck3tm856ashm8` (`book_id`),
  CONSTRAINT `FKiurjv2lhsup5ck3tm856ashm8` FOREIGN KEY (`book_id`) REFERENCES `ebooks` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `package` (
  `id` int NOT NULL AUTO_INCREMENT,
  `package_name` varchar(45) NOT NULL,
  `no_of_days` int NOT NULL,
  `no_of_books` int NOT NULL,
  `lend_amount` double NOT NULL,
  `user_id` int NOT NULL,
  `end_date` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `rent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `start_date` bigint NOT NULL,
  `end_date` bigint NOT NULL,
  `rent_amount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email_id` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `password` varchar(110) NOT NULL,
  `occupation` varchar(100) NOT NULL,
  `professional_domain` varchar(100) NOT NULL,
  `contact` varchar(45) NOT NULL,
  `address` varchar(500) NOT NULL,
  `user_type` int NOT NULL,
  `img` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emailId_UNIQUE` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;