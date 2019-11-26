/*
 Navicat MySQL Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : pblog

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 26/11/2019 18:32:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_publish` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_category` int(11) NOT NULL,
  `book_price` double(11, 2) NULL DEFAULT NULL,
  `book_introduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_num` int(2) NOT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `book_category`(`book_category`) USING BTREE,
  INDEX `book_name`(`book_name`) USING BTREE,
  CONSTRAINT `book_category` FOREIGN KEY (`book_category`) REFERENCES `book_category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '巨人的陨落', '肯.福莱特', '江苏凤凰文艺出版社', 1, 129.00, '在第一次世界大战中发生的故事', 2);
INSERT INTO `book` VALUES (2, '三体', '刘慈欣', '南京大学出版社', 1, 68.00, '科幻小说', 2);
INSERT INTO `book` VALUES (3, '复活', '列夫.托尔斯泰', '上海译文出版社', 1, 19.00, '俄国小说', 3);
INSERT INTO `book` VALUES (6, '平凡的世界', '路遥', '上海文艺出版社', 1, 88.00, '孙少平和孙少安两兄弟...', 0);
INSERT INTO `book` VALUES (15, '白鹿原', '陈忠实', '南京出版社', 1, 36.00, '当代小说', 2);
INSERT INTO `book` VALUES (16, '计算机网络', '谢希仁', '电子工业出版社', 3, 49.00, '计算机专业书籍', 2);
INSERT INTO `book` VALUES (17, '霍乱时期的爱情', '加西亚·马尔克斯', '译林出版社', 9, 39.00, '外国小说', 2);
INSERT INTO `book` VALUES (18, '天才在左疯子在右', '高铭', '北京联合出版公司', 1, 39.80, '心理学', 3);
INSERT INTO `book` VALUES (19, '废都', '贾平凹', '商务印书馆', 8, 29.00, '当代小说', 1);
INSERT INTO `book` VALUES (20, 'jQuery', 'Ryan', '中国电力出版社', 3, 78.00, 'js库', 4);

-- ----------------------------
-- Table structure for book_category
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_category
-- ----------------------------
INSERT INTO `book_category` VALUES (1, '小说');
INSERT INTO `book_category` VALUES (2, '历史');
INSERT INTO `book_category` VALUES (3, '计算机');
INSERT INTO `book_category` VALUES (4, '哲学');
INSERT INTO `book_category` VALUES (5, '社会科学');
INSERT INTO `book_category` VALUES (6, '政治法律');
INSERT INTO `book_category` VALUES (7, '军事科学');
INSERT INTO `book_category` VALUES (8, '中国文学');
INSERT INTO `book_category` VALUES (9, '外国文学');
INSERT INTO `book_category` VALUES (10, '外国传记');
INSERT INTO `book_category` VALUES (11, '英语');
INSERT INTO `book_category` VALUES (12, '俄国小说');
INSERT INTO `book_category` VALUES (13, '心理学');
INSERT INTO `book_category` VALUES (14, '言情小说');
INSERT INTO `book_category` VALUES (15, '武侠小说');
INSERT INTO `book_category` VALUES (16, '环境科学');
INSERT INTO `book_category` VALUES (17, '纪实文学');
INSERT INTO `book_category` VALUES (18, '机械');
INSERT INTO `book_category` VALUES (20, 'JAVA');
INSERT INTO `book_category` VALUES (21, '电气');
INSERT INTO `book_category` VALUES (25, 'SAD');

-- ----------------------------
-- Table structure for borrowingbooks
-- ----------------------------
DROP TABLE IF EXISTS `borrowingbooks`;
CREATE TABLE `borrowingbooks`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrow_date` date NOT NULL,
  `return_data` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `p_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowingbooks
-- ----------------------------
INSERT INTO `borrowingbooks` VALUES (3, 1, 15, '2019-11-07', '2019-11-17');
INSERT INTO `borrowingbooks` VALUES (9, 5, 1, '2018-10-16', NULL);
INSERT INTO `borrowingbooks` VALUES (24, 1, 6, '2018-10-30', NULL);
INSERT INTO `borrowingbooks` VALUES (25, 6, 18, '2018-10-31', NULL);
INSERT INTO `borrowingbooks` VALUES (26, 1, 2, '2018-10-31', '2019-11-25');
INSERT INTO `borrowingbooks` VALUES (28, 5, 19, '2018-11-03', '2019-11-25');
INSERT INTO `borrowingbooks` VALUES (29, 11, 17, '2018-11-04', NULL);
INSERT INTO `borrowingbooks` VALUES (32, 2, 20, '2019-11-25', '2019-11-25');
INSERT INTO `borrowingbooks` VALUES (33, 2, 18, '2019-11-25', '2019-11-25');
INSERT INTO `borrowingbooks` VALUES (34, 2, 2, '2019-11-25', '2019-11-25');
INSERT INTO `borrowingbooks` VALUES (35, 2, 1, '2019-11-25', NULL);
INSERT INTO `borrowingbooks` VALUES (36, 2, 2, '2019-11-25', NULL);
INSERT INTO `borrowingbooks` VALUES (37, 1, 18, '2019-11-25', '2019-11-25');

-- ----------------------------
-- Table structure for p_admin
-- ----------------------------
DROP TABLE IF EXISTS `p_admin`;
CREATE TABLE `p_admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_admin
-- ----------------------------
INSERT INTO `p_admin` VALUES (1, 'admin', 'root', '666@qq.com');

-- ----------------------------
-- Table structure for p_user
-- ----------------------------
DROP TABLE IF EXISTS `p_user`;
CREATE TABLE `p_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_sno` int(11) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_sno`(`user_sno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_user
-- ----------------------------
INSERT INTO `p_user` VALUES (1, '设定', '123456', 3166);
INSERT INTO `p_user` VALUES (2, 'adasd', '123456', 3167);
INSERT INTO `p_user` VALUES (5, '李四', '123456', 12312);
INSERT INTO `p_user` VALUES (6, 'LeBronJames', '123456', 1546);
INSERT INTO `p_user` VALUES (7, '科比', '123456', 454);
INSERT INTO `p_user` VALUES (8, '柏拉图', '123456', 145);
INSERT INTO `p_user` VALUES (9, '拿破仑', '123456', 1543);
INSERT INTO `p_user` VALUES (10, '欧文', '123456', 74545);
INSERT INTO `p_user` VALUES (11, '库兹马', '123456', 11176);
INSERT INTO `p_user` VALUES (12, '545', '124554', 123);
INSERT INTO `p_user` VALUES (13, '魔术师1', '123456', 454512);
INSERT INTO `p_user` VALUES (16, '周杰伦', '123456', 879);
INSERT INTO `p_user` VALUES (18, 'bin', '123456', 4545);
INSERT INTO `p_user` VALUES (19, 'test', '123456', 111);
INSERT INTO `p_user` VALUES (20, 'user', '123456', 3177);
INSERT INTO `p_user` VALUES (21, 'user', '123456', 3179);
INSERT INTO `p_user` VALUES (22, 'user', '123456', 3180);
INSERT INTO `p_user` VALUES (23, 'user', '123456', 3181);
INSERT INTO `p_user` VALUES (31, '飞机开发', '123456', 6362);
INSERT INTO `p_user` VALUES (32, 'eqe', '213442', 3242);
INSERT INTO `p_user` VALUES (36, '烟霭茫茫', '123456', 2355);
INSERT INTO `p_user` VALUES (37, '等会', '123456', 31456);

SET FOREIGN_KEY_CHECKS = 1;
