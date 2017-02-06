create table Banking_MonthlyTrading (
	uuid_ VARCHAR(75) null,
	monthlyTradingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	year INTEGER,
	month INTEGER,
	volume INTEGER
);