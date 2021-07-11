create database ATM
use ATM

create table Users(
id int primary key identity(100,1),
name nvarchar(100),
password int,
balance float
)
drop table Users
insert into Users values ('muhammed abd elhay','2105','500000')
create table Transactions_history(
id int ,
Transaction_type nvarchar(100),
data nvarchar(50),
balance_befor float,
balance_after float
)

select * from Users
delete  from Users where id =104
SELECT TOP 1 * FROM Users ORDER BY id DESC 