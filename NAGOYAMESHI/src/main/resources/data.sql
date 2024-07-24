--カテゴリー

insert ignore into categories(id,name) values(1,"ラーメン"); 
insert ignore into categories(id,name) values(2,"カレー"); 
insert ignore into categories(id,name) values(3,"ハンバーガー"); 

--店舗情報
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (1,"にこにこ食堂",1000,1,"おいしいラーメン提供します。","愛知県名古屋市東区",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (2,"激辛カレー店",2000,2,"辛いカレーを提供します。","愛知県名古屋市西区",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (3,"ラーメン中西",1000,1,"中華ラーメン提供します。","愛知県名古屋市緑区",4);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (4,"ナマステネパール",2000,2,"本場のカレー提供します。","インド",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (5,"モサバーガー",1500,3,"もさもさのハンバーガーを提供します。","愛知県名古屋市東区",2);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (6,"ドナルドバーガー",1500,3,"鴨肉バーガーが一押しです。","愛知県名古屋市名東区",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (7,"横浜商店",1000,1,"横浜家系ラーメン提供します。","愛知県名古屋市中村区",5);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (8,"ラーメン太郎",1500,1,"次郎系ラーメン提供します。","愛知県名古屋市守山区",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (9,"だめだめ食堂",500,1,"まずいラーメン提供します。","愛知県北名古屋市",1);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (10,"にこにこん食堂",2500,1,"おいしいラーメン提供します。","愛知県名古屋市東区",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (11,"一回軒",1000,2,"辛いカレーを提供します。","愛知県名古屋市西区",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (12,"ラーメン一番",3000,1,"中華ラーメン提供します。","愛知県名古屋市緑区",4);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (13,"ナマステネパール２号店",4000,2,"本場のカレー提供します。","ネパール",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (14,"足軽バーガー",2000,3,"サイドメニューが豊富です。","愛知県名古屋市東区",2);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (15,"クインバーガー",3000,3,"わっぱーバーガーが一押しです。","愛知県名古屋市名東区",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (16,"町山商店",1,3500,"家系ラーメン提供します。","愛知県名古屋市中村区",4);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (17,"ラーメン三郎",2000,1,"次郎系ラーメン提供します。","愛知県名古屋市守山区",3);
insert ignore into restaurants(id,name,price,category_id,description,address,evalues) values (18,"まずまず食堂",1000,1,"まずまずのラーメン提供します。","愛知県北名古屋市",3);

-- roles
INSERT IGNORE INTO roles (id, role_name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, role_name) VALUES (2, 'ROLE_MEMBERSHIP');
INSERT IGNORE INTO roles (id, role_name) VALUES (3, 'ROLE_ADMIN');

--users
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (1, '侍 太郎', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1,true);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (2, '侍 花子', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2,true);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (3, '侍 義勝', 'yoshikatsu.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 3,true);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (4, '侍 幸美', 'sachimi.samurai@example.com', 'password', 1, true);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (5, '侍 雅', 'miyabi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (6, '侍 正保',  'masayasu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (7, '侍 真由美',  'mayumi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (8, '侍 安民',  'yasutami.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (9, '侍 章緒',  'akio.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (10, '侍 祐子','yuko.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (11, '侍 秋美','akimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, email, password, role_id, enabled) VALUES (12, '侍 信平', 'shinpei.samurai@example.com', 'password', 1, false);
