-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2023 at 11:55 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `COURSE_ID` int(11) NOT NULL,
  `CODE` varchar(10) NOT NULL,
  `TITLE` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `PASSING_GRADE` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`COURSE_ID`, `CODE`, `TITLE`, `DESCRIPTION`, `PASSING_GRADE`) VALUES
(1, 'CS1321', 'Programming and Problem Solving I', 'This course is centered around learning the basics of programming and foundational concepts of programming.', 'B'),
(2, 'CS1322', 'Programming and Problem Solving II', 'This course flushes through OOP, Exception Handling, JavaFX, Genetic Programming and Files.', 'B'),
(3, 'ECON2106', 'Principle of Microeconomics', 'In this course, we study the Macro and Micro activities and forces in an economy.', 'B'),
(4, 'MATH1113', 'Precalculus', 'In this course, we study the basics of Mathematics.', 'C'),
(5, 'CS3305', 'Data Structure', 'In this course, we study advance concepts of programming such as data structures in order to improve performance of codes. ', 'B'),
(6, 'ENGL1101', 'Composition I', 'In this course, we study elements of English language essential for good communication and writing.', 'B');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `LOGIN_ID` int(11) NOT NULL,
  `REG_NO` varchar(10) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`LOGIN_ID`, `REG_NO`, `PASSWORD`) VALUES
(1, 'ket103', '934385f53d1bd0c1b8493e44d0dfd4c8e88a04bb');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `STU_ID` int(11) NOT NULL,
  `REF_NO` varchar(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `BIRTHDAY` date NOT NULL,
  `PHONE` varchar(10) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`STU_ID`, `REF_NO`, `NAME`, `BIRTHDAY`, `PHONE`, `ADDRESS`) VALUES
(1, '22S007', 'Ketsia Noumbo', '2003-11-01', '697890482', 'Omnisport'),
(2, '22S011', 'Saint Seiya', '2003-01-02', '645321578', 'Emana Pont'),
(3, '22S020', 'Chaina Marine', '2002-12-04', '697890482', 'Omnisport'),
(4, '22S015', 'Felix Hyuga', '2003-05-04', '645321578', 'Emana Pont');

-- --------------------------------------------------------

--
-- Table structure for table `student_course`
--

CREATE TABLE `student_course` (
  `COURSE_ID` int(11) NOT NULL,
  `STU_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`COURSE_ID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`LOGIN_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`STU_ID`);

--
-- Indexes for table `student_course`
--
ALTER TABLE `student_course`
  ADD KEY `student_course_ibfk_1` (`COURSE_ID`),
  ADD KEY `student_course_ibfk_2` (`STU_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `COURSE_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `LOGIN_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `STU_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`COURSE_ID`),
  ADD CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`STU_ID`) REFERENCES `student` (`STU_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
