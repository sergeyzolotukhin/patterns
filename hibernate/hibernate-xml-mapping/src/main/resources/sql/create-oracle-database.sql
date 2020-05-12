SELECT tablespace_name, file_name FROM dba_data_files;

CREATE TABLESPACE GE_TABLESPACE_DEV01 DATAFILE 'K:\SOFT\ORACLE\ORADATA\ORCL\GE_DEV03.DBF' SIZE 1G AUTOEXTEND ON NEXT 500M MAXSIZE 30G;

alter session set "_ORACLE_SCRIPT"=true;
CREATE USER GE_DEV03 IDENTIFIED BY "GE_DEV03" DEFAULT TABLESPACE GE_TABLESPACE_DEV01;

ALTER USER GE_DEV03 QUOTA UNLIMITED ON GE_TABLESPACE_DEV01;

grant alter session to GE_DEV03;
GRANT CREATE SESSION TO GE_DEV03;
GRANT CREATE TABLE TO GE_DEV03;
GRANT CREATE SEQUENCE TO GE_DEV03;
grant create cluster TO GE_DEV03;

GRANT ALTER ANY TABLE TO GE_DEV03;
GRANT DROP ANY TABLE TO GE_DEV03;

-- execution plan
grant SELECT_CATALOG_ROLE to GE_DEV03;
grant SELECT ANY DICTIONARY to GE_DEV03;