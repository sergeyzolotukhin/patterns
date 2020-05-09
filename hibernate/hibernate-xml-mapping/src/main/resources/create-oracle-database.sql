SELECT tablespace_name, file_name FROM dba_data_files;

ALTER TABLESPACE GE_TABLESPACE_DEV01 ADD DATAFILE '<path>' SIZE 1G AUTOEXTEND ON NEXT 500M MAXSIZE 30G;

CREATE USER GE_DEV01 IDENTIFIED BY "GE_DEV01" DEFAULT TABLESPACE GE_TABLESPACE_DEV01;

ALTER USER GE_DEV01 QUOTA UNLIMITED ON USERS;

GRANT CREATE SESSION TO GE_DEV01;
GRANT CREATE TABLE TO GE_DEV01;
GRANT CREATE SEQUENCE TO GE_DEV01;

GRANT ALTER ANY TABLE TO GE_DEV01;
GRANT DROP ANY TABLE TO GE_DEV01;