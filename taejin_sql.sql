

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


create SEQUENCE member2_seq INCREMENT by 1 start with 1;

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
     
     CREATE TABLE MEMBER2
   (    NUM NUMBER, 
    ID VARCHAR2(15 BYTE) CONSTRAINT "MEMBER2_ID_NN" NOT NULL ENABLE, 
    PWD VARCHAR2(10 BYTE), 
    NAME VARCHAR2(34 BYTE), 
    AGE NUMBER(4,0), 
    GENDER VARCHAR2(6 BYTE), 
    MDATE DATE, 
     CONSTRAINT MEMBER2_GENDER_CK CHECK (gender='남자' or gender='여자') ENABLE, 
     CONSTRAINT MEMBER2_MNUM_PK PRIMARY KEY (NUM)
     );
     select * from member2 where id = 'member2' and pwd = '1111';
     select * from member2;
     select rownum num, m.name,b.num,b.title from member2 m, board4 b where m.num = b.bnum;
     select * from board4;