SELECT tablespace_name, file_name FROM dba_data_files;

CREATE TABLESPACE GE_TABLESPACE_DEV01 DATAFILE 'K:\SOFT\ORACLE\ORADATA\ORCL\GE_DEV01.DBF' SIZE 1G AUTOEXTEND ON NEXT 500M MAXSIZE 30G;

alter session set "_ORACLE_SCRIPT"=true;
CREATE USER GE_DEV01 IDENTIFIED BY "GE_DEV01" DEFAULT TABLESPACE GE_TABLESPACE_DEV01;

ALTER USER GE_DEV01 QUOTA UNLIMITED ON GE_TABLESPACE_DEV01;

grant alter session to GE_DEV01;
GRANT CREATE SESSION TO GE_DEV01;
GRANT CREATE TABLE TO GE_DEV01;
GRANT CREATE SEQUENCE TO GE_DEV01;
grant create cluster TO GE_DEV01;

GRANT ALTER ANY TABLE TO GE_DEV01;
GRANT DROP ANY TABLE TO GE_DEV01;

-- --------------------------------------------------------------------------------------------------------------------
insert into CL_SR_SCHEDULE_VALUE_NUMBER_T (
    SCHEDULE_VALUE_ID, START_DATE, STOP_DATE, VALUE, VALUE_TYPE_ID, SCHEDULE_ID
)
select
    SCHEDULE_VALUE_ID, START_DATE, STOP_DATE, VALUE, VALUE_TYPE_ID, SCHEDULE_ID
from sr_schedule_value_number;

drop cluster GE_DEV01.CL_SR_SCHEDULE_VALUE_NUMBER;
create cluster GE_DEV01.CL_SR_SCHEDULE_VALUE_NUMBER (
    SCHEDULE_ID      NUMBER(19,0)
    )
    hashkeys 10000
    hash is ora_hash(SCHEDULE_ID)
    size 256;

create table GE_DEV01.CL_SR_SCHEDULE_VALUE_NUMBER_T
(
    "SCHEDULE_VALUE_ID" NUMBER(19,0) NOT NULL ENABLE,
    "START_DATE" TIMESTAMP (6) NOT NULL ENABLE,
    "STOP_DATE" TIMESTAMP (6),
    "VALUE" NUMBER(19,2) NOT NULL ENABLE,
    "VALUE_TYPE_ID" VARCHAR2(255 CHAR),
    "SCHEDULE_ID" NUMBER(19,0),
    PRIMARY KEY ("SCHEDULE_VALUE_ID")
)
    cluster
    GE_DEV01.CL_SR_SCHEDULE_VALUE_NUMBER
    (
     SCHEDULE_ID
        );

begin
    DBMS_STATS.GATHER_SCHEMA_STATS(ownname => 'GE_DEV01');
end;

CREATE INDEX GE_DEV01.IX_SR_SCHEDULE_VALUE_NUMBER
    ON GE_DEV01.SR_SCHEDULE_VALUE_NUMBER(SCHEDULE_ID);