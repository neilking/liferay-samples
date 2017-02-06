create index IX_EEE9C987 on Banking_MonthlyTrading (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_399505C9 on Banking_MonthlyTrading (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_1B9A8504 on Banking_MonthlyTrading (year);