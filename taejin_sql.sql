
-- member 테이블
create table member(
mem_no number primary key,
mem_id varchar2(20) unique,
mem_pw varchar2(20) not null,
mem_name varchar2(50) not null,
mem_jubun varchar2(20) unique,
mem_phone varchar2(30) unique,
mem_adr varchar(255) not null,
mem_admin number(1) not null, -- 관리자 1, 회원 0으로 구분한것(사용안하면 삭제해도됨)
mem_date date
);
-- member 시퀀스 테이블
create sequence member_seq increment by 1 start with 1;


-- item 테이블 생성
create table item(
i_no number primary key,
i_name varchar2(50) unique,
i_price number not null,
i_category varchar2(50) not null, -- 상의, 하의, 잡화
i_comm clob not null,
i_img varchar2(255),
i_gender varchar2(20) -- 남성, 여성, 공용
);
-- item 시퀀스 테이블 생성
create sequence item_seq increment by 1 start with 1;

-- stock 테이블 생성
create table stock(
i_no number,
i_stock number not null,
s_name varchar2(50),
s_phone varchar2(30),
constraint stock_i_no_fk foreign key(i_no) references item(i_no) on delete cascade
);

-- 카테고리와, 젠더에는 3종류의 값만 입력되는 제약조건을 추가해줌
alter table item add constraint item_i_category_ck check(i_category='상의' or i_category='하의' or i_category='잡화');
alter table item add constraint item_i_gender_ck check(i_gender='남성' or i_gender='여성' or i_gender='공용');

-- orders 테이블 생성
create table orders(
ord_no number primary key,
mem_no number,
i_no number,
ord_count number not null,
i_status varchar2(50) not null,
ord_address varchar2(255) not null, -- 추가 기존 회원 기본배송지를 수정해서 주문할수 있도록
ord_name varchar2(20) not null, -- 추가 기존 회원 이름을 수정해서 받을 사람 입력해서 주문할수 있도록
ord_date date,
ord_edate date,
-- constraint order_mem_no_fk foreign key(mem_no) references member(mem_no),
constraint order_i_no_fk foreign key(i_no) references item(i_no) on delete cascade
);

-- orders 시퀀스 테이블 생성
create sequence orders_seq increment by 1 start with 1;


-- reviews 테이블 생성
create table reviews(
r_no number primary key,
ord_no number,
mem_no number,
i_no number,
r_name varchar2(255) not null,
r_comm clob,
r_score number not null,
r_date date not null,
constraint review_ord_no_fk foreign key(ord_no) references orders(ord_no),
constraint review_mem_no_fk foreign key(mem_no) references member(mem_no),
constraint review_i_no_fk foreign key(i_no) references item(i_no),
constraint ord_no_uq unique(ord_no)
);
alter table reviews add constraint ord_no_uq unique(ord_no);
-- reviews 시퀀스 테이블 생성
create sequence reviews_seq increment by 1 start with 1;



-- 장바구니 테이블 생성
create table basket(
b_num number primary key,
mem_no number,
i_no number,
b_stock number not null,
--constraint basket_mem_no_fk foreign key(mem_no) references member(mem_no),
constraint basket_i_no_fk foreign key(i_no) references item(i_no)  on delete cascade
);

-- 장바구니 시퀀스 테이블 생성
create sequence basket_seq increment by 1 start with 1;


alter table stock RENAME constraint stock_i_no_fk to stock_s_no_fk;
alter table stock add constraint stock_s_no_pk primary key(s_no);
ALTER TABLE stock RENAME COLUMN i_no TO s_no;
ALTER TABLE stock RENAME COLUMN i_stock TO s_stock;