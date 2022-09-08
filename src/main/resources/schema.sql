CREATE TABLE `student` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `age` int(11) NOT NULL,
    `school_type` varchar(20) NOT NULL,
    `phone_number` varchar(13) NOT NULL,
    primary key (`id`)
);

CREATE TABLE `subject` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(12) NOT NULL,
    primary key (`id`)
);

CREATE TABLE `score` (
    `student_id` bigint(20) NOT NULL,
    `subject_id` bigint(20) NOT NULL,
    `score` int(11) NOT NULL,
    primary key (`student_id`,`subject_id`)
);
