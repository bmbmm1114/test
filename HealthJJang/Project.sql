select * from member


insert into health_member values(1,);

create table health_member
(
	member_no number(5) primary key,
	shooes_no number(4) constraint health_fk1 references health_shooes,
	member_name varchar2(20) not null,
	member_phonemiddle number(5),
	member_phoneend number(5),
	member_startDay DATE not null,
	member_endDay DATE not null,
	member_birthDay DATE,
	member_address varchar2(100),
	member_email varchar2(50),
	member_returnprice number(20) not null,
	member_codeID varchar2(50) not null	
)

create table health_shooes
(
	shooes_no number(4) primary key,
	shooes_startDay DATE not null,
	shooes_endDay DATE not null
)

create table attendance(
	member_no number(5) constraint health_fk2 references health_member,
	member_name varchar2(30),
	attendance_date DATE
)

create table codetable(
	CODE varchar2(50) primary key,
	CODEOPTION varchar2(20),
	CODEVALUE varchar2(20),
	EXPLAGIN varchar2(20)
)

create table QA(
	letter_no varchar2(50) primary key,
	letter_name varchar2(50) not null, 
	letter_identificationnumber number(40) not null, 
	letter_order number(40) not null,
	letter_class number(40) not null
)

create table publicBoard(
	board_no number(40) not null,
	board_header varchar2(50) not null,
	board_title varchar2(50) not null,
	board_content varchar2(50) not null,
	board_date DATE not null,
	board_count number(40) not null,
	board_password varchar2(50) not null
)


drop table product














create table product
(
	product_no number(5) primary key,
	product_name varchar2(50) not null,
	product_price number(5) not null,
	product_size number(5) not null,
	CODE varchar2(50) not null,
	product_color varchar2(50) not null,
	product_amount number(5) not null,
	product_explain varchar2(50) not null
)

create table shoppingbasket(
	product_no number(5) constraint health_fk3 references product,
	member_no number(5) constraint health_fk4 references health_member,
	shoppingbasket_count number(5),
	product_name varchar2(20)
)

create table orderation(
	orderation_no varchar2(20) primary key,
	product_no number(5) constraint health_fk5 references product not null,
	buyername varchar2(20) not null,
	CODE varchar2(20) not null,
	phone2 number(5) not null,
	phone3 number(5) not null,
	orderation_address varchar2(30) not null,
	postalnumber varchar2(40) not null,
	CODE varchar2(40) not null,
	orderation_price number(20) not null,
	orderation_check varchar2(3)
)

create table orderer(
	orderation_no varchar2(20) constraint health_fk6 references orderation,
	member_no number(5) constraint health_fk7 references health_member,
	orderername varchar2(30),
	orderercount varchar2(4)
)









drop table health_locker
drop table health_member

