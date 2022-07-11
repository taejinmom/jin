drop table board4;

create table board4(
num number,

title varchar2(50),
writer varchar2(20),
content clob,
reip varchar2(50),
bdate date,
view_cnt number,
bnum number,
constraint board4_num_pk primary key(num),
constraint board4_bnum_fk foreign key(bnum) references member2(num)
);

drop sequence upboard2_seq;
create SEQUENCE upboard2_seq INCREMENT by 1 start with 1;

CREATE TABLE UPBOARD2
   (    NUM NUMBER,  
    SUB VARCHAR2(100 BYTE), 
    WRITER VARCHAR2(34 BYTE), 
    PWD VARCHAR2(10 BYTE), 
    CONT VARCHAR2(400 BYTE), 
    IMGN VARCHAR2(50 BYTE), 
    UDATE DATE, 
    view_cnt number,
    unum number,
    CONSTRAINT UPBOARD2_NUM_PK PRIMARY KEY (NUM),
     constraint upboard2_unum_fk foreign key(unum) references member2(num)
     );
     
     select * from member2 where id = 'member2' and pwd = '1111';