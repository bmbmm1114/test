

drop table notice_board;
create table notice_board(
	no	number primary key,
	prefix		varchar(60) not null,
	title varchar2(200) not null,
	content	varchar2(4000) not null,
	write_date date not null,
	view_count	number(5) default 0 not null 
);
drop table code;
create table code(
	code_id varchar2(30) primary key,
	code_name	varchar2(60) not null,
	code_desc varchar(1000),
	code_category varchar(15) not null
);

insert into code values('n_board_prefix1', '제품', '공지사항 게시판 제목 말머리', 'notice_prefix');
insert into code values('n_board_prefix2', '배송', '공지사항 게시판 제목 말머리', 'notice_prefix');
insert into code values('n_board_prefix3', '고객', '공지사항 게시판 제목 말머리', 'notice_prefix');

drop sequence notice_board_seq;
create sequence notice_board_seq
nocache;







