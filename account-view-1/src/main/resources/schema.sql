drop table ACCOUNTS if exists;
create table ACCOUNTS(ACCOUNT_NUMBER VARCHAR(225), ACCOUNT_NAME VARCHAR(225), ACCOUNT_TYPE VARCHAR(225), BALANCE_DATE VARCHAR(225), CURRENCY VARCHAR(225), AVAILABLE_BALANCE VARCHAR(225));

drop table TRANSACTIONS if exists;
create table TRANSACTIONS(ACCOUNT_NUMBER VARCHAR(225), ACCOUNT_TYPE VARCHAR(225), VALUE_DATE VARCHAR(100), CURRENCY VARCHAR(225), DEBIT_AMOUNT VARCHAR(225), CREDIT_AMOUNT VARCHAR(225), TRANSACTION VARCHAR(225), TRANSACTION_NARATIVE VARCHAR(225));