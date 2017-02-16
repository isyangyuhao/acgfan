-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2017-02-16 09:21:56
-- 服务器版本： 10.1.10-MariaDB
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `acg`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `work` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`, `work`, `role_id`) VALUES
(1, 'admin', 'a1dd4958efe425a235ba5e128527676b', '您是顶级管理员,可以为其他管理员分配任务', 1),
(2, 'admin2', 'bc3969ee4f8b7412b0b383769bbb8b8c', '您暂时没有工作任务...', 2),
(3, 'admin3', 'f0101301bb564a3f5d0a0ad3ef9168e7', '您暂时没有工作任务...', 3),
(4, 'admin4', '716704a3ed62d558517bfd5d2439776e', '您暂时没有工作任务...', 4),
(5, 'admin5', 'd213d271bd9ede90db53d831b37892e2', '您暂时没有工作任务...', 5),
(6, 'admin6', '792b30413fefbe71b328eb4cda8cac7c', '您暂时没有工作任务...', 6);

-- --------------------------------------------------------

--
-- 表的结构 `bar`
--

CREATE TABLE `bar` (
  `id` int(11) NOT NULL,
  `position` varchar(255) DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bar`
--

INSERT INTO `bar` (`id`, `position`, `src`) VALUES
(1, 'index', 'photo/index/bar.png'),
(2, 'myself', 'photo/account/myself_bar.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `danmu`
--

CREATE TABLE `danmu` (
  `id` int(11) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `danmu`
--

INSERT INTO `danmu` (`id`, `color`, `position`, `size`, `text`, `time`, `video_id`) VALUES
(19, '#ffffff', 0, 1, '第一个收藏我收下了', 28, 75),
(20, '#ffffff', 0, 1, '999因为6翻了', 43, 75),
(21, 'orange', 1, 1, '生个弟弟压各个专门过来瞎眼', 60, 75),
(22, '#ffffff', 0, 1, '233333333', 87, 75),
(23, '#ffffff', 0, 1, '66666666', 87, 75),
(24, '#ffffff', 0, 1, '好强', 141, 75),
(25, 'pink', 1, 1, '专门过来瞎眼', 16, 75),
(26, '#ffffff', 0, 1, '第三', 46, 75),
(27, '#ffffff', 0, 1, '德玛西亚', 105, 75),
(28, '#ffffff', 0, 1, '好清晰', 201, 75),
(29, 'green', 1, 1, '介绍膜的破不及防', 201, 75),
(30, '#ffffff', 0, 1, 'up主每个都是精品啊', 197, 75),
(31, '#ffffff', 0, 1, '2333333', 249, 75),
(32, '#ffffff', 0, 1, '开头方了', 141, 75),
(33, 'red', 2, 1, '竟然可以支持弹幕了！！！', 15, 75),
(34, '#ffffff', 0, 1, '开头好有钱', 192, 75),
(35, '#ffffff', 0, 1, '哈哈哈哈哈', 231, 75),
(36, '#ffffff', 2, 1, '画风突变啊', 262, 75),
(37, '#ffffff', 0, 1, '金坷垃2333333', 331, 75),
(38, '#ffffff', 0, 1, '开口跪', 288, 75),
(39, '#ffffff', 0, 1, '该来的还是来了', 370, 75),
(40, '#ffffff', 0, 1, '我是开字幕了吗', 457, 75),
(41, '#ffffff', 0, 1, '太好听了', 567, 75),
(42, '#ffffff', 0, 1, '太魔性了', 593, 75),
(44, '#ffffff', 0, 1, '第五', 701, 75),
(45, 'green', 2, 1, '第一名前来报到', 701, 75),
(46, '#ffffff', 0, 1, '必须顶两袋撒！', 708, 75),
(47, 'red', 1, 1, '闷声施大肥+1', 456, 75),
(48, '#ffffff', 0, 1, '没有金坷垃让我们怎么种庄稼啊！！！', 1095, 75),
(49, 'red', 2, 1, '圣地亚哥1', 100, 75),
(50, 'red', 2, 1, '圣地亚哥2', 120, 75),
(51, 'red', 2, 1, '圣地亚哥3', 140, 75),
(52, '#ffffff', 0, 1, '啦啦啦啦啦', 319, 75),
(54, '#ffffff', 0, 1, 'hahahaha', 91, 75),
(55, '#ffffff', 0, 1, 'lalalal', 128, 75),
(63, '#ffffff', 0, 1, 'lalala', 232, 75),
(64, '#ffffff', 0, 1, '23333', 166, 75);

-- --------------------------------------------------------

--
-- 表的结构 `filter_map_config`
--

CREATE TABLE `filter_map_config` (
  `id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `filter_map_config`
--

INSERT INTO `filter_map_config` (`id`, `role`, `url`) VALUES
(1, 'logout', 'admin-logout'),
(2, 'authc', 'admin-users-ajax'),
(3, 'authc', 'admin-videoType-ajax'),
(4, 'authc', 'admin-updateVideoType-ajax'),
(5, 'authc', 'admin-friendLinks-ajax'),
(6, 'authc', 'admin-updateFriendLink-ajax'),
(7, 'authc', 'video-videos-ajax'),
(8, 'authc', 'video-addVideo-ajax'),
(9, 'authc', 'video-updateVideo-ajax'),
(10, 'authc', 'video-deleteVideo-ajax'),
(11, 'authc', 'video-indexShow-ajax'),
(12, 'authc', 'video-updateIndexShow-ajax'),
(13, 'authc', 'video-videoShow-ajax'),
(14, 'authc', 'video-updateVideoShow-ajax'),
(15, 'authc', 'video-videoComment-ajax'),
(16, 'authc', 'video-deleteVideoComment-ajax'),
(17, 'authc', 'video-danmu-ajax'),
(18, 'authc', 'video-deleteDanmu-ajax'),
(19, 'authc', 'other-goods-ajax'),
(20, 'authc', 'other-addGoods-ajax'),
(21, 'authc', 'other-updateGoods-ajax'),
(22, 'authc', 'other-deleteGoods-ajax'),
(23, 'authc', 'other-game-ajax'),
(24, 'authc', 'other-updateGame-ajax'),
(25, 'authc', 'other-gameIntroduce-ajax'),
(26, 'authc', 'other-addGameIntroduce-ajax'),
(27, 'authc', 'other-updateGameIntroduce-ajax'),
(28, 'authc', 'other-deleteGameIntroduce-ajax'),
(29, 'authc', 'other-palette-ajax'),
(30, 'authc', 'other-deletePalette-ajax'),
(31, 'authc', 'other-admin-ajax'),
(32, 'authc', 'other-addAdmin-ajax'),
(33, 'authc', 'other-updateAdminRole-ajax'),
(34, 'authc', 'other-updateAdminWork-ajax'),
(35, 'authc', 'other-deleteAdmin-ajax');

-- --------------------------------------------------------

--
-- 表的结构 `friend_link`
--

CREATE TABLE `friend_link` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `src` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `friend_link`
--

INSERT INTO `friend_link` (`id`, `name`, `src`) VALUES
(1, '哔哩哔哩动画', 'http://www.bilibili.com/'),
(2, 'AcFun动画网', 'http://www.acfun.tv/'),
(3, 'Bootstrap中文网', 'http://www.bootcss.com/'),
(4, '有字库', 'http://www.youziku.com/'),
(5, 'AngularJS中文网', 'http://www.apjs.net/'),
(6, 'Spring', 'http://spring.io/');

-- --------------------------------------------------------

--
-- 表的结构 `game`
--

CREATE TABLE `game` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `game`
--

INSERT INTO `game` (`id`, `name`, `src`, `title`) VALUES
(1, '与你相约《少女前线》', 'photo/game/img_gameCenter/6.jpg', '就决定是你了呢，指挥官！'),
(2, '《神代梦华谭》预约进行中', 'photo/game/img_gameCenter/7.jpg', '《神代梦华谭》预约进行中');

-- --------------------------------------------------------

--
-- 表的结构 `game_introduce`
--

CREATE TABLE `game_introduce` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `game_introduce`
--

INSERT INTO `game_introduce` (`id`, `name`, `type_id`) VALUES
(1, '命运-冠位指定', 1),
(2, '幻影纹章', 1),
(3, '仙境传说RO', 1),
(4, '影之刃2 ', 1),
(5, '妖精的衣橱', 1),
(6, '魔法禁书目录', 1),
(7, '神代梦华谭', 1),
(8, '幻游猎人', 1),
(9, '魔法少女小圆', 1),
(10, '造物法则 ', 1),
(11, 'ICHU偶像进行曲', 2),
(12, '螺旋境界线 ', 2),
(13, '少女前线', 2),
(14, '天天打波利', 2),
(15, '偶像梦幻祭', 2),
(16, '刀剑神域黑衣剑士', 2),
(17, '乖离性百万亚瑟王', 2),
(18, '战场双马尾', 2),
(19, '克鲁赛德战记', 2),
(20, '崩坏3', 2),
(21, '那兔之大国梦 ', 2),
(22, '大航海之路 ', 2),
(23, '妖刀少女异闻录', 2),
(24, '少女咖啡枪', 2),
(25, '剑侠世界', 2),
(26, '阴阳师', 2),
(27, '战舞幻想曲', 2),
(28, '苍之骑士团', 2),
(29, '魔法学园 ', 2),
(30, '梦王国与沉睡的100王子', 2),
(31, '崩坏学园2', 2),
(32, '幻想战姬', 2),
(33, '三国罗曼史', 2),
(34, '暴风战舰', 2),
(35, '皇牌机娘', 2),
(36, '装甲联盟', 2),
(37, '如果的世界', 2),
(38, 'Zion载音', 2),
(39, '九十九姬', 3),
(40, '像素骑士团', 3),
(41, '射击少女', 3);

-- --------------------------------------------------------

--
-- 表的结构 `game_show`
--

CREATE TABLE `game_show` (
  `id` int(11) NOT NULL,
  `src` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `game_show`
--

INSERT INTO `game_show` (`id`, `src`) VALUES
(1, 'photo/game/img_gameCenter/1.jpg'),
(2, 'photo/game/img_gameCenter/2.jpg'),
(3, 'photo/game/img_gameCenter/3.jpg'),
(4, 'photo/game/img_gameCenter/4.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `goods`
--

CREATE TABLE `goods` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo_desc` varchar(255) DEFAULT NULL,
  `photo_more` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `stock` int(11) NOT NULL,
  `goods_type` int(11) DEFAULT NULL,
  `buy_src` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `goods`
--

INSERT INTO `goods` (`id`, `name`, `photo_desc`, `photo_more`, `price`, `stock`, `goods_type`, `buy_src`) VALUES
(1, '小电视天线卫衣 连帽休闲拼接卫衣', 'photo/shop/img_zhoubian/goods1.png', '#', 199, 50, NULL, 'http://bmall.bilibili.com/#!/detail/176'),
(2, '机械之心休闲连帽卫衣', 'photo/shop/img_zhoubian/goods2.png', '#', 233, 47, NULL, 'http://bmall.bilibili.com/#!/detail/135'),
(3, '蓝色lazy连帽卫衣外套 秋季休闲拉链', 'photo/shop/img_zhoubian/goods3.png', '#', 233, 76, NULL, 'http://bmall.bilibili.com/#!/detail/169'),
(4, '黑色lazy连帽卫衣 休闲拉链外套', 'photo/shop/img_zhoubian/goods4.png', '#', 233, 71, NULL, 'http://bmall.bilibili.com/#!/detail/165'),
(5, '梦王国和沉睡的100王子iPhone6/6P', 'photo/shop/img_zhoubian/goods5.png', '#', 79, 120, NULL, 'http://bmall.bilibili.com/#!/detail/141'),
(6, '梦王国和沉睡的王子碎牙随行水杯', 'photo/shop/img_zhoubian/goods6.png', '#', 79, 117, NULL, 'http://bmall.bilibili.com/#!/detail/152'),
(7, '梦王国和沉睡的100王子6/6sp', 'photo/shop/img_zhoubian/goods7.png', '#', 79, 120, NULL, 'http://bmall.bilibili.com/#!/detail/153'),
(8, '白色节奏痛包 透明痛包帆布单肩', 'photo/shop/img_zhoubian/goods8.png', '#', 89, 100, NULL, 'http://bmall.bilibili.com/#!/detail/115'),
(9, '梦王国与沉睡的100王子马口铁徽章', 'photo/shop/img_zhoubian/goods9.png', '#', 155, 300, NULL, 'http://bmall.bilibili.com/#!/detail/104'),
(10, '黑色节奏痛包 透明痛包帆布单肩', 'photo/shop/img_zhoubian/goods10.png', '#', 209, 150, NULL, 'http://bmall.bilibili.com/#!/detail/116'),
(11, '外交官合作款环球萌动万向轮拉杆箱', 'photo/shop/img_zhoubian/goods11.png', '#', 599, 50, NULL, 'http://bmall.bilibili.com/#!/detail/133'),
(12, '外交官合作款小电视旅行万向轮箱', 'photo/shop/img_zhoubian/goods12.png', '#', 599, 50, NULL, 'http://bmall.bilibili.com/#!/detail/149');

-- --------------------------------------------------------

--
-- 表的结构 `goods_type`
--

CREATE TABLE `goods_type` (
  `id` int(11) NOT NULL,
  `type_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `indent`
--

CREATE TABLE `indent` (
  `id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `money` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `post` int(11) NOT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `index_show`
--

CREATE TABLE `index_show` (
  `id` int(11) NOT NULL,
  `src` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `index_show`
--

INSERT INTO `index_show` (`id`, `src`, `title`) VALUES
(1, 'photo/index/index_show/show1-1.jpg', '正版新番,动画修炼! 第7话'),
(2, 'photo/index/index_show/show1-2.jpg', '好多..好多想玩儿的游戏,钱包君撑住'),
(3, 'photo/index/index_show/show1-3.jpg', '沉迷番外,无法自拔');

-- --------------------------------------------------------

--
-- 表的结构 `palette`
--

CREATE TABLE `palette` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `well` int(11) DEFAULT NULL,
  `palette_type` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `palette`
--

INSERT INTO `palette` (`id`, `name`, `well`, `palette_type`, `user_id`, `create_time`, `src`) VALUES
(1, '森林遗迹', 0, 1, 2, '2016-11-24 21:30:00', 'photo/palette/h1.png'),
(2, 'Mirror Night', 0, 2, 3, '2016-11-15 18:33:00', 'photo/palette/h2.jpg'),
(3, '冲凉', 0, 3, 4, '2016-11-25 16:06:00', 'photo/palette/h3.png'),
(4, '天空宫殿', 0, 3, 5, '2016-11-25 20:33:00', 'photo/palette/h4.png'),
(5, '不可思议的街道', 0, 2, 6, '2016-11-24 20:33:00', 'photo/palette/h5.png'),
(6, '你的名字', 0, 1, 7, '2015-06-01 13:36:00', 'photo/palette/h6.png'),
(7, '女巫天使', 0, 2, 8, '2016-05-01 15:54:00', 'photo/palette/h7.jpg'),
(8, '许愿瓶', 0, 3, 9, '2016-11-30 16:30:00', 'photo/palette/h8.png'),
(9, '影之刃', 0, 1, 10, '2016-11-03 21:41:00', 'photo/palette/h9.jpg'),
(10, '圣诞 Saber Alter', 0, 1, 11, '2016-10-01 16:19:00', 'photo/palette/h10.png'),
(11, 'Saber', 0, 3, 12, '2016-11-24 20:11:00', 'photo/palette/n1.jpg'),
(12, 'Saber Alter', 0, 2, 13, '2016-10-29 01:00:00', 'photo/palette/n2.jpg'),
(13, '尼禄', 0, 3, 14, '2016-11-30 17:29:00', 'photo/palette/n3.jpg'),
(14, 'Saber Lily', 0, 1, 15, '2016-11-25 14:01:00', 'photo/palette/n4.jpg'),
(15, '塞尔达传说', 0, 2, 16, '2016-11-12 14:01:01', 'photo/palette/t1.jpg'),
(16, '奥丁领域 女武神', 0, 2, 17, '2016-09-10 22:17:00', 'photo/palette/t2.png'),
(17, '某原创作品', 0, 1, 18, '2016-11-30 00:30:00', 'photo/palette/t3.jpg'),
(18, '棉被Saber。。', 0, 3, 19, '2014-11-27 22:16:00', 'photo/palette/t4.jpg'),
(19, '夏娜', 0, 3, 20, '2016-11-24 13:17:00', 'photo/palette/t5.jpeg'),
(20, '猫耳初音', 0, 1, 21, '2016-11-30 21:33:00', 'photo/palette/t6.jpeg'),
(21, '雪初音', 0, 2, 15, '2016-11-10 21:30:00', 'photo/palette/t7.png'),
(22, '最终幻想', 0, 1, 14, '2016-11-15 00:37:00', 'photo/palette/t8.jpg'),
(23, '迷之女主角X', 0, 2, 13, '2015-05-06 14:28:00', 'photo/palette/t9.png'),
(24, '士兵76', 0, 3, 12, '2016-11-30 18:11:00', 'photo/palette/t10.jpg'),
(25, '幼儿源。。', 0, 2, 11, '2015-01-06 08:51:00', 'photo/palette/t11.jpg'),
(26, '冲田总司', 0, 3, 10, '2016-11-28 18:01:00', 'photo/palette/t12.png'),
(27, '卫宫士郎', 0, 1, 9, '2015-03-04 21:49:00', 'photo/palette/t13.jpg'),
(28, '幽灵公主', 0, 1, 8, '2016-11-24 19:26:00', 'photo/palette/t14.jpg'),
(29, '兵长。。', 0, 3, 7, '2016-11-27 15:40:00', 'photo/palette/t15.jpg'),
(30, '基拉帝纳', 0, 2, 6, '2016-11-25 20:42:00', 'photo/palette/t16.jpg'),
(31, 'Persona 5', 0, 3, 5, '2016-11-28 01:56:00', 'photo/palette/t17.jpg'),
(32, 'D.Va', 0, 2, 4, '2016-07-25 07:15:00', 'photo/palette/t18.png'),
(33, '小美', 0, 1, 3, '2016-04-14 17:05:00', 'photo/palette/t19.png'),
(34, '傀儡师', 0, 1, 2, '2014-10-04 12:35:00', 'photo/palette/t20.jpg'),
(35, '草总', 0, 3, 17, '2016-11-25 22:29:00', 'photo/palette/t21.jpg'),
(36, '初音', 0, 2, 16, '2016-11-24 12:03:00', 'photo/palette/t22.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `palette_show`
--

CREATE TABLE `palette_show` (
  `id` int(11) NOT NULL,
  `src` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `palette_show`
--

INSERT INTO `palette_show` (`id`, `src`) VALUES
(1, 'photo/palette/carousel1.png'),
(2, 'photo/palette/carousel2.png'),
(3, 'photo/palette/carousel3.png');

-- --------------------------------------------------------

--
-- 表的结构 `palette_type`
--

CREATE TABLE `palette_type` (
  `id` int(11) NOT NULL,
  `type_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `palette_type`
--

INSERT INTO `palette_type` (`id`, `type_name`) VALUES
(1, '流行'),
(2, '热门'),
(3, '精品');

-- --------------------------------------------------------

--
-- 表的结构 `palette_user`
--

CREATE TABLE `palette_user` (
  `palette_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `permission`
--

CREATE TABLE `permission` (
  `id` int(11) NOT NULL,
  `permission_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `permission`
--

INSERT INTO `permission` (`id`, `permission_name`) VALUES
(1, 'user'),
(2, 'video'),
(3, 'shop'),
(4, 'game'),
(5, 'palette'),
(6, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `answer_a` varchar(255) DEFAULT NULL,
  `answer_b` varchar(255) DEFAULT NULL,
  `answer_c` varchar(255) DEFAULT NULL,
  `answer_d` varchar(255) DEFAULT NULL,
  `answer_right` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `question`
--

INSERT INTO `question` (`id`, `content`, `answer_a`, `answer_b`, `answer_c`, `answer_d`, `answer_right`) VALUES
(1, '复制UP主签名并发送弹幕会造成怎样结果?', 'A. 考试会100分', 'B. 会被系统禁言', 'C. 会中彩票', 'D. 自己帐号会变成VIP', 'B'),
(2, '当观看过程中有发现有恶意黑自己喜欢角色的弹幕时应该?', 'A. 去黑别的角色', 'B. 举报该弹幕', 'C. 打穿屏幕', 'D. 弹幕刷屏', 'B'),
(3, '在视频中版聊会怎样?', 'A. 瞬间爆炸', 'B. 生灵涂炭', 'C. 关闭视频', 'D. 遮挡屏幕影响别人观看', 'D'),
(4, '在做科普的过程中应当怎样?', 'A. 遮挡字幕', 'B. 有理有据', 'C. 引起战争', 'D. 涉及剧透', 'B'),
(5, '看排行类视频的时候,以下那种弹幕比较适宜?', 'A. 剧透第一名', 'B. xxx太低了', 'C. 讨论关注作品信息', 'D. 怎么没有xxx', 'C');

-- --------------------------------------------------------

--
-- 表的结构 `recommend`
--

CREATE TABLE `recommend` (
  `id` int(11) NOT NULL,
  `palette_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `recommend`
--

INSERT INTO `recommend` (`id`, `palette_id`) VALUES
(3, 3),
(1, 5),
(4, 7),
(2, 10),
(5, 12),
(7, 14),
(6, 16),
(8, 20),
(10, 27),
(9, 32);

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
(1, '顶级管理员'),
(2, '高级管理员'),
(3, '视频主站管理员'),
(4, '周边商城管理员'),
(5, '游戏中心管理员'),
(6, '画板管理员');

-- --------------------------------------------------------

--
-- 表的结构 `role_permission`
--

CREATE TABLE `role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `role_permission`
--

INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(3, 1),
(3, 2),
(4, 1),
(4, 3),
(5, 1),
(5, 4),
(6, 1),
(6, 5);

-- --------------------------------------------------------

--
-- 表的结构 `shop_show`
--

CREATE TABLE `shop_show` (
  `id` int(11) NOT NULL,
  `buy_src` varchar(255) DEFAULT NULL,
  `photo_src` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `shop_show`
--

INSERT INTO `shop_show` (`id`, `buy_src`, `photo_src`) VALUES
(1, 'https://bilibili2233.taobao.com/', 'photo/shop/img_zhoubian/zb1.png'),
(2, 'https://bilibili2233.taobao.com/', 'photo/shop/img_zhoubian/zb2.png');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `birth` date DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `dollar` int(11) NOT NULL,
  `icon` varchar(255) DEFAULT 'photo/account/user/default_icon.png',
  `introduce` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `birth`, `create_time`, `dollar`, `icon`, `introduce`, `password`, `sex`, `username`) VALUES
(1, '1996-04-18', '2016-11-18 18:49:00', 10, 'photo/account/user/icon_1.jpg', '我是传说中的测试用户...', '6e34fba5c0195da86e52ee88242f6202', 'm', 'root'),
(2, '2016-11-20', '2016-11-20 21:42:37', 10, 'photo/account/user/icon_2.jpg', '想要传送一封简讯给你，突然好想你', 'e2ed58279bc3fc4533d3d13d54a86963', 'm', 'Aki阿杰'),
(3, '2016-11-20', '2016-11-23 21:45:36', 10, 'photo/account/user/icon_3.jpg', '单曲循环，长白岛森林公园', '9de2e011fbf44997f18764c6466ee336', 'f', '风子'),
(4, '2016-11-20', '2016-10-20 21:45:36', 10, 'photo/account/user/icon_4.jpg', '大概最难的的就是这十几年来的陪伴', '7b1ffbd21c7a7695adc31bcd8710634c', 'f', 'Ho'),
(5, '2016-11-20', '2016-10-13 21:45:36', 10, 'photo/account/user/icon_5.jpg', '心塞，永远18', 'e13859700af19394284aa27d175833f2', 'm', '马思亚服老绅士'),
(6, '2016-11-20', '2016-11-20 22:45:36', 10, 'photo/account/user/icon_6.jpg', '该用户很懒,没有更新签名...', '083fcf649e798c9d84c747bb0b93d471', 'm', '我是西大高冷凡'),
(7, '2016-11-20', '2016-11-20 21:45:50', 10, 'photo/account/user/icon_7.jpg', 'de facto', 'dd44f8e755202e27f15dfc60df3bbd19', 'f', '无音'),
(8, '2016-11-20', '2016-11-11 21:45:36', 10, 'photo/account/user/icon_8.jpg', 'Why_So_Serious？', '75ba62139ca3e208b2e70fe01fcf232a', 'f', '微然心动'),
(9, '2016-11-20', '2016-11-12 21:45:36', 10, 'photo/account/user/icon_9.jpg', '战画中', 'a6aefc7b0a2a8aea85940e9b6a837265', 'm', '梦想飞啊飞'),
(10, '2016-11-20', '2016-11-20 08:45:36', 10, 'photo/account/user/icon_10.jpg', '  安河桥下的水', 'e6e022dab08240b5b020514bebf5fef0', 'm', '小猎'),
(11, '2016-11-20', '2016-11-20 21:10:36', 10, 'photo/account/user/icon_11.jpg', '该用户很懒,没有更新签名...', '520fce60bbc2bd1e06fdbf928ff94c88', 'f', '徐徐道来'),
(12, '2016-11-20', '2016-11-20 21:12:36', 10, 'photo/account/user/icon_12.jpg', '别撒谎别彷徨总有人喜欢你最糟的模样', '520fce60bbc2bd1e06fdbf928ff94c88', 'f', '陈婷婷'),
(13, '2016-11-20', '2016-11-20 21:45:24', 10, 'photo/account/user/icon_13.jpg', '我依然相信这个世界上还有爱情，只是我的那份，还在路上。', '3692785641725cee6ebb5cfb18fe9580', 'm', '大柠檬'),
(14, '2016-11-20', '2016-11-20 21:36:36', 10, 'photo/account/user/default_icon.png', '看着你们和他的消息记录，有种自己在跟他聊天的错觉', '7ffc6ec64d62f80f55064d937d62e7d8', 'm', '风吹雪'),
(15, '2016-11-20', '2016-11-20 21:47:36', 10, 'photo/account/user/icon_15.jpg', '该用户很懒,没有更新签名...', 'd010fde721c1660ecff29f533b151ee4', 'm', '时光荏苒'),
(16, '2016-11-20', '2016-11-20 21:45:47', 10, 'photo/account/user/icon_16.jpg', '爱生活！', 'a3b9bbd824e30f61835388524afd08f1', 'f', '明天'),
(17, '2016-11-20', '2016-11-20 21:31:36', 10, 'photo/account/user/icon_17.jpg', '该用户很懒,没有更新签名...', 'c53c36d52fdcd768b1f3d8d1292b18f1', 'm', '勺同学'),
(18, '2016-11-20', '2016-11-20 07:45:36', 10, 'photo/account/user/icon_18.jpg', '种菜专业户', '5bed814be7d4b8379a6a975e103908bb', 'm', '沉浮于世的微尘'),
(19, '2016-11-20', '2016-11-25 21:45:36', 10, 'photo/account/user/icon_19.jpg', '淡忘过去  给自己一个更好的以后。。。', '038e93f0f3c5825dcbd450dcae493aec', 'm', 'mix。'),
(20, '2016-11-20', '2016-11-21 21:45:36', 10, 'photo/account/user/icon_20.jpg', '你一走，带走了我生命里每一抹温暖的色调，剩下尽是晦涩不堪。', '62809dd1f638fe31055deea2eb195339', 'm', '勿放弃'),
(21, '2016-11-20', '2016-11-23 23:45:36', 10, 'photo/account/user/icon_21.jpg', '该用户很懒,没有更新签名...', '12a1d545a363c7d608a1b279f0f6519d', 'f', '中二病的猫');

-- --------------------------------------------------------

--
-- 表的结构 `video`
--

CREATE TABLE `video` (
  `id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `doloar` int(11) DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `src` varchar(255) NOT NULL,
  `video_type` int(11) DEFAULT NULL,
  `av_src` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `video`
--

INSERT INTO `video` (`id`, `create_time`, `doloar`, `name`, `src`, `video_type`, `av_src`) VALUES
(1, '2016-12-01 10:26:12', 0, '爱丽丝兔耳的思念于夏天离去的你', 'photo/index/index_t1/av1.png', 1, '#'),
(2, '2016-12-01 11:51:20', 0, '生来为王，何惧风雨！', 'photo/index/index_t1/av2.png', 1, '#'),
(3, '2016-12-01 10:17:19', 0, '祝你有一天能和你重要的人重逢', 'photo/index/index_t1/av3.png', 1, '#'),
(4, '2016-12-01 05:21:31', 0, '祝你有一天能和你重要的人重逢', 'photo/index/index_t1/av4.png', 1, '#'),
(5, '2016-12-01 10:19:32', 0, '泠鸢yousa-神的随波逐流', 'photo/index/index_t1/av5.png', 1, '#'),
(6, '2016-12-01 06:42:20', 0, '你没见过的神奇炸裂动画！', 'photo/index/index_t1/av6.png', 1, '#'),
(7, '2016-12-01 08:31:23', 0, '十道题来测试你是否资深动漫宅', 'photo/index/index_t1/av7.png', 1, '#'),
(8, '2016-12-01 07:35:45', 0, '鲁路修-魔神归来！', 'photo/index/index_t1/av8.png', 1, '#'),
(9, '2016-12-01 18:23:53', 0, '那些年，亲过小智的人们和精灵们', 'photo/index/index_t1/av9.png', 1, '#'),
(10, '2016-12-01 16:20:40', 0, '手书-Hide and Seek', 'photo/index/index_t1/av10.png', 1, '#'),
(11, '2016-12-01 13:13:27', 0, '爱即EROS--勇利花滑完整版', 'photo/index/index_t1/av11.png', 1, '#'),
(12, '2016-12-01 09:08:46', 0, '北京电影学院2016毕业联合作业 ', 'photo/index/index_t1/av12.png', 1, '#'),
(13, '2016-12-01 12:14:46', 0, '鱼爹约会女神，小僵尸沦为玩物！', 'photo/index/index_t1/av13.png', 1, '#'),
(14, '2016-12-01 08:44:15', 0, '最受欢迎 宫野真守', 'photo/index/index_t1/av14.png', 1, '#'),
(15, '2016-12-01 09:15:46', 0, '星二代柯南逆天开挂 吊打各路反派', 'photo/index/index_t1/av15.png', 1, '#'),
(16, '2016-12-01 20:27:44', 0, '画江湖之不良人番外篇 2 雨露均沾', 'photo/index/index_t1/av16.png', 1, '#'),
(17, '2016-12-01 09:24:36', 0, '天星传说,是奇总攻的传说！！！', 'photo/index/index_t2/av17.png', 2, '#'),
(18, '2016-12-01 06:41:59', 0, '人家是纯爷们儿，这次来个爷们儿的', 'photo/index/index_t2/av18.png', 2, '#'),
(19, '2016-12-01 10:32:24', 0, '黑白小巷（小少年ver）', 'photo/index/index_t2/av19.png', 2, '#'),
(20, '2016-12-01 12:24:46', 0, '乱躁滅裂女孩', 'photo/index/index_t2/av20.png', 2, '#'),
(21, '2016-12-01 07:13:54', 0, '峨眉—桜小狼', 'photo/index/index_t2/av21.png', 2, '#'),
(22, '2016-12-01 06:38:45', 0, '周二珂-童话镇', 'photo/index/index_t2/av22.png', 2, '#'),
(23, '2016-12-01 15:15:50', 0, '七里香【翻唱】', 'photo/index/index_t2/av23.png', 2, '#'),
(24, '2016-12-01 17:16:34', 0, '梦灯笼', 'photo/index/index_t2/av24.png', 2, '#'),
(25, '2016-12-01 23:22:39', 0, 'GACKT & Kamui Gakupo', 'photo/index/index_t2/av25.png', 2, '#'),
(26, '2016-12-01 19:26:51', 0, '春来发几枝', 'photo/index/index_t2/av26.png', 2, '#'),
(27, '2016-12-01 14:32:59', 0, 'Duang！！', 'photo/index/index_t2/av27.png', 2, '#'),
(28, '2016-12-01 12:32:46', 0, '未闻花名ed 十孔口琴', 'photo/index/index_t2/av28.png', 2, '#'),
(29, '2016-12-01 13:40:37', 0, 'Billboard加拿大单曲榜', 'photo/index/index_t2/av29.png', 2, '#'),
(30, '2016-12-01 08:14:38', 0, '2016年周冠单曲盘点', 'photo/index/index_t2/av30.png', 2, '#'),
(31, '2016-12-01 10:32:31', 0, '全员陪睡剧情', 'photo/index/index_t3/av31.png', 3, '#'),
(32, '2016-12-01 11:16:59', 0, '【古劍奇譚2】41-53回', 'photo/index/index_t3/av32.png', 3, '#'),
(33, '2016-12-01 08:43:23', 0, '恋爱忍法贴~雪月花恋绘卷', 'photo/index/index_t3/av33.png', 3, '#'),
(34, '2016-12-01 23:39:42', 0, '马里奥赛车7日常直播录像', 'photo/index/index_t3/av34.png', 3, '#'),
(35, '2016-12-01 12:42:26', 0, '遇到一刀能砍二十万血的五星妖刀姬', 'photo/index/index_t3/av35.png', 3, '#'),
(36, '2016-12-01 17:28:51', 0, '不想当骑士的战士不是好盗贼', 'photo/index/index_t3/av36.png', 3, '#'),
(37, '2016-12-01 12:23:46', 0, '耿直boy带来耿直氪金手游', 'photo/index/index_t3/av37.png', 3, '#'),
(38, '2016-12-01 11:23:00', 0, '初音-歌姬计划X-全曲目鉴赏合集', 'photo/index/index_t3/av38.png', 3, '#'),
(39, '2016-12-01 11:40:18', 0, '是时候让你们见识一下真正的手速了', 'photo/index/index_t3/av39.png', 3, '#'),
(40, '2016-12-01 14:16:52', 0, '转转杯很凶大赛END9P', 'photo/index/index_t3/av40.png', 3, '#'),
(41, '2016-12-01 12:16:49', 0, '【mugen】拳皇-黑幕杯', 'photo/index/index_t3/av41.png', 3, '#'),
(42, '2016-12-01 08:33:18', 0, '【剑三花羊花】白石溪', 'photo/index/index_t3/av42.png', 3, '#'),
(43, '2016-12-01 10:13:43', 0, '光环士官长震撼征兵广告！', 'photo/index/index_t3/av43.png', 3, '#'),
(44, '2016-12-01 11:16:54', 0, 'Fate/Grand Order完整版PV', 'photo/index/index_t3/av44.png', 3, '#'),
(45, '2016-12-01 15:25:38', 0, '原创游戏短片 刺客信条 延时摄影', 'photo/index/index_t3/av45.png', 3, '#'),
(46, '2016-12-01 17:26:36', 0, '明道《冒险王》全集', 'photo/index/index_t4/av46.png', 4, '#'),
(47, '2016-12-01 09:25:36', 0, '仙境之谜', 'photo/index/index_t4/av47.png', 4, '#'),
(48, '2016-12-01 17:35:29', 0, '电子烟：奇迹抑或威胁', 'photo/index/index_t4/av48.png', 4, '#'),
(49, '2016-12-01 16:23:40', 0, '第一视角东京生活记录-测试', 'photo/index/index_t4/av49.png', 4, '#'),
(50, '2016-12-01 12:30:47', 0, '列宁——功臣还是罪人？', 'photo/index/index_t4/av50.png', 4, '#'),
(51, '2016-12-01 21:30:28', 0, '一群澳洲金发洋妞游中国', 'photo/index/index_t4/av51.png', 4, '#'),
(52, '2016-12-01 23:29:24', 0, '为什么日语中有汉字,日本人来告诉你', 'photo/index/index_t4/av52.png', 4, '#'),
(53, '2016-12-01 21:55:34', 0, '马云说周星驰脏兮兮的', 'photo/index/index_t4/av53.png', 4, '#'),
(54, '2016-12-01 15:54:49', 0, '走进“替”声世界：夏磊', 'photo/index/index_t4/av54.png', 4, '#'),
(55, '2016-12-01 21:34:30', 0, '2014国际华语辩论邀请赛', 'photo/index/index_t4/av55.png', 4, '#'),
(56, '2016-12-01 21:00:00', 0, '《军武大本营》11', 'photo/index/index_t4/av56.png', 4, '#'),
(57, '2016-12-01 14:44:24', 0, '普京试开带核按钮的轰炸机', 'photo/index/index_t4/av57.png', 4, '#'),
(58, '2016-12-01 19:36:51', 0, '单价50亿的055驱逐舰明年下水', 'photo/index/index_t4/av58.png', 4, '#'),
(59, '2016-12-01 15:51:37', 0, '魅蓝Max与小米Max速度对比', 'photo/index/index_t4/av59.png', 4, '#'),
(60, '2016-12-01 17:35:51', 0, '魅族 Pro 6 Plus 上手', 'photo/index/index_t4/av60.png', 4, '#'),
(61, '2016-12-01 20:37:22', 0, 'S11E03 阿尔法罗密欧的较量', 'photo/index/index_t4/av61.png', 4, '#'),
(62, '2016-12-01 12:47:40', 0, '这一年我们看过什么？', 'photo/index/index_t5/av62.png', 5, '#'),
(63, '2016-12-01 21:36:22', 0, '一颦一笑亦戏亦泪', 'photo/index/index_t5/av63.png', 5, '#'),
(64, '2016-12-02 19:25:49', 0, '无处安放的童年', 'photo/index/index_t5/av64.png', 5, '#'),
(65, '2016-12-01 21:27:40', 0, '牵丝戏', 'photo/index/index_t5/av65.png', 5, '#'),
(66, '2016-12-01 12:25:30', 0, '犬夜叉周年之作', 'photo/index/index_t5/av66.png', 5, '#'),
(67, '2016-12-01 12:36:29', 0, '战争混剪-愿逝者安息', 'photo/index/index_t5/av67.png', 5, '#'),
(68, '2016-12-01 13:25:25', 0, '一年生（非诚勿扰3期）', 'photo/index/index_t5/av68.png', 5, '#'),
(69, '2016-12-01 10:31:38', 0, '偶像猎手【恐怖悬疑向】', 'photo/index/index_t5/av69.png', 5, '#'),
(70, '2016-12-01 12:30:29', 0, '柏拉图式-堂本刚个人CUT', 'photo/index/index_t5/av70.png', 5, '#'),
(71, '2016-12-04 15:39:27', 0, '污咚采访间第三十期', 'photo/index/index_t5/av71.png', 5, '#'),
(72, '2016-12-03 14:28:34', 0, '几分钟看完《让子弹飞》', 'photo/index/index_t5/av72.png', 5, '#'),
(73, '2016-12-01 11:26:31', 0, '小小', 'photo/index/index_t5/av73.png', 5, '#'),
(74, '2016-12-01 11:29:35', 0, 'Pokemon Go原来可以这样玩', 'photo/index/index_t5/av74.png', 5, '#'),
(75, '2016-12-02 10:36:00', 0, 'SHUT UP AND KELA', 'photo/index/index_t6/av75.png', 6, 'av/av75.mp4'),
(76, '2016-12-01 13:21:45', 0, '欢欢老师教您种树', 'photo/index/index_t6/av76.png', 6, '#'),
(77, '2016-12-01 18:27:47', 0, '李云龙-军乐队的黑暗奏曲', 'photo/index/index_t6/av77.png', 6, '#'),
(78, '2016-12-01 18:36:00', 0, '喵帕斯的世界名曲演奏大会', 'photo/index/index_t6/av78.png', 6, '#'),
(79, '2016-12-01 11:26:41', 0, '伊泽塔医生', 'photo/index/index_t6/av79.png', 6, '#'),
(80, '2016-12-01 11:38:33', 0, '未闻花名ED', 'photo/index/index_t6/av80.png', 6, '#'),
(81, '2016-12-01 10:24:46', 0, '阴阳师之非洲战歌', 'photo/index/index_t6/av81.png', 6, '#'),
(82, '2016-12-01 09:39:44', 0, '如果我是DJ你会爱我吗', 'photo/index/index_t6/av82.png', 6, '#'),
(83, '2016-12-01 12:23:36', 0, '葛平的消失', 'photo/index/index_t6/av83.png', 6, '#'),
(84, '2016-12-01 10:25:44', 0, '【全明星】青春修炼手册', 'photo/index/index_t6/av84.png', 6, '#'),
(85, '2016-12-01 10:21:40', 0, '【Win7】青空（工程）', 'photo/index/index_t6/av85.png', 6, '#'),
(86, '2016-12-01 10:23:44', 0, '【Win7】植物大战僵尸BOSS战', 'photo/index/index_t6/av86.png', 6, '#'),
(87, '2016-12-01 10:23:37', 0, '【巡山指南】Melodyne人力V教程', 'photo/index/index_t6/av87.png', 6, '#'),
(88, '2016-12-01 09:17:37', 0, '广州地铁偷走了重要的东西', 'photo/index/index_t6/av88.png', 6, '#'),
(89, '2016-12-01 09:20:38', 0, '豆子生快第二弹', 'photo/index/index_t6/av89.png', 6, '#'),
(90, '2016-12-01 19:32:32', 0, '威风堂堂自唱自跳', 'photo/index/index_t7/av90.png', 7, '#'),
(91, '2016-12-01 15:18:59', 0, 'LoveLive！❤想在辉夜城起舞', 'photo/index/index_t7/av91.png', 7, '#'),
(92, '2016-12-01 11:47:46', 0, '和futa小姐姐们一起吸毒吧！', 'photo/index/index_t7/av92.png', 7, '#'),
(93, '2016-12-01 15:28:47', 0, 'hello/how are you♥ 好想说声谢谢你', 'photo/index/index_t7/av93.png', 7, '#'),
(94, '2016-12-02 17:29:44', 0, 'saber冲田总司❤梦与叶樱', 'photo/index/index_t7/av94.png', 7, '#'),
(95, '2016-12-01 21:36:41', 0, '夏色笑容1,2,Jump!❤', 'photo/index/index_t7/av95.png', 7, '#'),
(96, '2016-12-01 18:25:46', 0, 'Paopao channel【原创振付】', 'photo/index/index_t7/av96.png', 7, '#'),
(97, '2016-12-01 23:44:34', 0, '在寒风中瑟瑟发抖,对高跟鞋无力了', 'photo/index/index_t7/av97.png', 7, '#'),
(98, '2016-12-01 23:31:39', 0, '承包冬日海上嘉年华的正片', 'photo/index/index_t7/av98.png', 7, '#'),
(99, '2016-12-01 18:33:45', 0, 'May J Lee成名作最红编舞Worth It', 'photo/index/index_t7/av99.png', 7, '#'),
(100, '2016-12-01 16:27:44', 0, '孑然妒火分解教程合集', 'photo/index/index_t7/av100.png', 7, '#'),
(101, '2016-12-01 15:27:38', 0, '新垣结衣gakki舞！！', 'photo/index/index_t7/av101.png', 7, '#'),
(102, '2016-12-01 20:23:34', 0, '无畏魔女 : 第7集 神圣之夜', 'photo/index/index_t8/av102.png', 8, '#'),
(103, '2016-12-01 08:45:43', 0, '南方公园第二十季第九集', 'photo/index/index_t8/av103.png', 8, '#'),
(104, '2016-12-01 08:29:26', 0, '齐木楠雄的灾难 : 第9集', 'photo/index/index_t8/av104.png', 8, '#'),
(105, '2016-12-01 12:43:49', 0, 'ViVid Strike! : 第8集 胜者与败者', 'photo/index/index_t8/av105.png', 8, '#'),
(106, '2016-12-01 20:35:50', 0, '奇异太郎少年的妖怪绘日记', 'photo/index/index_t8/av106.png', 8, '#'),
(107, '2016-12-01 23:34:33', 0, '无畏魔女', 'photo/index/index_t8/av107.png', 8, '#'),
(108, '2016-12-01 17:33:48', 0, '长骑美眉', 'photo/index/index_t8/av108.png', 8, '#'),
(109, '2016-12-01 20:31:46', 0, '妖精的尾巴', 'photo/index/index_t8/av109.png', 8, '#'),
(110, '2016-12-01 20:31:40', 0, '我们这一家', 'photo/index/index_t8/av110.png', 8, '#'),
(111, '2016-12-01 17:40:40', 0, '围棋少年', 'photo/index/index_t8/av111.png', 8, '#'),
(112, '2016-12-01 16:34:53', 0, '民间鬼术第2季 17', 'photo/index/index_t8/av112.png', 8, '#'),
(113, '2016-12-01 17:34:51', 0, '『魔女朵拉』预告PV第一弹', 'photo/index/index_t8/av113.png', 8, '#'),
(114, '2016-12-01 15:31:45', 0, '美妙天堂 大~家都闪耀光芒！', 'photo/index/index_t8/av114.png', 8, '#'),
(115, '2016-12-01 16:28:00', 0, '超级弹丸论破2 ', 'photo/index/index_t8/av115.png', 8, '#'),
(116, '2016-12-01 19:34:41', 0, '「刀剣乱舞-ONLINE-」stage', 'photo/index/index_t8/av116.png', 8, '#'),
(117, '2016-12-01 16:35:44', 0, '想和佐倉做的大西#33', 'photo/index/index_t8/av117.png', 1, '#');

-- --------------------------------------------------------

--
-- 表的结构 `video_comment`
--

CREATE TABLE `video_comment` (
  `id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `video_comment`
--

INSERT INTO `video_comment` (`id`, `content`, `create_time`, `user_id`, `video_id`) VALUES
(1, '非洲农业不发达，必须要用金坷垃', '2016-12-03 05:08:37', 2, 75),
(2, '我们必须要种庄稼啊!!!', '2016-12-03 15:30:35', 10, 75),
(3, '小鬼子真不傻，金坷垃不能给他们', '2016-12-02 20:47:30', 5, 75),
(4, '哈哈哈哈哈哈,超有意思', '2016-12-02 12:22:36', 1, 74),
(5, '做的太棒了', '2016-12-02 18:29:46', 1, 35),
(6, '太有意思啦，233333', '2016-12-02 21:56:29', 7, 75),
(7, '结束得有点突兀啊', '2016-12-02 11:24:40', 1, 87),
(8, '看到这个激动的要死！！！', '2016-12-02 17:42:34', 1, 37),
(9, 'up主，超棒', '2016-12-02 18:14:38', 1, 88),
(10, '你向那名为希望的绝望展露笑容', '2016-12-02 17:16:33', 1, 9),
(16, '1234', '2016-12-26 15:28:45', 1, 75);

-- --------------------------------------------------------

--
-- 表的结构 `video_show`
--

CREATE TABLE `video_show` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  `video_type` int(11) DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `video_show`
--

INSERT INTO `video_show` (`id`, `title`, `video_id`, `video_type`, `src`) VALUES
(1, '口水三国关羽篇', NULL, 1, 'photo/index/index_show/show2-1.png'),
(2, '《中华小当家》真正的大结局', NULL, 1, 'photo/index/index_show/show2-2.png'),
(3, '我差点就信了', NULL, 1, 'photo/index/index_show/show2-3.png'),
(4, '霉霉休假也不“消停”比伯再次被迫陷入打粉丝麻烦中', NULL, 2, 'photo/index/index_show/show3-1.png'),
(5, '琵琶《芊芊》——来自江南唯美婉转的闺怨诗', NULL, 2, 'photo/index/index_show/show3-2.png'),
(6, '锋芒千里—少年三国志同人曲', NULL, 2, 'photo/index/index_show/show3-3.png'),
(7, '这就是《暗黑破坏神》', NULL, 3, 'photo/index/index_show/show4-1.png'),
(8, '偷懒的绅士[绅GV]', NULL, 3, 'photo/index/index_show/show4-2.png'),
(9, '不是我吹,这国产还行', NULL, 3, 'photo/index/index_show/show4-3.png'),
(10, '《值不值得买》第四集,索尼大法好', NULL, 4, 'photo/index/index_show/show5-1.png'),
(11, '太空看世界,澳大利亚西部的沙漠', NULL, 4, 'photo/index/index_show/show5-2.png'),
(12, 'theGrandTour三贱客化身非常人贩救女王', NULL, 4, 'photo/index/index_show/show5-3.png'),
(13, '吐槽推理盛宴,荒诞中的讽刺', NULL, 5, 'photo/index/index_show/show6-1.png'),
(14, '1968福尔摩斯密探集,最忠于原著的仅存的6集', NULL, 5, 'photo/index/index_show/show6-2.png'),
(15, '范伟打天下', NULL, 5, 'photo/index/index_show/show6-3.png'),
(16, '听说鬼畜区竖笛和电音更配哦', NULL, 6, 'photo/index/index_show/show7-1.png'),
(17, '求佛小钻风', NULL, 6, 'photo/index/index_show/show7-2.png'),
(18, '全明星热唱摇摆哥', NULL, 6, 'photo/index/index_show/show7-3.png'),
(19, '要和我一起看落叶吗', NULL, 7, 'photo/index/index_show/show8-1.png'),
(20, 'Asqkj小萌', NULL, 7, 'photo/index/index_show/show8-2.png'),
(21, '妄想恋爱契约中', NULL, 7, 'photo/index/index_show/show8-3.png'),
(22, '女生宿舍日常', NULL, 8, 'photo/index/index_show/show9-1.png'),
(23, '神装少女小缠', NULL, 8, 'photo/index/index_show/show9-2.png'),
(24, '夏目友人帐', NULL, 8, 'photo/index/index_show/show9-3.png');

-- --------------------------------------------------------

--
-- 表的结构 `video_type`
--

CREATE TABLE `video_type` (
  `id` int(11) NOT NULL,
  `type_name` varchar(255) NOT NULL,
  `type_introduce` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `video_type`
--

INSERT INTO `video_type` (`id`, `type_name`, `type_introduce`) VALUES
(1, '动画', '这里是看动画的地方'),
(2, '音乐', '这里是看音乐mv的地方'),
(3, '游戏', '这是看游戏视频的地方'),
(4, '科技', '这是看科技视频的地方'),
(5, '影视', '这里是看电视剧的地方'),
(6, '鬼畜', '这里是看鬼畜的地方'),
(7, '舞蹈', '这里是看跳舞的地方'),
(8, '番剧', '这是里追番的地方');

-- --------------------------------------------------------

--
-- 表的结构 `video_user`
--

CREATE TABLE `video_user` (
  `video_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `video_user`
--

INSERT INTO `video_user` (`video_id`, `user_id`) VALUES
(12, 1),
(24, 1),
(26, 1),
(29, 1),
(37, 1),
(51, 1),
(63, 1),
(66, 1),
(67, 1),
(75, 1),
(91, 1),
(92, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_7umlrlm5h3qupdivkhe5gj707` (`role_id`);

--
-- Indexes for table `bar`
--
ALTER TABLE `bar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `danmu`
--
ALTER TABLE `danmu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_sglw9f2vyvw7jwhfm7ta85is6` (`video_id`);

--
-- Indexes for table `filter_map_config`
--
ALTER TABLE `filter_map_config`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `friend_link`
--
ALTER TABLE `friend_link`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `game_introduce`
--
ALTER TABLE `game_introduce`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `game_show`
--
ALTER TABLE `game_show`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_my3aghvmve80r7npowup2nqa2` (`goods_type`);

--
-- Indexes for table `goods_type`
--
ALTER TABLE `goods_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `indent`
--
ALTER TABLE `indent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_qhfwxckdsb7qovu60yoy54jlv` (`goods_id`),
  ADD KEY `FK_bikh32qm3prs0ffmxbtrnmlx4` (`user_id`);

--
-- Indexes for table `index_show`
--
ALTER TABLE `index_show`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `palette`
--
ALTER TABLE `palette`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_1i2a8gya34vdn3rpuc9b145ux` (`palette_type`),
  ADD KEY `FK_dbsgn0io6a59g1owxrmhx5btv` (`user_id`);

--
-- Indexes for table `palette_show`
--
ALTER TABLE `palette_show`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `palette_type`
--
ALTER TABLE `palette_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `palette_user`
--
ALTER TABLE `palette_user`
  ADD PRIMARY KEY (`palette_id`,`user_id`),
  ADD KEY `FK_jln6d3wgo8pm14v9sknr7cqxe` (`user_id`),
  ADD KEY `FK_kb6f3178agxksiasiemo9m95o` (`palette_id`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `recommend`
--
ALTER TABLE `recommend`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_k4amfk1rw1qe6eaoqlk5kevjf` (`palette_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role_permission`
--
ALTER TABLE `role_permission`
  ADD PRIMARY KEY (`role_id`,`permission_id`),
  ADD KEY `FK_fn4pldu982p9u158rpk6nho5k` (`permission_id`),
  ADD KEY `FK_j89g87bvih4d6jbxjcssrybks` (`role_id`);

--
-- Indexes for table `shop_show`
--
ALTER TABLE `shop_show`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `video`
--
ALTER TABLE `video`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_5gqrw8lnwclk94di11g90k0w6` (`video_type`);

--
-- Indexes for table `video_comment`
--
ALTER TABLE `video_comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_d74c2pjbvmpy8xj98guf853h2` (`user_id`),
  ADD KEY `FK_hp8b9ior4dpmit94yty3ueiul` (`video_id`);

--
-- Indexes for table `video_show`
--
ALTER TABLE `video_show`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_gko0tbq992xfvj13rd7jvfcrg` (`video_id`),
  ADD KEY `FK_q5aw4hejot111u6fe8v72y3` (`video_type`);

--
-- Indexes for table `video_type`
--
ALTER TABLE `video_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `video_user`
--
ALTER TABLE `video_user`
  ADD PRIMARY KEY (`video_id`,`user_id`),
  ADD KEY `FK_nx2mw4euvgl47dgwbp22h5tu8` (`user_id`),
  ADD KEY `FK_rmc4s0ef90fh0jfe6pb2csctc` (`video_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- 使用表AUTO_INCREMENT `bar`
--
ALTER TABLE `bar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `danmu`
--
ALTER TABLE `danmu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- 使用表AUTO_INCREMENT `filter_map_config`
--
ALTER TABLE `filter_map_config`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- 使用表AUTO_INCREMENT `friend_link`
--
ALTER TABLE `friend_link`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- 使用表AUTO_INCREMENT `game`
--
ALTER TABLE `game`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `game_introduce`
--
ALTER TABLE `game_introduce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- 使用表AUTO_INCREMENT `game_show`
--
ALTER TABLE `game_show`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `goods`
--
ALTER TABLE `goods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- 使用表AUTO_INCREMENT `goods_type`
--
ALTER TABLE `goods_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `indent`
--
ALTER TABLE `indent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `index_show`
--
ALTER TABLE `index_show`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 使用表AUTO_INCREMENT `palette`
--
ALTER TABLE `palette`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- 使用表AUTO_INCREMENT `palette_show`
--
ALTER TABLE `palette_show`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 使用表AUTO_INCREMENT `palette_type`
--
ALTER TABLE `palette_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 使用表AUTO_INCREMENT `permission`
--
ALTER TABLE `permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- 使用表AUTO_INCREMENT `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- 使用表AUTO_INCREMENT `recommend`
--
ALTER TABLE `recommend`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- 使用表AUTO_INCREMENT `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- 使用表AUTO_INCREMENT `shop_show`
--
ALTER TABLE `shop_show`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- 使用表AUTO_INCREMENT `video`
--
ALTER TABLE `video`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;
--
-- 使用表AUTO_INCREMENT `video_comment`
--
ALTER TABLE `video_comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- 使用表AUTO_INCREMENT `video_show`
--
ALTER TABLE `video_show`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- 使用表AUTO_INCREMENT `video_type`
--
ALTER TABLE `video_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- 限制导出的表
--

--
-- 限制表 `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK_7umlrlm5h3qupdivkhe5gj707` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- 限制表 `danmu`
--
ALTER TABLE `danmu`
  ADD CONSTRAINT `FK_sglw9f2vyvw7jwhfm7ta85is6` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`);

--
-- 限制表 `goods`
--
ALTER TABLE `goods`
  ADD CONSTRAINT `FK_my3aghvmve80r7npowup2nqa2` FOREIGN KEY (`goods_type`) REFERENCES `goods_type` (`id`);

--
-- 限制表 `indent`
--
ALTER TABLE `indent`
  ADD CONSTRAINT `FK_bikh32qm3prs0ffmxbtrnmlx4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_qhfwxckdsb7qovu60yoy54jlv` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`);

--
-- 限制表 `palette`
--
ALTER TABLE `palette`
  ADD CONSTRAINT `FK_1i2a8gya34vdn3rpuc9b145ux` FOREIGN KEY (`palette_type`) REFERENCES `palette_type` (`id`),
  ADD CONSTRAINT `FK_dbsgn0io6a59g1owxrmhx5btv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- 限制表 `palette_user`
--
ALTER TABLE `palette_user`
  ADD CONSTRAINT `FK_jln6d3wgo8pm14v9sknr7cqxe` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_kb6f3178agxksiasiemo9m95o` FOREIGN KEY (`palette_id`) REFERENCES `palette` (`id`);

--
-- 限制表 `recommend`
--
ALTER TABLE `recommend`
  ADD CONSTRAINT `FK_k4amfk1rw1qe6eaoqlk5kevjf` FOREIGN KEY (`palette_id`) REFERENCES `palette` (`id`);

--
-- 限制表 `role_permission`
--
ALTER TABLE `role_permission`
  ADD CONSTRAINT `FK_fn4pldu982p9u158rpk6nho5k` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  ADD CONSTRAINT `FK_j89g87bvih4d6jbxjcssrybks` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- 限制表 `video`
--
ALTER TABLE `video`
  ADD CONSTRAINT `FK_5gqrw8lnwclk94di11g90k0w6` FOREIGN KEY (`video_type`) REFERENCES `video_type` (`id`);

--
-- 限制表 `video_comment`
--
ALTER TABLE `video_comment`
  ADD CONSTRAINT `FK_d74c2pjbvmpy8xj98guf853h2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_hp8b9ior4dpmit94yty3ueiul` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`);

--
-- 限制表 `video_show`
--
ALTER TABLE `video_show`
  ADD CONSTRAINT `FK_gko0tbq992xfvj13rd7jvfcrg` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`),
  ADD CONSTRAINT `FK_q5aw4hejot111u6fe8v72y3` FOREIGN KEY (`video_type`) REFERENCES `video_type` (`id`);

--
-- 限制表 `video_user`
--
ALTER TABLE `video_user`
  ADD CONSTRAINT `FK_nx2mw4euvgl47dgwbp22h5tu8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_rmc4s0ef90fh0jfe6pb2csctc` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
