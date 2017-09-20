--create time:2017年9月20日12:59:28.
--script by stagebo.
--Database:Sql Server 2012.
--The Trips table holds all taxi trips. Each trip has a unique Id, while Client_Id and Driver_Id are both foreign keys to the Users_Id at the Users table. Status is an ENUM type of (��completed��, ��cancelled_by_driver��, ��cancelled_by_client��).

--+----+-----------+-----------+---------+--------------------+----------+
--| Id | Client_Id | Driver_Id | City_Id |        Status      |Request_at|
--+----+-----------+-----------+---------+--------------------+----------+
--| 1  |     1     |    10     |    1    |     completed      |2013-10-01|
--| 2  |     2     |    11     |    1    | cancelled_by_driver|2013-10-01|
--| 3  |     3     |    12     |    6    |     completed      |2013-10-01|
--| 4  |     4     |    13     |    6    | cancelled_by_client|2013-10-01|
--| 5  |     1     |    10     |    1    |     completed      |2013-10-02|
--| 6  |     2     |    11     |    6    |     completed      |2013-10-02|
--| 7  |     3     |    12     |    6    |     completed      |2013-10-02|
--| 8  |     2     |    12     |    12   |     completed      |2013-10-03|
--| 9  |     3     |    10     |    12   |     completed      |2013-10-03| 
--| 10 |     4     |    13     |    12   | cancelled_by_driver|2013-10-03|
--+----+-----------+-----------+---------+--------------------+----------+
--The Users table holds all users. Each user has an unique Users_Id, and Role is an ENUM type of (��client��, ��driver��, ��partner��).

--+----------+--------+--------+
--| Users_Id | Banned |  Role  |
--+----------+--------+--------+
--|    1     |   No   | client |
--|    2     |   Yes  | client |
--|    3     |   No   | client |
--|    4     |   No   | client |
--|    10    |   No   | driver |
--|    11    |   No   | driver |
--|    12    |   No   | driver |
--|    13    |   No   | driver |
--+----------+--------+--------+
--Write a SQL query to find the cancellation rate of requests made by unbanned clients between Oct 1, 2013 and Oct 3, 2013. For the above tables, your SQL query should return the following rows with the cancellation rate being rounded to two decimal places.

--+------------+-------------------+
--|     Day    | Cancellation Rate |
--+------------+-------------------+
--| 2013-10-01 |       0.33        |
--| 2013-10-02 |       0.00        |
--| 2013-10-03 |       0.50        |
--+------------+-------------------+
--Credits:
--Special thanks to @cak1erlizhou for contributing this question, writing the problem description and adding part of the test cases.

use leetCode
go
if object_id(N'trips',N'U') is null
	create table trips(
	id int primary key not null,
	client_id int not null,
	driver_id int not null,
	tripStatus nvarchar(64) not null,
	request_at datetime not null
	)
go
delete from trips;
insert into trips values(1,1,10,'completed','2016-10-1');
insert into trips values(2,2,11,'cancelled_by_driver','2016-10-1');
insert into trips values(3,3,12,'completed','2016-10-1');
insert into trips values(4,4,13,'cancelled_by_client','2016-10-1');
insert into trips values(5,1,10,'completed','2016-10-2');
insert into trips values(6,2,11,'completed','2016-10-2');
insert into trips values(7,3,12,'completed','2016-10-2');
insert into trips values(8,2,12,'completed','2016-10-3');
insert into trips values(9,3,10,'completed','2016-10-3');
insert into trips values(10,4,13,'cancelled_by_client','2016-10-3');
go
if object_id(N'users',N'U') is null
create table users
(
userid int primary key not null,
banded nvarchar(4) not null,
roles nvarchar(8) not null
)
GO
delete from users;
insert into users values (1,'NO','client')
insert into users values (2,'YES','client')
insert into users values (3,'NO','client')
insert into users values (4,'NO','client')
insert into users values (10,'NO','driver')
insert into users values (11,'NO','driver')
insert into users values (12,'NO','driver')
insert into users values (13,'NO','driver')
go

SELECT 
request_at as Day
,round(cast(sum(case when tripStatus = 'completed' then 0 else 1 end) as float)/cast(count(*) as float),2) as sum
FROM TRIPS AS T
INNER JOIN USERS AS U
ON T.CLIENT_ID = U.USERID

WHERE U.BANDED = 'NO'
group by request_at 
GO
