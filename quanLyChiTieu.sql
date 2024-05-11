SET SQL_SAFE_UPDATES=0;
create database quanlychitieu;
use quanlychitieu;

/* Tạo bảng danh mục chi tiêu */
create table DanhMuc(
	id int not null AUTO_INCREMENT,
    name longtext not null,
    primary key(id)
);

insert into DanhMuc(name) values ("Ăn uống"), ("Giải trí"), ("Quần áo"), ("Học tập");

/* Tạo các ngân sách */ 
create table NganSach(
	id int not null AUTO_INCREMENT,
    name longtext not null,
    primary key(id)
);

insert into NganSach(name) values ("Tiền mặt");

/* Tạo bảng giao dịch */
create table GiaoDich(
	id int not null AUTO_INCREMENT,
    danhMucID int,
    nganSachID int,
    note longtext,
    money double not null,
    createdDay date not null,
    primary key(id)
);


