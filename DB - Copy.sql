USE sliittimetable;

CREATE TABLE IF NOT EXISTS `building_block` (
  `bb_id` int(11) NOT NULL AUTO_INCREMENT,
  `building_block_name` varchar(45) DEFAULT NULL,
  `location_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`bb_id`),
  KEY `fk_building_block_location1_idx` (`location_id`),
  CONSTRAINT `fk_building_block_location1` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.building_block: ~3 rows (approximately)
/*!40000 ALTER TABLE `building_block` DISABLE KEYS */;
INSERT INTO `building_block` (`bb_id`, `building_block_name`, `location_id`, `status`) VALUES
	(5, 'B502', 4, 1),
	(6, 'A501', 4, 1),
	(7, 'N3B-PcLab', 1, 1);
/*!40000 ALTER TABLE `building_block` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.center
CREATE TABLE IF NOT EXISTS `center` (
  `center_id` int(11) NOT NULL,
  `center_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`center_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.center: ~6 rows (approximately)
/*!40000 ALTER TABLE `center` DISABLE KEYS */;
INSERT INTO `center` (`center_id`, `center_name`) VALUES
	(1, 'Malabe'),
	(2, 'Metro'),
	(3, 'Matara'),
	(4, 'Kandy'),
	(5, 'Kurunagala'),
	(6, 'Jaffna');
/*!40000 ALTER TABLE `center` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.days
CREATE TABLE IF NOT EXISTS `days` (
  `day_id` int(11) NOT NULL AUTO_INCREMENT,
  `day_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`day_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.days: ~5 rows (approximately)
/*!40000 ALTER TABLE `days` DISABLE KEYS */;
INSERT INTO `days` (`day_id`, `day_name`) VALUES
	(1, 'Monday'),
	(2, 'Tuesday'),
	(3, 'Wednesday'),
	(4, 'Thursday'),
	(5, 'Friday');
/*!40000 ALTER TABLE `days` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.faculty
CREATE TABLE IF NOT EXISTS `faculty` (
  `faculty_id` int(11) NOT NULL,
  `faculty_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.faculty: ~4 rows (approximately)
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (`faculty_id`, `faculty_name`) VALUES
	(1, 'Computing'),
	(2, 'Engineering'),
	(3, 'Business'),
	(4, 'Humanities & Sciences');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.lecturer
CREATE TABLE IF NOT EXISTS `lecturer` (
  `employee_id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `faculty_id` int(11) NOT NULL,
  `center_id` int(11) NOT NULL,
  `levels_id` int(11) NOT NULL,
  `building` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `fk_lecturer_faculty_idx` (`faculty_id`),
  KEY `fk_lecturer_center1_idx` (`center_id`),
  KEY `fk_lecturer_levels1_idx` (`levels_id`),
  KEY `fk_lecturer_location1_idx` (`building`),
  CONSTRAINT `fk_lecturer_center1` FOREIGN KEY (`center_id`) REFERENCES `center` (`center_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lecturer_faculty` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lecturer_levels1` FOREIGN KEY (`levels_id`) REFERENCES `levels` (`levels_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lecturer_location1` FOREIGN KEY (`building`) REFERENCES `location` (`location_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.lecturer: ~2 rows (approximately)
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` (`employee_id`, `name`, `department`, `faculty_id`, `center_id`, `levels_id`, `building`, `status`) VALUES
	('000001', 'Dr. Nuwan Kodagoda', 'IT', 2, 2, 2, 4, 1),
	('000002', 'Ms. Hansi Mayadunna', 'Engineering', 2, 2, 1, 3, 1);
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.lecturer_has_session
CREATE TABLE IF NOT EXISTS `lecturer_has_session` (
  `lecturer_has_session_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(45) NOT NULL,
  `session_id` int(11) NOT NULL,
  `status_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`lecturer_has_session_id`),
  KEY `fk_lecturer_has_session_session1_idx` (`session_id`),
  KEY `fk_lecturer_has_session_lecturer1_idx` (`employee_id`),
  CONSTRAINT `fk_lecturer_has_session_lecturer1` FOREIGN KEY (`employee_id`) REFERENCES `lecturer` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lecturer_has_session_session1` FOREIGN KEY (`session_id`) REFERENCES `session` (`session_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.lecturer_has_session: ~9 rows (approximately)
/*!40000 ALTER TABLE `lecturer_has_session` DISABLE KEYS */;
INSERT INTO `lecturer_has_session` (`lecturer_has_session_id`, `employee_id`, `session_id`, `status_id`) VALUES
	(21, '000001', 22, 1),
	(23, '000002', 22, 1);
/*!40000 ALTER TABLE `lecturer_has_session` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.levels
CREATE TABLE IF NOT EXISTS `levels` (
  `levels_id` int(11) NOT NULL,
  `level_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`levels_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.levels: ~7 rows (approximately)
/*!40000 ALTER TABLE `levels` DISABLE KEYS */;
INSERT INTO `levels` (`levels_id`, `level_name`) VALUES
	(1, 'Professor '),
	(2, 'Assistant Professor '),
	(3, 'Senior Lecturer(HG) '),
	(4, 'Senior Lecturer '),
	(5, 'Lecturer '),
	(6, 'Assistant Lecturer '),
	(7, 'Instructors');
/*!40000 ALTER TABLE `levels` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.location
CREATE TABLE IF NOT EXISTS `location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `building_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.location: ~4 rows (approximately)
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`location_id`, `building_name`) VALUES
	(1, 'New building'),
	(2, 'D-block'),
	(3, 'A-block'),
	(4, 'C-block');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.programme
CREATE TABLE IF NOT EXISTS `programme` (
  `programme_id` int(11) NOT NULL AUTO_INCREMENT,
  `programme_name` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`programme_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.programme: ~4 rows (approximately)
/*!40000 ALTER TABLE `programme` DISABLE KEYS */;
INSERT INTO `programme` (`programme_id`, `programme_name`, `status`) VALUES
	(1, 'ad', 0),
	(2, 'IT', 1),
	(3, 'IM', 1),
	(4, 'CSS', 1);
/*!40000 ALTER TABLE `programme` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.semester
CREATE TABLE IF NOT EXISTS `semester` (
  `semester_id` int(11) NOT NULL AUTO_INCREMENT,
  `semester` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`semester_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.semester: ~8 rows (approximately)
/*!40000 ALTER TABLE `semester` DISABLE KEYS */;
INSERT INTO `semester` (`semester_id`, `semester`, `status`) VALUES
	(1, 'Y1.S1', 1),
	(2, 'Y1.S2', 1),
	(3, 'Y2.S1', 1),
	(4, 'Y2.S2', 1),
	(5, 'Y3.S1', 1),
	(6, 'Y3.S2', 1),
	(7, 'Y4.S1', 1),
	(8, 'Y4.S2', 1);
/*!40000 ALTER TABLE `semester` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.session
CREATE TABLE IF NOT EXISTS `session` (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `no_of_students` int(11) DEFAULT NULL,
  `working_day_management_has_days_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `building_block_bb_id` int(11) NOT NULL,
  PRIMARY KEY (`session_id`),
  KEY `fk_session_subject1_idx` (`subject_id`),
  KEY `fk_session_tag1_idx` (`tag_id`),
  KEY `fk_session_student1_idx` (`student_id`),
  KEY `fk_session_building_block1_idx` (`building_block_bb_id`),
  KEY `fk_session_working_day_management_has_days1_idx` (`working_day_management_has_days_id`),
  CONSTRAINT `fk_session_building_block1` FOREIGN KEY (`building_block_bb_id`) REFERENCES `building_block` (`bb_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_session_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_session_subject1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_session_tag1` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_session_working_day_management_has_days1` FOREIGN KEY (`working_day_management_has_days_id`) REFERENCES `working_day_management_has_days` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.session: ~7 rows (approximately)
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` (`session_id`, `no_of_students`, `working_day_management_has_days_id`, `subject_id`, `tag_id`, `student_id`, `status`, `building_block_bb_id`) VALUES
	(22, 10, 66, 1, 10, 6, 1, 5);
/*!40000 ALTER TABLE `session` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.student
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `academic_year` varchar(45) DEFAULT NULL,
  `group_no` varchar(45) DEFAULT NULL,
  `sub_group_no` varchar(45) DEFAULT NULL,
  `group_id` varchar(45) DEFAULT NULL,
  `sub_group_id` varchar(45) DEFAULT NULL,
  `faculty_id` int(11) NOT NULL,
  `semester_id` int(11) NOT NULL,
  `programme_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `fk_student_faculty1_idx` (`faculty_id`),
  KEY `fk_student_semester_id1_idx` (`semester_id`),
  KEY `fk_student_programme1_idx` (`programme_id`),
  CONSTRAINT `fk_student_faculty1` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_programme1` FOREIGN KEY (`programme_id`) REFERENCES `programme` (`programme_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_semester_id1` FOREIGN KEY (`semester_id`) REFERENCES `semester` (`semester_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.student: ~9 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`student_id`, `academic_year`, `group_no`, `sub_group_no`, `group_id`, `sub_group_id`, `faculty_id`, `semester_id`, `programme_id`, `status`) VALUES
	(1, '111', '2', '4', 'Sem 1.ad.2', 'Sem 1.ad.2.4', 1, 1, 1, 0),
	(2, '1', '1', '1', 'Sem 2.ad.1', 'Sem 2.ad.1.1', 2, 2, 1, 0),
	(3, '2020', '01', '02', 'Y1.S1.IT.01', 'Y1.S1.IT.01.02', 2, 1, 2, 0),
	(4, '2025', '01', '05', 'Y1.S1.CSS.01', 'Y1.S1.CSS.01.05', 1, 1, 4, 0),
	(5, '2022', '01', '05', 'Y1.S2.CSS.01', 'Y1.S2.CSS.01.05', 2, 3, 4, 0),
	(6, '2020', '01', '01', 'Y1.S1.IT.01', 'Y1.S1.IT.01.01', 1, 1, 2, 1),
	(7, '2020', '01', '02', 'Y1.S1.IT.01', 'Y1.S1.IT.01.02', 1, 1, 2, 1),
	(8, '2020', '01', '01', 'Y1.S2.IT.01', 'Y1.S2.IT.01.01', 1, 2, 2, 1),
	(9, '2020', '01', '01', 'Y1.S2.IM.01', 'Y1.S2.IM.01.01', 3, 2, 3, 1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.subject
CREATE TABLE IF NOT EXISTS `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) DEFAULT NULL,
  `subject_code` varchar(45) DEFAULT NULL,
  `no_of_lec_hours` varchar(45) DEFAULT NULL,
  `no_of_tu_hours` varchar(45) DEFAULT NULL,
  `no_of_lab_hours` varchar(45) DEFAULT NULL,
  `no_of_eva_hours` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `semester_id` int(11) NOT NULL,
  `year` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `fk_subject_semester1_idx` (`semester_id`),
  CONSTRAINT `fk_subject_semester1` FOREIGN KEY (`semester_id`) REFERENCES `semester` (`semester_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.subject: ~3 rows (approximately)
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` (`subject_id`, `subject_name`, `subject_code`, `no_of_lec_hours`, `no_of_tu_hours`, `no_of_lab_hours`, `no_of_eva_hours`, `status`, `semester_id`, `year`) VALUES
	(1, 'IM', 'IM2020-IM', '2', '1', '1', '1', 1, 2, 1),
	(6, 'IT', 'IT1040-CS', '3', '1', '1', '1', 1, 1, 1),
	(7, 'OOP', 'IE2021-OOP', '1', '1', '1', '1', 1, 3, 2);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.tag
CREATE TABLE IF NOT EXISTS `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.tag: ~3 rows (approximately)
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` (`tag_id`, `tag_name`, `status`) VALUES
	(10, 'Lecture', 1),
	(11, 'Tutorial', 1),
	(12, 'Practical', 1);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.working_day_management
CREATE TABLE IF NOT EXISTS `working_day_management` (
  `wdm_id` int(11) NOT NULL AUTO_INCREMENT,
  `working_time_per_day` varchar(45) DEFAULT NULL,
  `starting_time` varchar(45) DEFAULT NULL,
  `ending_time` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `working_days` int(11) DEFAULT NULL,
  PRIMARY KEY (`wdm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.working_day_management: ~8 rows (approximately)
/*!40000 ALTER TABLE `working_day_management` DISABLE KEYS */;
INSERT INTO `working_day_management` (`wdm_id`, `working_time_per_day`, `starting_time`, `ending_time`, `status`, `working_days`) VALUES
	(27, '5', '8:30 AM', '9:30 AM', 1, 5),
	(28, '5', '9:30 AM', '10:30 AM', 1, 5),
	(29, '5', '10:30 AM', '11:00 AM', 1, 5),
	(30, '5', '11:30 AM', '12:30 AM', 1, 5),
	(31, '5', '12:30 AM', '1:30 PM', 1, 5),
	(32, '5', '1:30 PM', '2:30 PM', 1, 5),
	(33, '5', '3:30 PM', '4:30 PM', 1, 5),
	(34, '5', '4:30 PM', '5:00 PM', 1, 5);
/*!40000 ALTER TABLE `working_day_management` ENABLE KEYS */;

-- Dumping structure for table sliit_timetable.working_day_management_has_days
CREATE TABLE IF NOT EXISTS `working_day_management_has_days` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `working_day_management_wdm_id` int(11) NOT NULL,
  `days_day_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_working_day_management_has_days_days1_idx` (`days_day_id`),
  KEY `fk_working_day_management_has_days_working_day_management1_idx` (`working_day_management_wdm_id`),
  CONSTRAINT `fk_working_day_management_has_days_days1` FOREIGN KEY (`days_day_id`) REFERENCES `days` (`day_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_working_day_management_has_days_working_day_management1` FOREIGN KEY (`working_day_management_wdm_id`) REFERENCES `working_day_management` (`wdm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- Dumping data for table sliit_timetable.working_day_management_has_days: ~40 rows (approximately)
/*!40000 ALTER TABLE `working_day_management_has_days` DISABLE KEYS */;
INSERT INTO `working_day_management_has_days` (`id`, `working_day_management_wdm_id`, `days_day_id`) VALUES
	(66, 27, 1),
	(67, 27, 2),
	(68, 27, 3),
	(69, 27, 4),
	(70, 27, 5),
	(71, 28, 1),
	(72, 28, 2),
	(73, 28, 3),
	(74, 28, 4),
	(75, 28, 5),
	(76, 29, 1),
	(77, 29, 2),
	(78, 29, 3),
	(79, 29, 4),
	(80, 29, 5),
	(81, 30, 1),
	(82, 30, 2),
	(83, 30, 3),
	(84, 30, 4),
	(85, 30, 5),
	(86, 31, 1),
	(87, 31, 2),
	(88, 31, 3),
	(89, 31, 4),
	(90, 31, 5),
	(91, 32, 1),
	(92, 32, 2),
	(93, 32, 3),
	(94, 32, 4),
	(95, 32, 5),
	(96, 33, 1),
	(97, 33, 2),
	(98, 33, 3),
	(99, 33, 4),
	(100, 33, 5),
	(101, 34, 1),
	(102, 34, 2),
	(103, 34, 3),
	(104, 34, 4),
	(105, 34, 5);
