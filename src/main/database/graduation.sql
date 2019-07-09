/*
Navicat MySQL Data Transfer

Source Server         : tcm
Source Server Version : 50641
Source Host           : 127.0.0.1:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-04-28 17:19:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for disease
-- ----------------------------
DROP TABLE IF EXISTS `disease`;
CREATE TABLE `disease` (
  `disease_id` varchar(255) NOT NULL,
  `disease_type_id` varchar(255) DEFAULT NULL,
  `disease_name` varchar(255) DEFAULT NULL,
  `disease_reason` varchar(255) DEFAULT NULL,
  `disease_describe` varchar(255) DEFAULT NULL,
  `disease_symptom_id` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`disease_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disease
-- ----------------------------
INSERT INTO `disease` VALUES ('1', '1', '咳嗽病', '肺部病变或风寒', '咳嗽不止', '1', '1');
INSERT INTO `disease` VALUES ('2', '2', '吐血病', '胃热壅盛，肝郁化火，或心脾气虚，血失统御而成', '血从口中吐出', '1', '1');
INSERT INTO `disease` VALUES ('3', '3', '白秃疮病', '白秃疮多由相互直接接触传染而致；或因脾胃湿热内蕴，湿盛则瘙痒流汁，热盛则生风生燥，肌肤失养，以致皮生白屑、头发焦枯脱落而成', '头皮生白屑、头发脱落成秃疮为临床特征的皮肤癣菌感染性疾病', '1', '1');
INSERT INTO `disease` VALUES ('4', '4', '月经先期病', '指月经周期提前7天以上，甚至10余天一行，连续3个周期以上者', '为气虚和血热。气虚则统摄无权，冲任不固；血热则热扰冲任，伤及胞宫，血海不宁，均可使月经先期而至', '1', '1');

-- ----------------------------
-- Table structure for disease_type
-- ----------------------------
DROP TABLE IF EXISTS `disease_type`;
CREATE TABLE `disease_type` (
  `disease_type_id` varchar(255) NOT NULL,
  `disease_classify` varchar(255) DEFAULT NULL,
  `disease_type_name` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`disease_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disease_type
-- ----------------------------
INSERT INTO `disease_type` VALUES ('1', '内部病变', '内科疾病', '1');
INSERT INTO `disease_type` VALUES ('2', '外部创伤', '外科疾病', '1');
INSERT INTO `disease_type` VALUES ('3', '妇女疾病', '妇科疾病', '1');
INSERT INTO `disease_type` VALUES ('4', '儿童病症', '儿科疾病', '1');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `medicine_id` varchar(255) NOT NULL,
  `medicine_type_id` varchar(255) DEFAULT NULL,
  `medicine_name` varchar(255) DEFAULT NULL,
  `medicine_describe` varchar(255) DEFAULT NULL,
  `medicine_efficacy` varchar(255) DEFAULT NULL,
  `medicine_image` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('1', '1', '银柴胡', '多年生草本。株高20～40厘米，密被腺毛或柔毛', '清虚热，除疳热。属收涩药下属分类的敛肺涩肠药。', 'images/1.jag', '1');
INSERT INTO `medicine` VALUES ('2', '2', '麻黄', '小灌木，植株高70～100厘米，木质茎粗长，直立，上部多分枝；小枝较细，节间较短，通常为1.5～2.5厘米', '发汗散寒、宣肺平喘、利水消肿。属解表药下属分类的辛温解表药。', 'images/2.jag', '1');
INSERT INTO `medicine` VALUES ('3', '3', '大黄', '多年生高大草本。根状茎及根部肥厚，黄褐色', '泻热通便、凉血解毒、逐瘀通经。属泻下药下属分类的攻下药', 'images/3.jag', '1');
INSERT INTO `medicine` VALUES ('4', '4', '炙甘草', '多年生草本，高30～100cm。根及根茎粗壮，皮红棕色', '补脾和胃，益气复脉。属补虚药下分类的补气药', 'images/4.jag', '1');

-- ----------------------------
-- Table structure for medicine_type
-- ----------------------------
DROP TABLE IF EXISTS `medicine_type`;
CREATE TABLE `medicine_type` (
  `medicine_type_id` varchar(255) NOT NULL,
  `medicine_type_name` varchar(255) DEFAULT NULL,
  `medicine_classify` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`medicine_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine_type
-- ----------------------------
INSERT INTO `medicine_type` VALUES ('1', '清热药', '凡药性寒凉,以清泄里热为主要作用的药物,称为清热药', '1');
INSERT INTO `medicine_type` VALUES ('2', '解表药', '凡能疏肌解表、促使发汗，用以发散表邪、解除表证的药物，称为解表药', '1');
INSERT INTO `medicine_type` VALUES ('3', '泻下药', ' 凡能攻积、逐水,引起腹泻,或润肠通便的药物,称为泻下药', '1');
INSERT INTO `medicine_type` VALUES ('4', '补虚药', '以提高抵抗疾病能力为目的,具有补充人体气血阴阳之不足、消除机体虚弱证候、改善脏腑功能、增强体质的功效,治疗各种虚证的药物,称为补虚药', '1');

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `prescription_id` varchar(255) NOT NULL,
  `prescription_name` varchar(255) DEFAULT NULL,
  `prescription_med_id` varchar(255) DEFAULT NULL,
  `prescription_describe` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`prescription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES ('1', '炙甘草汤', '4', '主治.阴血不足，阳气虚弱证脉结代，心动悸，虚赢少气，舌光少苔，或质干而瘦小', '1');

-- ----------------------------
-- Table structure for symptom
-- ----------------------------
DROP TABLE IF EXISTS `symptom`;
CREATE TABLE `symptom` (
  `symptom_id` varchar(255) NOT NULL,
  `symptom_name` varchar(255) DEFAULT NULL,
  `symptom_tec_id` varchar(255) DEFAULT NULL,
  `symptom_pre_id` varchar(255) DEFAULT NULL,
  `symptom_med_id` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`symptom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of symptom
-- ----------------------------
INSERT INTO `symptom` VALUES ('1', '气虚', '1', '1', '4', '1');

-- ----------------------------
-- Table structure for technology
-- ----------------------------
DROP TABLE IF EXISTS `technology`;
CREATE TABLE `technology` (
  `technology_id` varchar(255) NOT NULL,
  `technology_type_id` varchar(255) DEFAULT NULL,
  `technology_name` varchar(255) DEFAULT NULL,
  `technology_describe` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`technology_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of technology
-- ----------------------------
INSERT INTO `technology` VALUES ('1', '1', '皮部经筋推拿技术', '以按法、揉法、擦法、法等手法作用于全身各部体表，刺激皮部（包括皮肤、皮下组织）、经筋（包括筋膜、肌肉、韧带、关节囊等组织），使皮部受到良性刺激或使经筋张力发生改变的推拿医疗技术。', '1');
INSERT INTO `technology` VALUES ('2', '2', '穴位贴敷技术', '以中医经络学说为理论依据，把药物研成细末，用水、醋、酒、蛋清、蜂蜜、植物油、清凉油、药液甚至唾液调成糊状，或用呈凝固状的油脂（如凡士林等）、黄醋、米饭、枣泥制成软膏、丸剂或饼剂，或将中药汤剂熬成膏，或将药末散于膏药上，再直接贴敷穴位、患处（阿是穴），用来治疗疾病的一种无创痛穴位疗法', '1');
INSERT INTO `technology` VALUES ('3', '3', '药浴技术', '沐浴前在水中“加料”亦有助促进健康，例如加入适量白酒、白醋等，可清洁身体及消除疲劳，更能治疗痔疮、便秘及有助增强性能力', '1');

-- ----------------------------
-- Table structure for technology_type
-- ----------------------------
DROP TABLE IF EXISTS `technology_type`;
CREATE TABLE `technology_type` (
  `technology_type_id` varchar(255) NOT NULL,
  `technology_type_name` varchar(255) DEFAULT NULL,
  `technology_classify` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`technology_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of technology_type
-- ----------------------------
INSERT INTO `technology_type` VALUES ('1', '推拿类', '运用手法和一定工具作用于患者体表固定部位或穴位，达到疏通经络，行气活血的目的', '1');
INSERT INTO `technology_type` VALUES ('2', '敷熨类', '将药物或其他物体热熨或冷敷于患者体表，借助药性或温度，时气血流通。', '1');
INSERT INTO `technology_type` VALUES ('3', '熏浴类', '利用药物在患处进行熏蒸，淋洗，达到脉络调和', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_account` varchar(11) NOT NULL,
  `user_age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_rank` int(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  `user_gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11', '11', '11', '2', '11', '1', '男');
INSERT INTO `user` VALUES ('aa', '18', '123', '2', 'aa', '1', '男');
INSERT INTO `user` VALUES ('admin', '18', 'admin', '1', '张仲景', '1', '男');
INSERT INTO `user` VALUES ('jm', '18', 'admin', '2', 'jm', '1', '男');
INSERT INTO `user` VALUES ('jx', '18', '123', '2', 'admin', '1', '男');
INSERT INTO `user` VALUES ('jz', '18', 'admin', '2', '习风', '1', '女');
INSERT INTO `user` VALUES ('mm', '18', 'mm', '2', 'm\'m', '1', '女');
INSERT INTO `user` VALUES ('tt', '18', 'tt', '2', 'tt', '1', '女');
