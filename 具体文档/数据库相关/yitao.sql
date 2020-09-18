create database yitao;

use yitao;

-- 用户表(users)
create table users(
	wechat_user_id varchar(100) primary key, -- 用户微信id
	wechat_user_name varchar(150) not null, -- 用户(微信)名
	-- create_date datetime, -- 创建日期
	-- modify_date datetime -- 修改日期
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
);

-- 商品表
create table products(
	product_id bigint PRIMARY key auto_increment, -- 产品id ,对应java bigInteger
	second_category_id int, -- 小分类id
	seller_id varchar(100), -- 用微信用户id做外键
	product_title varchar(200) not null, -- 商品标题
	product_price DOUBLE not NULL, -- 商品价格
	product_introduce varchar(1000), -- 商品简介
	product_url varchar(200),	-- 商品图片url
	product_status SMALLINT, -- 商品状态  （1在上架 0已售出 2以下架）
	-- create_date datetime, -- 创建日期
	-- modify_date datetime -- 修改日期
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
);


-- 交易表
create table transaction_record(
	product_id bigint, -- 关联的商品id
	seller_id varchar(100), -- 卖家id,外键,关联卖家微信id
	buyer_id varchar(100), -- 买家id,用微信用户id做外键
	transaction_status smallint, -- 交易状态(0交易中,1交易完成)	
	transaction_date datetime -- 交易完成时间
);

-- 大分类表
create table top_category(
	top_category_id int primary key auto_increment, -- 大分类id
	top_category_name varchar(100) -- 大分类名称
);

-- 小分类表
create table second_category(
	second_category_id int PRIMARY key auto_increment, -- 小分类id
	top_category_id int, -- 大分类id,外键
	top_category_name varchar(100), -- 大分类名
	second_category_name varchar(100) -- 小分类名
);

-- 消息表
create table news(
	news_sender_id varchar(100),-- 外键,发送方微信id
	news_receiver_id varchar(100), -- 外键,接受方微信id
	news_contents varchar(1000), -- 消息内容
	news_send_out_date datetime -- 发送时间
);


-- 收藏表products
create table collection(
	product_id bigint, -- 被收藏商品id,外键
	collector_id varchar(100), -- 收藏者微信id,外键
	collection_date datetime -- 加入收藏的时间
);

create table unread_news(
	unread_news_id BIGINT primary key AUTO_INCREMENT,
	news_sender_id varchar(100),
	news_receiver_id varchar(100),
	news_contents varchar(1000),
	news_send_out_date datetime
);

-- banner图片表
create table banner_pic(
	pic_id int primary key AUTO_INCREMENT,
	pic_url varchar(200)
);

-- 修改交易时间格式
ALTER TABLE transaction_record MODIFY COLUMN transaction_date timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '交易时间' ;
-- 修改消息发送的时间格式
ALTER TABLE news MODIFY COLUMN news_send_out_date timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '消息发送时间' ;
-- 修改收藏时间格式
ALTER TABLE collection MODIFY COLUMN collection_date timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '收藏时间' ;

-- 修改未读消息表时间格式
ALTER TABLE unread_news MODIFY COLUMN news_send_out_date timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '未读消息发送时间' ;

-- 为交易单添加交易id
alter table transaction_record add transaction_record_id BIGINT primary key auto_increment;

-- 为消息表添加主键id
alter table news add news_id BIGINT primary key auto_increment;
alter table news add product_id BIGINT;

-- 为收藏表添加主键id
alter table collection add collection_id BIGINT primary key auto_increment;

-- 修改商品图片路径名长度
alter table products modify column product_url varchar(1000);
-- 给商品表加上交易点
alter table products add place_of_transaction varchar(500);

-- 为新消息表添加主键id
alter table unread_news add product_id BIGINT;

-- 为大分类表添加图片路径
alter table top_category add category_pic_url varchar(500);

-- 修改商品状态默认值
alter table products alter column product_status set default 1;

-- 把商品的卖家字段设置为not null
alter table products modify column seller_id varchar(100) not null;

-- 为用户表添加头像字段
alter table users add user_pic_url varchar(200);

-- 如果有报Expression #1 of ORDER BY clause is not in GROUP BY clause and contains nonaggregated column 'information_schema.PROFILING.SEQ' which is not functionally dependent on columns in GROUP BY clause; 
-- this is incompatible with sql_mode=only_full_group_by这个错,解除下面的语句注释
-- select version(),
-- @@sql_mode;SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

-- 为商品表添加外键约束
-- ALTER TABLE products ADD CONSTRAINT fk_product_second_category FOREIGN KEY(second_category_id) REFERENCES second_category(second_category_id);
-- ALTER TABLE products ADD CONSTRAINT fk_product_user FOREIGN KEY(seller_id) REFERENCES users(wechat_user_id);

-- 为交易表添加外键约束
-- ALTER TABLE transaction_record ADD CONSTRAINT fk_transaction_product FOREIGN KEY(product_id) REFERENCES products(product_id);
-- ALTER TABLE transaction_record ADD CONSTRAINT fk_transaction_seller FOREIGN KEY(seller_id) REFERENCES users(wechat_user_id);
-- ALTER TABLE transaction_record ADD CONSTRAINT fk_transaction_buyer FOREIGN KEY(buyer_id) REFERENCES users(wechat_user_id);

-- 为小分类表添加外键约束
-- ALTER TABLE second_category ADD CONSTRAINT fk_second_top_category FOREIGN KEY(top_category_id) REFERENCES top_category(top_category_id);

-- 为消息表添加外键约束
-- ALTER TABLE news ADD CONSTRAINT fk_news_sender FOREIGN KEY(news_sender_id) REFERENCES users(wechat_user_id);
-- ALTER TABLE news ADD CONSTRAINT fk_news_receiver FOREIGN KEY(news_receiver_id) REFERENCES users(wechat_user_id);

-- 为收藏表添加外键约束
-- ALTER TABLE collection ADD CONSTRAINT fk_collection_product FOREIGN KEY(product_id) REFERENCES products(product_id);
-- ALTER TABLE collection ADD CONSTRAINT fk_collection_collector FOREIGN KEY(collector_id) REFERENCES users(wechat_user_id);