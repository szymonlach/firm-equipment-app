insert into users (id,first_name,last_name,pesel) values(1,'Mark','Shepard','48194019029'),
insert into users (id,first_name,last_name,pesel) values(2,'Elen','Grant','86910497819'),
insert into users (id,first_name,last_name,pesel) values(3,'George','Smith','09867836791'),
insert into users (id,first_name,last_name,pesel) values(4,'Mike','Tusk','75918471637'),

insert into categories (id,name,description) values (1,'Laptop','This is laptop'),
insert into categories (id,name,description) values (2,'Car','This is car'),
insert into categories (id,name,description) values (3,'Camera','This is camera'),

insert into assets (id,name,description,serial_number,category_id) values (1,'dell', 'This is dell','Y7491XYU81',1),
insert into assets (id,name,description,serial_number,category_id) values (2,'lenovo', 'This is lenovo','BMA591IP09',1),
insert into assets (id,name,description,serial_number,category_id) values (3,'asus', 'This is asus','DFYY320917',1),
insert into assets (id,name,description,serial_number,category_id) values (4,'opel', 'This is opel','YTVPKA7I91',2),
insert into assets (id,name,description,serial_number,category_id) values (5,'fiat', 'This is fiat','CJA87HU19O',2),
insert into assets (id,name,description,serial_number,category_id) values (6,'citroen', 'This is citroen','LO581IG907',2),
insert into assets (id,name,description,serial_number,category_id) values (7,'olimpus', 'This is olimpus','Yuy46ui198',3),
insert into assets (id,name,description,serial_number,category_id) values (8,'sony', 'This is sony','0987654321',3),
insert into assets (id,name,description,serial_number,category_id) values (9,'panasonic', 'This is panasonic','1234567890',3),


insert into assignments(id,start,end,asset_id,user_id) values (1, '2017-10-08 15:00:00', '2018-10-08 15:00:00', 1, 1),
insert into assignments(id,start,end,asset_id,user_id) values (2, '2018-10-09 12:00:00', null, 5, 1),
insert into assignments(id,start,end,asset_id,user_id) values (3, '2018-10-10 16:00:00', null, 6, 1),


