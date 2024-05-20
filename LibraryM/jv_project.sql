-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2022 at 06:25 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jv_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE IF NOT EXISTS `author` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `name`, `description`) VALUES
(1, 'Dan Brown', NULL),
(2, 'Arthur Conan Doyle', NULL),
(3, 'Paulo Coelho', ''),
(4, 'Verene Bearns', NULL),
(5, 'Angeline Severy', NULL),
(6, 'Tim Gregorace', NULL),
(7, 'Benjamen Jedrysik', NULL),
(8, 'Izzy Doumerc', NULL),
(9, 'Erminia Sexon', NULL),
(10, 'Wiley Mattock', NULL),
(11, 'Vilma Vondruska', NULL),
(12, 'Anthony Darrigoe', NULL),
(13, 'Zelda Daintier', NULL),
(14, 'Lizzie Jankiewicz', NULL),
(15, 'Emelda Brahan', NULL),
(16, 'Xena Foxon', NULL),
(17, 'Hatty Purchall', NULL),
(18, 'Lanie Aspy', NULL),
(19, 'Paige Leyden', NULL),
(20, 'Hermia Portt', NULL),
(21, 'Steven K.Scott', '');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `lang_id` int(11) NOT NULL,
  `edition` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `publish_year` int(11) NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `created_date` date NOT NULL,
  `created_user` int(11) NOT NULL,
  `updated_date` date NOT NULL,
  `updated_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `title`, `lang_id`, `edition`, `quantity`, `status`, `publish_year`, `description`, `created_date`, `created_user`, `updated_date`, `updated_user`) VALUES
(1, 'Sherlock Holmes', 1, 1, 5, 1, 2010, '', '2022-05-05', 1, '2022-05-05', 1),
(2, 'Simple step to impossible dream', 3, 1, 6, 1, 2016, '', '2022-05-05', 1, '2022-05-05', 1),
(3, 'Lost symbol', 3, 1, 4, 1, 2018, '', '2022-05-05', 1, '2022-05-05', 1),
(4, 'The Alchemist', 3, 1, 8, 1, 2010, '', '2022-05-05', 1, '2022-05-05', 1);

-- --------------------------------------------------------

--
-- Table structure for table `book_author`
--

CREATE TABLE IF NOT EXISTS `book_author` (
`id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book_author`
--

INSERT INTO `book_author` (`id`, `book_id`, `author_id`) VALUES
(1, 1, 2),
(2, 3, 1),
(3, 4, 3),
(4, 2, 21);

-- --------------------------------------------------------

--
-- Table structure for table `book_category`
--

CREATE TABLE IF NOT EXISTS `book_category` (
`id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book_category`
--

INSERT INTO `book_category` (`id`, `book_id`, `category_id`) VALUES
(1, 1, 2),
(2, 1, 14),
(3, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE IF NOT EXISTS `book_details` (
`id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `sku_code` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `price` double NOT NULL,
  `status` tinyint(4) NOT NULL,
  `created_date` date NOT NULL,
  `created_user` int(11) NOT NULL,
  `updated_date` date NOT NULL,
  `updated_user` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`id`, `book_id`, `sku_code`, `price`, `status`, `created_date`, `created_user`, `updated_date`, `updated_user`) VALUES
(15, 1, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(16, 1, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(17, 1, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(18, 1, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(19, 1, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(20, 2, '90%', 10000, 1, '2022-05-05', 1, '2022-05-18', 2),
(21, 2, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(22, 2, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(23, 2, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(24, 2, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(25, 2, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(26, 3, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(27, 3, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(28, 3, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(29, 3, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(30, 4, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(31, 4, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(32, 4, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(33, 4, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(34, 4, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(35, 4, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(36, 4, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1),
(37, 4, '100%', 10000, 1, '2022-05-05', 1, '2022-05-05', 1);

-- --------------------------------------------------------

--
-- Table structure for table `book_publisher`
--

CREATE TABLE IF NOT EXISTS `book_publisher` (
`id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `publisher_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `description`) VALUES
(1, 'Textbook', NULL),
(2, 'Novel', NULL),
(3, 'Reference ', 'sach tham khao'),
(4, 'Comic', 'truyen tranh'),
(5, 'Hardcover', 'sach bia cung'),
(6, 'Paperback', 'sach bia mem'),
(7, 'Exercise ', 'sach bai tap\r\n'),
(8, 'Magazine', 'tap chi'),
(9, 'Dictionary', 'tu dien'),
(10, 'Short story', NULL),
(11, 'Science fiction', 'Khoa hoc vien tuong'),
(12, 'Myth', 'truyen thuyet'),
(13, 'Fairy tail', 'truyen co tich'),
(14, 'Detective', 'trinh tham'),
(15, 'Thriller', NULL),
(16, 'Nonfiction', NULL),
(17, 'Funny', NULL),
(18, 'Fable', 'ngu ngon');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL,
  `avatar` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `address` text COLLATE utf8_unicode_ci,
  `created_date` date NOT NULL,
  `created_user` int(11) NOT NULL,
  `updated_date` date DEFAULT NULL,
  `updated_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `avatar`, `name`, `phone`, `birthday`, `gender`, `status`, `address`, `created_date`, `created_user`, `updated_date`, `updated_user`) VALUES
(1, 'C:\\Users\\Uygi\\Documents\\NetBeansProjects\\JavaProjectAT\\src\\img\\reader\\68318846_100420854655127_1902385343479414784_n.jpg', 'Pham Quang Huy', '0934212346', '1998-07-21', 1, 1, 'dfvdf', '2022-05-01', 1, '2022-05-05', 1),
(2, 'C:\\Users\\Uygi\\Documents\\NetBeansProjects\\JavaProjectAT\\src\\img\\reader\\null', 'Nguyen Minh Hai', '09374627364', '1994-05-19', 1, 1, 'dsfsfdfv dfd', '2022-05-05', 1, '2022-05-18', 2),
(3, 'C:\\Users\\Uygi\\Documents\\NetBeansProjects\\JavaProjectAT\\src\\img\\reader\\2.png', 'Nguyen Thi A', '091273847563', '1998-05-18', 0, 1, 'ssvdfv', '2022-05-02', 1, '2022-05-05', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL,
  `avatar` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `full_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `address` text COLLATE utf8_unicode_ci,
  `status` tinyint(4) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `avatar`, `user_name`, `password`, `full_name`, `phone`, `birthday`, `gender`, `address`, `status`, `start_date`, `end_date`) VALUES
(1, 'C:\\Users\\Uygi\\Documents\\NetBeansProjects\\JavaProjectAT\\src\\img\\staff\\5093882.jpg', 'uygisan', '112233', 'Pham quang huy', '22222', '2022-05-01', 1, 'dfdf', 1, '2022-05-01', '2022-05-17'),
(2, 'C:\\Users\\Uygi\\Documents\\NetBeansProjects\\JavaProjectAT\\src\\img\\staff\\68318846_100420854655127_1902385343479414784_n.jpg', 'MHai', '112233', 'Nguyen Minh Hai', '0948573625', '2022-05-01', 1, 'asdcasd', 1, '2022-05-01', '2022-05-01'),
(3, 'C:\\Users\\Uygi\\Documents\\NetBeansProjects\\JavaProjectAT\\src\\img\\staff\\3.jpg', 'cnguyen', '112233', 'nguyen cao nguyen', '04958372634', '2022-05-01', 1, 'sdcdsf', 1, '2022-05-01', '2022-05-17');

-- --------------------------------------------------------

--
-- Table structure for table `employee_role`
--

CREATE TABLE IF NOT EXISTS `employee_role` (
`id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `languages`
--

CREATE TABLE IF NOT EXISTS `languages` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `languages`
--

INSERT INTO `languages` (`id`, `name`) VALUES
(1, 'English\r\n'),
(2, 'Vietnamese'),
(3, 'English + Vietnamese'),
(4, 'Japanese\r\n'),
(5, 'German'),
(6, 'Frances');

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE IF NOT EXISTS `publisher` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`id`, `name`, `description`) VALUES
(1, 'Shirl Lenahan', NULL),
(2, 'Nikolos Senescall', NULL),
(3, 'Jillayne O''Noland', NULL),
(4, 'Ardath Iacapucci', NULL),
(5, 'Gail Stopps', NULL),
(6, 'Raviv Belly', NULL),
(7, 'Annalee Jaggi', NULL),
(8, 'Lorne Koppel', NULL),
(9, 'Milena Syres', NULL),
(10, 'Fax Higford', NULL),
(11, 'Judon Vernau', NULL),
(12, 'Melvyn Duncan', NULL),
(13, 'Ellary Hanne', NULL),
(14, 'Pietra Rymell', NULL),
(15, 'Issiah Hassewell', NULL),
(16, 'Retha Rock', NULL),
(17, 'Camel Lister', NULL),
(18, 'Jasmina Bunworth', NULL),
(19, 'Tad Muttock', NULL),
(20, 'Nicolas Housley', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `punish`
--

CREATE TABLE IF NOT EXISTS `punish` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `punish`
--

INSERT INTO `punish` (`id`, `name`, `description`) VALUES
(0, 'Normal', NULL),
(1, 'Lost book', 'Books price'),
(2, 'Late', '10k/day\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE IF NOT EXISTS `transactions` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `total_price` double NOT NULL,
  `status` tinyint(4) NOT NULL,
  `due_date` date NOT NULL,
  `pay_date` date NOT NULL,
  `created_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`id`, `customer_id`, `employee_id`, `total_price`, `status`, `due_date`, `pay_date`, `created_date`) VALUES
(1, 2, 1, 2000, 1, '2022-05-12', '2022-05-12', '2022-05-05'),
(2, 1, 3, 142000, 1, '2022-05-04', '2022-05-21', '2022-05-05');

-- --------------------------------------------------------

--
-- Table structure for table `transactions_details`
--

CREATE TABLE IF NOT EXISTS `transactions_details` (
`id` int(11) NOT NULL,
  `book_details_id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `punish_id` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `transactions_details`
--

INSERT INTO `transactions_details` (`id`, `book_details_id`, `transaction_id`, `punish_id`, `price`) VALUES
(17, 20, 1, 0, 1000),
(18, 18, 1, 0, 1000),
(19, 15, 2, 0, 1000),
(20, 30, 2, 0, 1000),
(21, 15, 2, 2, 140000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_bid4` (`lang_id`);

--
-- Indexes for table `book_author`
--
ALTER TABLE `book_author`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `fk_bid1` (`book_id`), ADD KEY `fk_aid` (`author_id`);

--
-- Indexes for table `book_category`
--
ALTER TABLE `book_category`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_bid2` (`book_id`), ADD KEY `fk_catid` (`category_id`);

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_book_id` (`book_id`);

--
-- Indexes for table `book_publisher`
--
ALTER TABLE `book_publisher`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_bid3` (`book_id`), ADD KEY `fk_pubid` (`publisher_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee_role`
--
ALTER TABLE `employee_role`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_emp_id1` (`employee_id`), ADD KEY `fk_reole_id` (`role_id`);

--
-- Indexes for table `languages`
--
ALTER TABLE `languages`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `punish`
--
ALTER TABLE `punish`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_emp_id` (`employee_id`), ADD KEY `fk_cus_id` (`customer_id`);

--
-- Indexes for table `transactions_details`
--
ALTER TABLE `transactions_details`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_tran_id` (`transaction_id`), ADD KEY `fk_bdid` (`book_details_id`), ADD KEY `fk_pid` (`punish_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_author`
--
ALTER TABLE `book_author`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `book_category`
--
ALTER TABLE `book_category`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `book_details`
--
ALTER TABLE `book_details`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT for table `book_publisher`
--
ALTER TABLE `book_publisher`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee_role`
--
ALTER TABLE `employee_role`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transactions_details`
--
ALTER TABLE `transactions_details`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
ADD CONSTRAINT `fk_bid4` FOREIGN KEY (`lang_id`) REFERENCES `languages` (`id`);

--
-- Constraints for table `book_author`
--
ALTER TABLE `book_author`
ADD CONSTRAINT `fk_aid` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
ADD CONSTRAINT `fk_bid1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Constraints for table `book_category`
--
ALTER TABLE `book_category`
ADD CONSTRAINT `fk_bid2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
ADD CONSTRAINT `fk_catid` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `book_details`
--
ALTER TABLE `book_details`
ADD CONSTRAINT `fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Constraints for table `book_publisher`
--
ALTER TABLE `book_publisher`
ADD CONSTRAINT `fk_bid3` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
ADD CONSTRAINT `fk_pubid` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`);

--
-- Constraints for table `employee_role`
--
ALTER TABLE `employee_role`
ADD CONSTRAINT `fk_emp_id1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
ADD CONSTRAINT `fk_reole_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
ADD CONSTRAINT `fk_cus_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
ADD CONSTRAINT `fk_emp_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `transactions_details`
--
ALTER TABLE `transactions_details`
ADD CONSTRAINT `fk_bdid` FOREIGN KEY (`book_details_id`) REFERENCES `book_details` (`id`),
ADD CONSTRAINT `fk_pid` FOREIGN KEY (`punish_id`) REFERENCES `punish` (`id`),
ADD CONSTRAINT `fk_tran_id` FOREIGN KEY (`transaction_id`) REFERENCES `transactions` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
