alter sequence orders_seq increment by 1;
select * from member;
select * from reviews;
select * from item;
select * from stock;
select * from orders;
commit;
delete from member;
delete from orders;
select
		i.i_no, i.i_name, i.i_price, i.i_category, i.i_comm, i.i_img,
		s.s_stock, s.s_name from item i, stock s where i.i_no = s.s_no and i.i_no = 1;
alter table stock add constraint stock_i_no_pk primary key(i_no);

alter table stock RENAME constraint stock_i_no_fk to stock_s_no_fk;
alter table stock add constraint stock_s_no_pk primary key(s_no);
ALTER TABLE stock RENAME COLUMN i_no TO s_no;
ALTER TABLE stock RENAME COLUMN i_stock TO s_stock;

commit;
select
		i.i_no,
		i.i_name, i.i_price, i.i_category, i.i_comm, i.i_img, i.i_gender,
		s.s_stock,s.s_name from item i, stock s
		 where i.i_no = s.s_no and i.i_no = 3;
update member set mem_pw=2555,mem_adr='중구',mem_name='박실수3' where mem_no =21;
insert into orders values(orders_seq.nextVal, 7, 1, 2, '상태', '목동','최오빠', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 8, 2, 2, '상태', '신도림','최언니', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 10, 50, 2, '상태', '홍대','장장발', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 11, 51, 2, '상태', '신촌','김단발', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 12, 5, 10, '상태', '용인','박안녕', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 17, 6, 5, '상태', '송도','박박이', sysdate, sysdate+1);

insert into reviews values(reviews_seq.nextVal, 1, 7, 1, '멋진 옷','추천합니다!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 2, 8, 2, '예쁜 옷','잘 입을게요!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 3, 7, 1, '간지나는 옷','강추강추!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 4, 8, 2, '멋진 옷','추천합니다!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 5, 10, 50, '멋진 옷','추천합니다!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 6, 17, 6, '예쁜 옷','잘 입을게요!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 7, 10, 50, '간지나는 옷','강추강추!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 8, 8, 2, '멋진 옷','추천합니다!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 9, 12, 5, '예쁜 옷','잘 입을게요!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 10, 17, 6, '멋진 옷','추천합니다!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 11, 8, 2, '간지나는 옷','강추강추!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 12, 10, 50, '귀여운 옷','짱귀여움!', 5,sysdate); 

insert into orders values(orders_seq.nextVal, 7, 1, 2, '상품준비중', '목동','최오빠', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 8, 2, 2, '상품준비중', '신도림','최언니', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 10, 50, 2, '상품준비중', '홍대','장장발', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 11, 51, 2, '상품준비중', '신촌','김단발', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 12, 5, 10, '상품준비중', '용인','박안녕', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 17, 6, 5, '상품준비중', '송도','박박이', sysdate, sysdate+1);

Insert into MEMBER values (5,'1','1','테스트','909999-1111888','010-9999-5454','오오오',to_date('22/05/26','RR/MM/DD'));
Insert into MEMBER values (3,'admin','admin','관리자','111111-1011111','010-1234-5678','서울시 구로구 가산로 144길 12',to_date('22/05/23','RR/MM/DD'));
Insert into MEMBER values (6,'2','2','심심이','888823-1166688','010-5555-9999','도도도도',to_date('22/05/31','RR/MM/DD'));
Insert into MEMBER values (7,'3','3','앤트맨','770105-1166888','010-8888-7777','어벤져스 동',to_date('22/05/31','RR/MM/DD'));
Insert into MEMBER values (11,'test2','test2','test','990101-1115881','010-0000-8888','ddddddd',to_date('22/06/02','RR/MM/DD'));
--
Insert into MEMBER values(9,'id9','pw9','김테스','900930-2122888','010-9559-5477','잠실',to_date('22/05/26','RR/MM/DD'));
Insert into MEMBER values(10,'id10','pw10','박테스','900911-1034888','010-7759-5477','강남',to_date('22/07/10','RR/MM/DD'));
Insert into MEMBER values(8,'id8','pw8','정테스','900901-2122888','010-2779-7754','홍대',to_date('22/07/11','RR/MM/DD'));
Insert into MEMBER values(1,'id1','pw1','최테스','980917-2255888','010-7729-5477','목동',to_date('22/07/12','RR/MM/DD'));
Insert into MEMBER values(15,'id15','pw15','이테스','901111-2233117','010-7529-7117','구로',to_date('22/07/13','RR/MM/DD'));

update orders set i_status = '배송 완료' where ord_no = 1;


select * from orders;
select * from member;
