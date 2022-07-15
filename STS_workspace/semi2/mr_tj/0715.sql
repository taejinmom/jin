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
update member set mem_pw=2555,mem_adr='�߱�',mem_name='�ڽǼ�3' where mem_no =21;
insert into orders values(orders_seq.nextVal, 7, 1, 2, '����', '��','�ֿ���', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 8, 2, 2, '����', '�ŵ���','�־��', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 10, 50, 2, '����', 'ȫ��','�����', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 11, 51, 2, '����', '����','��ܹ�', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 12, 5, 10, '����', '����','�ھȳ�', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 17, 6, 5, '����', '�۵�','�ڹ���', sysdate, sysdate+1);

insert into reviews values(reviews_seq.nextVal, 1, 7, 1, '���� ��','��õ�մϴ�!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 2, 8, 2, '���� ��','�� �����Կ�!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 3, 7, 1, '�������� ��','���߰���!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 4, 8, 2, '���� ��','��õ�մϴ�!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 5, 10, 50, '���� ��','��õ�մϴ�!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 6, 17, 6, '���� ��','�� �����Կ�!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 7, 10, 50, '�������� ��','���߰���!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 8, 8, 2, '���� ��','��õ�մϴ�!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 9, 12, 5, '���� ��','�� �����Կ�!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 10, 17, 6, '���� ��','��õ�մϴ�!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 11, 8, 2, '�������� ��','���߰���!', 5,sysdate); 
insert into reviews values(reviews_seq.nextVal, 12, 10, 50, '�Ϳ��� ��','¯�Ϳ���!', 5,sysdate); 

insert into orders values(orders_seq.nextVal, 7, 1, 2, '��ǰ�غ���', '��','�ֿ���', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 8, 2, 2, '��ǰ�غ���', '�ŵ���','�־��', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 10, 50, 2, '��ǰ�غ���', 'ȫ��','�����', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 11, 51, 2, '��ǰ�غ���', '����','��ܹ�', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 12, 5, 10, '��ǰ�غ���', '����','�ھȳ�', sysdate, sysdate+1);
insert into orders values(orders_seq.nextVal, 17, 6, 5, '��ǰ�غ���', '�۵�','�ڹ���', sysdate, sysdate+1);

Insert into MEMBER values (5,'1','1','�׽�Ʈ','909999-1111888','010-9999-5454','������',to_date('22/05/26','RR/MM/DD'));
Insert into MEMBER values (3,'admin','admin','������','111111-1011111','010-1234-5678','����� ���α� ����� 144�� 12',to_date('22/05/23','RR/MM/DD'));
Insert into MEMBER values (6,'2','2','�ɽ���','888823-1166688','010-5555-9999','��������',to_date('22/05/31','RR/MM/DD'));
Insert into MEMBER values (7,'3','3','��Ʈ��','770105-1166888','010-8888-7777','����� ��',to_date('22/05/31','RR/MM/DD'));
Insert into MEMBER values (11,'test2','test2','test','990101-1115881','010-0000-8888','ddddddd',to_date('22/06/02','RR/MM/DD'));
--
Insert into MEMBER values(9,'id9','pw9','���׽�','900930-2122888','010-9559-5477','���',to_date('22/05/26','RR/MM/DD'));
Insert into MEMBER values(10,'id10','pw10','���׽�','900911-1034888','010-7759-5477','����',to_date('22/07/10','RR/MM/DD'));
Insert into MEMBER values(8,'id8','pw8','���׽�','900901-2122888','010-2779-7754','ȫ��',to_date('22/07/11','RR/MM/DD'));
Insert into MEMBER values(1,'id1','pw1','���׽�','980917-2255888','010-7729-5477','��',to_date('22/07/12','RR/MM/DD'));
Insert into MEMBER values(15,'id15','pw15','���׽�','901111-2233117','010-7529-7117','����',to_date('22/07/13','RR/MM/DD'));

update orders set i_status = '��� �Ϸ�' where ord_no = 1;


select * from orders;
select * from member;
