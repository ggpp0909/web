# SQL & JDBC 프로그래밍

[MySQL](#mysql)



# #MySQL

##### 데이터베이스의 기본개념(정의)

- 데이터의 집합 (a Set of Data)
- 여 응용 시스템들의 통합된 정보들을 저장하여 운영할 수 있는 공용 데이터의 집합
- 효율적으로 저장, 검색, 갱신할 수 있도록 데이터 집합들끼리 연관시키고 조직화되어야 한다.



##### 데이터베이스의 특성

- 실시간 접근성(Real-time Accessability)
  - 사용자의 요구를 즉시 처리할 수 있다.
- 계속적인 변화(Countinous Evolution)
  - 정확한 값을 유지하려고 삽입, 삭제, 수정 작업 등을 이용해 데이터를 지속적으로 갱신할 수 있다.
- 동시공유성(Concurrent Sharing)
  - 사용자마다 서로다른 목적으로 사용하므로 동시에 여러사람이 동일한 데이터에 접근하고 이용할 수 있다.
- 내용참조(Content Reference)
  - 저장한 데이터 레코드의 위치나 주소가 아닌 사용자가 요구하는 데이터의 내용, 즉 데이터의 값에 따라 참조할 수 있어야 된다.



#### 데이터 베이스 관리시스템 (DBMS)

- 데이터베이스를 관리하는 소프트웨어
- 여러응용 소프트웨어 또는 시스템이 동시에 데이터베이스에 접근하여 사용할 수 있게 한다.
- 필수 3기능
  - 정의기능: 데이터베이스의 논리적, 물리적 구조를 정의
  - 조작기능: 데이터를 검색, 삭제, 갱신, 삽입, 삭제하는 기능
  - 제어기능: 데이터베이스의 내용 정확성과 안전성을 유지하도록 제어하는 기능





#### DBMS의 장/단점

**장점**

- 데이터 중복이 최소화
- 데이터의 인관성, 무결성유지
- 데이터 보안 보장

**단점**

- 운영비가 비싸다
- 백업 및 복구에 대한 관리가 복잡
- 부분적 데이터베이스 손실이 전체 시스템을 정지



# SQL

#### SQL이란?

- SQL은 데이터를 보다 쉽게 검색하고 추가, 삭제, 수정같은 조작을 할 수 있도록 고안된 컴퓨터 언어이다.
- 관계형 데이터베이스에서 데이터를 조작하고 쿼리하는 표준 수단이다.



- DML: 데이터를 조작하기 위해 사용.

  - INSERT, UPDATE, DELETE, SELECT등이 여기에 해당한다.

- DDL: 데이터베이스의 스키마를 정의하거나 조작하기 위해 사용한다.

  - CREATE, DROP, ALTER등이 여기에 해당한다.

- DCL: 데이터를 제어하는 언어이다. 권한을 관리하고, 데이터의 보안, 무결성등을 정의한다.

  - GRANT, REVOKE등이 여기에 해당한다.

  

Database 생성하기

콘솔에서 다음과 같이 명령을 실행

MySQL 관리자 계정인 root로 데이터베이스 관리 시스템에 접속하겠다는 것

```markup
mysql –uroot  -p
```

window 사용자는 설치 시에 입력했던 암호를 입력합니다.

맥 사용자는 암호가 없으니 그냥 엔터를 입력.

MySQL DBMS에 접속하면 “mysql>” 프롬프트가 보인다.

[![img](https://cphinf.pstatic.net/mooc/20180131_298/1517364008365xNdNE_PNG/2_8_1_Database.png?type=w760)](https://www.boostcourse.org/web326/lecture/258481?isDesc=false#)

- **Database 생성하기**

관리자 계정으로 MySQL에 접속했다면, 다음과 같은 명령으로 데이터베이스를 생성.

```markup
 mysql> create database DB이름;
```

우리는 다음과 같은 명령을 실행하여 DB이름을 “connectdb＂로 생성

```markup
mysql> create database connectdb;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_86/1517363514600jvDDb_PNG/2_8_1_Database2.png?type=w760)](https://www.boostcourse.org/web326/lecture/258481?isDesc=false#)

- **Database 생성하기2**

**Database 사용자 생성과 권한 주기**

- Database를 생성했다면, 해당 데이터베이스를 사용하는 계정을 생성해야 함
- 또한, 해당 계정이 데이터베이스를 이용할 수 있는 권한을 줘야 함
- 아래와 같은 명령을 이용해서 사용자 생성과 권한을 줄 수 있다.
- db이름 뒤의 * 는 모든 권한을 의미
- @’%’는 어떤 클라이언트에서든 접근 가능하다는 의미이고, @’localhost’는 해당 컴퓨터에서만 접근 가능하다는 의미다
- flush privileges는 DBMS에게 적용을 하라는 의미다.
- 해당 명령을 반드시 실행해줘야함

```markup
grant all privileges on db이름.* to 계정이름@'%' identified by ＇암호’;
grant all privileges on db이름.* to 계정이름@'localhost' identified by ＇암호’;
flush privileges;
```

- 사용자 계정이름은 'connectuser', 암호는 'connect123!@#', 해당 사용자가 사용하는 데이터베이스는 'connectdb'로 계정을 생성하려면 다음과 같이 명령을 수행

```markup
grant all privileges on connectdb.* to connectuser@'%' identified by 'connect123!@#';

grant all privileges on connectdb.* to connectuser@'localhost' identified by 'connect123!@#';

flush privileges;
```





[![img](https://cphinf.pstatic.net/mooc/20180131_122/1517363659753uRWf0_PNG/2_8_1_Database__%2C_.png?type=w760)](https://www.boostcourse.org/web326/lecture/258481?isDesc=false#)

- **실행한 모습**



##### 생성한 Database에 접속하기

아래와 같이 명령을 실행하여 원하는 데이터베이스에 접속할 수 있다.

mysql -h호스트명 -uDB계정명 -p 데이터베이스이름

우리는 현제 db이름이 connectdb, db계정이 connectuser, 암호가 connect123!@#이므로

mysql -h127.0.0.1 -uconnectuser -p connectdb 치고 엔터

![img](https://cphinf.pstatic.net/mooc/20180131_231/1517363293339FNyg8_PNG/2_8_1_Database_.png?type=w760)

**MySQL 연결끊기**

프롬프트에서 quit혹은 exit라고 입력

```markup
mysql> QUIT
mysql> exit
```

[![img](https://cphinf.pstatic.net/mooc/20180131_246/15173642579241u1LW_PNG/2_8_1_Mysql.png?type=w760)](https://www.boostcourse.org/web326/lecture/258481?isDesc=false#)

- **다음과 같이 Bye라고 나오면 연결 끊기 성공**

**MySQL 버전과 현재 날짜 구하기**

```markup
mysql> SELECT VERSION(), CURRENT_DATE;
+------------+--------------+
| VERSION()  | CURRENT_DATE |
+------------+--------------+
| 5.7.36-log | 2021-10-31   |
+------------+--------------+
1 row in set (0.00 sec)
```

프롬프트에서는 SQL을 입력.

SQL은 semicolon (;)으로 끝남.

SQL은 쿼리(Query)라고 읽는다.

쿼리는 DBMS에게 명령을 내릴 때 사용하는 문장이라고 생각하면 쉽다.

SELECT는 어떤 내용을 조회할 때 사용하는 키워드다.

MySQL은 쿼리에 해당하는 결과의 전체 row를 출력하고 마지막에 전체 row 수와 쿼리실행에 걸린 시간을 표시.

 

**키워드는 대소문자를 구별하지 않는다.**

다음 쿼리들은 모두 같다.

```markup
mysql> SELECT VERSION(), CURRENT_DATE;
mysql> select version(), current_date;
mysql> SeLeCt vErSiOn(), current_DATE;
```

 

**쿼리를 이용해서 계산식의 결과도 구할 수 있다.**

 함수 및 수식 사용 예제

```markup
mysql> SELECT SIN(PI()/4), (4+1)*5;
+-------------+---------+
| SIN(PI()/4) | (4+1)*5 |
+-------------+---------+
|    0.707107 |      25 |
+-------------+---------+
```

 

**여러 문장을 한 줄에 연속으로 붙여서 실행가능하다.**

각 문장에 semicolon(;)만 붙혀 주면 된다.

```markup
mysql> SELECT VERSION(); SELECT NOW();
+--------------+
| VERSION()    |
+--------------+
| 3.22.20a-log |
+--------------+
+---------------------+
| NOW()               |
+---------------------+
| 2004 00:15:33 |
+---------------------+
```

**
**

**하나의 SQL은 여러 줄로 입력가능하다.**

MySQL은 문장의 끝을 라인으로 구분하는 것이 아니라 semicolon(;)으로 구분하기 때문에 여러 줄에 거쳐 문장을 쓰는 것도 가능하다.

```markup
mysql> SELECT
    -> USER()
    -> ,
    -> CURRENT_DATE;
+--------------------+--------------+
| USER()             | CURRENT_DATE |
+--------------------+--------------+
| joesmith@localhost | 1999-03-18   |
+--------------------+--------------+
```

 

**SQL을 입력하는 도중에 취소할 수 있다.**

긴 쿼리를 작성하다가 중간에 취소해야 하는 경우에는 즉시 \c를 붙혀주면 됨.

```markup
mysql> SELECT
    -> USER()
    -> \c
    
mysql>
```

 

**DBMS에 존재하는 데이터베이스 확인하기**

작업하기 위한 데이터베이스를 선택하기 위해서는 어떤 데이터베이스가 존재하는지 알아보아야 한다..

현재 서버에 존재하는 데이터베이스를 찾아보기 위해서 SHOW statement을 사용.

```markup
mysql> show databases;
+-----------------------+
| Database               |
+-----------------------+
| information_schema |
| connectdb              |
+-----------------------+
2 rows in set (0.00 sec)
```

 



**사용중인 데이터베이스 전환하기**

Database을 선택하기 위해, “use” command 사용합니다.

```markup
mysql> use mydb(db명);
```

데이터베이스를 전환하려면, 이미 데이터베이스가 존재해야 하며 현재 접속 중인 계정이 해당 데이터베이스를 사용할 수 있는 권한이 있어야 합니다.

굳이 root계정으로 안해도 아까 만든 계정에 모든 권한을 줬으므로 되더라.

 



**데이터를 저장하는 공간 테이블(Table)**

- 마이크로소프트의 엑셀(Excel)을 실행하면 표가 나옵니다. 이러한 표에 각종 값을 저장할 수 있다.
- 데이터베이스도 엑셀의 표와 유사한 테이블을 가질 수 있다.
- 엑셀과 다른 점은 데이터베이스를 생성해도 테이블은 존재하지 않는다는 것다.
- 테이블을 사용하려면 테이블을 생성하는 SQL을 사용해야 한다.
- 그리고, 테이블에 값을 저장하려면 저장하기 위한 SQL을 사용해야 한다.



**테이블(table)의 구성요소**

[![img](https://cphinf.pstatic.net/mooc/20180131_276/1517366013781n0BtX_PNG/2_8_1_%28table%29_.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258482?isDesc=false#)

- **테이블(table)의 구성요소**

- 테이블 : RDBMS의 기본적 저장구조 한 개 이상의 column과 0개 이상의 row로 구성한다.
- 열(Column) : 테이블 상에서의 단일 종류의 데이터를 나타냄. 특정 데이터 타입 및 크기를 가지고 있다.
- 행(Row) : Column들의 값의 조합. 레코드라고 불림. 기본키(PK)에 의해 구분. 기본키는 중복을 허용하지 않으며 없어서는 안 된다.
- Field : Row와 Column의 교차점으로 Field는 데이터를 포함할 수 있고 없을 때는 NULL 값을 가지고 있다.

​           

**현재 데이터베이스에 존재하는 테이블 목록 확인하기**

Database를 선택 후, Database의 전체 테이블 목록을 출력

```markup
mysql> show tables;

Empty set (0.02 sec)
```

“empty set” 은  데이터베이스에 어떤 테이블도 아직 생성되지 않았다는 것을 알려준다.



**SQL 연습을 위한 테이블 생성과 값의 저장**

examples.sql을 다운로드 한다. [링크 바로가기](https://github.com/connect-boostcamp/boostcourse_fullstack_web/tree/master/part2)

터미널에서 examples.sql이 있는 폴더로 이동한 후, 다음과 같이 명령을 수행한다.

명령을 수행한 후 암호를 입력.

```markup
mysql   -uconnectuser  -p  connectdb   <  examples.sql
```

examples.sql에는 연습을 위한 테이블 생성문과 해당 테이블에 값을 저장하는 입력문이 존재

```markup
mysql –uconnectuser -p  connectdb
```

위의 명령으로 connectdb에 접속한 후 다음과 같이 명령을 수행

```markup
mysql> show tables
```

위의 명령은 접속한 db의 테이블 목록을 보는 명령

[![img](https://cphinf.pstatic.net/mooc/20180131_157/1517366408574LmBpS_PNG/2_8_1_SQL_____.png?type=w760)](https://www.boostcourse.org/web326/lecture/258482?isDesc=false#)

- **SQL연습을 위한 테이블 생성과 값의 저장**

**테이블 구조를 확인하기 위한 DESCRIBE 명령**

table 구조를 확인하기 위해, DESCRIBE 명령을 사용할 수 있다.

짧게 DESC라고 사용해도된다.

EMPLOYEE테이블의 구조를 확인해 보자

```markup
mysql> desc EMPLOYEE;
```



**데이터 조작어(Data Manipulation Language, DML)의 종류**

데이터 조작어는 모두 동사로 시작.

시작하는 동사에 따라서 다음과 같은 4가지 조작어가 있다.

- SELECT – 검색
- INSERT - 등록
- UPDATE - 수정
- DELETE - 삭제



**SELECT 구문의 기본문형**

[![img](https://cphinf.pstatic.net/mooc/20180131_187/1517374752273Ba8n9_PNG/2_8_2_select__.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문의 기본문형**

**SELECT 구문 예제(전체 데이터 검색)**

- 전체 데이터 검색
- SELECT 뒤에 * 를 기술함으로써 나타낼 수 있다.

예제 : departments 테이블의 모든 데이터를 출력하시오.

```markup
  SELECT * FROM  DEPARTMENT;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_204/15173752726665yfHB_PNG/2_8_2_select__.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제**

**SELECT 구문 예제(특정 컬럼 검색)**

- SELECT 뒤에 컬럼을 콤마(,)로 구별해서 나열

예제 : employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력하시오.

어떤 칼럼이 있는지는 desc명령으로 확인

```markup
select empno, name, job from employee;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_242/1517375406686GtLK0_PNG/2_8_2_select__%28__%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제(특정 컬럼 검색)**

**SELECT 구문 예제(컬럼에 Alias부여하기)**

- 컬럼에 대한 ALIAS(별칭)을 부여해서 나타내는 칼럼의 HEADING을 변경할 수 있다.

예제 : employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력하시오.

```markup
select empno as 사번, name as 이름, job as 직업 from employee;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_241/1517375599282HCWV3_PNG/2_8_2_select__%28_alias%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제(칼럼에 alias부여하기)**

**SELECT 구문 예제(컬럼의 합성(Concatenation))**

- 문자열 결합함수 concat 사용

예제 : employee 테이블에서 사번과 부서번호를 하나의 칼럼으로 출력하시오.

```markup
SELECT concat( empno, '-', deptno) AS '사번-부서번호' 
FROM employee;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_100/1517375714196vQgJz_PNG/2_8_2_select__%28_%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제(컬럼의 합성)**

**SELECT 구문 예제(중복행의 제거)**

- 중복되는 행이 출력되는 경우, DISTINCT 키워드로 중복행을 제거

예제1 : 사원 테이블의 모든 부서번호 출력하시오. (사원 수 만큼 출력된다.)

```markup
select deptno from employee;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_181/1517375842547vAATO_PNG/2_8_2_select__%28_%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제(중복행의 제거)**

예제2 : 사원 테이블의 부서번호를 중복되지 않게 출력하시오.

```markup
select distinct deptno from employee;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_259/1517375862194IANYL_PNG/2_8_2_select__%28_%29-2.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제(중복행의 제거)-2**

**SELECT 구문 예제(정렬하기)**

[![img](https://cphinf.pstatic.net/mooc/20180227_237/15196955203980m2pE_PNG/2.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **ORDER BY 절**

**SELECT 구문 예제(정렬하기)**

예제 : employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력하시오.

단, 이름을 기준으로 오름차순 정렬합니다.

```markup
select empno, name, job from employee order by name;

select empno as 사번, name as 이름, job as 직업 from employee order by 이름;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_293/1517376141070o18OB_PNG/2_8_2_select__%28alias___%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제(alias를 사용하지 않았을 경우)**

[![img](https://cphinf.pstatic.net/mooc/20180131_190/15173761881889EX9u_PNG/2_8_2_select__%28alias__%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제(alias를 사용했을 경우)**

**SELECT 구문 예제(정렬하기)**

예제 : employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력하시오.

단, 이름을 기준으로 내림차순 정렬합니다.

```markup
select empno, name, job from employee order by name desc;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_124/15173762661850euMv_PNG/2_8_2_select__%28_____%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258484?isDesc=false#)

- **select 구문 예제(이름 기준 내림 차순 정렬하기 결과)**



**SELECT 구문 예제(특정 행 검색- where절)**

[![img](https://cphinf.pstatic.net/mooc/20180227_23/1519695801630edbfc_PNG/3.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258485?isDesc=false#)

- **SELECT 구문 예제(특정 행 검색- where절)**

- 산술비교 연산자

예제 : employee 테이블에서 고용일(hiredate)이 1981년 이전의 사원이름과 고용일을 출력하시오.

```markup
select name, hiredate from employee where hiredate < '1981-01-01';
```

[![img](https://cphinf.pstatic.net/mooc/20180131_47/1517377275536vNSNE_PNG/2_8_2_select__%28__-where%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258485?isDesc=false#)

- **select 구문 예제(특정 행 검색-where절)**

- 논리연산자

예제 : employee 테이블에서 부서번호가 30인 사원이름과 부서번호를 출력하시오.

```markup
select name, deptno from employee where deptno = 30;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_226/1517377406317qRg8K_PNG/2_8_2_select__%28__-where%29-2.png?type=w760)](https://www.boostcourse.org/web326/lecture/258485?isDesc=false#)

- **select 구문 예제(특정 행 검색-where절)-2**

- IN 키워드

예제 : employee 테이블에서 부서번호가 10또는 30인 사원이름과 부서번호를 출력하시오.

```markup
select name, deptno from employee where deptno in (10, 30);
```

[![img](https://cphinf.pstatic.net/mooc/20180131_165/15173774686553LyvB_PNG/2_8_2_select__%28__-where%29-3.png?type=w760)](https://www.boostcourse.org/web326/lecture/258485?isDesc=false#)

- **select 구문 예제(특정 행 검색-where절)-3**

- LIKE 키워드
- 와일드 카드를 사용하여 특정 문자를 포함한 값에 대한 조건을 처리
- % 는 0에서부터 여러 개의 문자열을 나타냄
- _ 는 단 하나의 문자를 나타내는 와일드 카드

예제 : employee 테이블에서 이름에 'A'가 포함된 사원의 이름(name)과 직업(job)을 출력하시오.

```markup
select name, job from employee where name like '%A%';
```

[![img](https://cphinf.pstatic.net/mooc/20180131_100/1517377500401b7GdO_PNG/2_8_2_select__%28__-where%29-4.png?type=w760)](https://www.boostcourse.org/web326/lecture/258485?isDesc=false#)

- **select 구문 예제(특정 행 검색-where절)-4**

**SELECT 구문 예제(함수의 사용)**

- UCASE, UPPER -> 대문자로 바꿔주는 함수

```markup
mysql> SELECT UPPER('SEoul'), UCASE('seOUL');
 +-----------------+-----------------+
  | UPPER('SEoul') | UCASE('seOUL') |
  +-----------------+-----------------+
  | SEOUL            | SEOUL            |
  +-----------------+-----------------+
```

from 다음에 테이블이 없을 경우에는 테이블에서 조회하는 것이 아니다.

- LCASE, LOWER -> 소문자로 바꿔주는 함수

```markup
mysql> SELECT LOWER('SEoul'), LCASE('seOUL');
 +-----------------+-----------------+
  | LOWER('SEoul') | LCASE('seOUL') |
  +-----------------+-----------------+
  | seoul              | seoul             |
  +-----------------+-----------------+
```

- substring -> 밑의 예제는 3번째부터 두개 보여줘요 이런거임

```markup
mysql> SELECT SUBSTRING('Happy Day',3,2);
  +-----------------+-----------------+
  | SUBSTRING('Happy Day',3,2)      |
  +-----------------+-----------------+
  | pp                                       |
  +-----------------+-----------------+
```

- LPAD, RPAD -> 공백이 존재할경우 해당부분에 문자를 채워줘요('문자', 공간크기, 빈공간에채울문자)

```markup
mysql> SELECT LPAD('hi',5,'?'),LPAD('joe',7,'*');
  +------------------+-------------------+
  | LPAD('hi',5,'?')    | LPAD('joe',7,'*')   |
  +------------------+-------------------+
  | ???hi               |           ****joe    |
  +------------------+-------------------+
```

- TRIM, LTRIM, RTRIM -> 공백을 없애는것,(전체공백, 왼쪽공백, 오른쪽공백)

```markup
mysql> SELECT LTRIM(' hello '), RTRIM(' hello ');
+-------------------------------------+
| LTRIM(' hello ') | RTRIM(' hello ')  |
+-------------------------------------+
| 'hello '            | '  hello‘            |
+-------------------------------------+
mysql> SELECT TRIM(' hi '),TRIM(BOTH 'x' FROM 'xxxhixxx');
+----------------+-----------------------------------+
| TRIM(' hi ')     | TRIM(BOTH 'x' FROM 'xxxhixxx') |
+----------------+-----------------------------------+
| hi                 | hi                                       |
+----------------+-----------------------------------+
```

- ABS(x) : x의 절대값

```markup
mysql> SELECT ABS(2), ABS(-2);
+-----------+------------+ 
| ABS(2)     | ABS(-2)    | 
+-----------+------------+ 
| 2            | 2             | 
+-----------+------------+
```

- MOD(n,m) % : n을 m으로 나눈 나머지 값

```markup
mysql> SELECT MOD(234,10), 253 % 7, MOD(29,9);
+----------------+------------+-------------+ 
| MOD(234,10)  | 253 % 7   | MOD(29,9) | 
+----------------+------------+-------------+ 
|      4.             |       1      |      2         | 
+----------------+------------+-------------+
```



**SELECT 구문(함수의 사용)**

- FLOOR(x) : x보다 크지 않은 가장 큰 정수를 반환합니다. BIGINT로 자동 변환합니다.
- CEILING(x) : x보다 작지 않은 가장 작은 정수를 반환합니다.
- ROUND(x) : x에 가장 근접한 정수를 반환합니다.
- POW(x,y) POWER(x,y) : x의 y 제곱 승을 반환합니다.
- GREATEST(x,y,...) : 가장 큰 값을 반환합니다.
- LEAST(x,y,...) : 가장 작은 값을 반환합니다.
- CURDATE(),CURRENT_DATE : 오늘 날짜를 YYYY-MM-DD나 YYYYMMDD 형식으로 반환합니다.
- CURTIME(), CURRENT_TIME : 현재 시각을 HH:MM:SS나 HHMMSS 형식으로 반환합니다.
- NOW(), SYSDATE() , CURRENT_TIMESTAMP : 오늘 현시각을 YYYY-MM-DD HH:MM:SS나 YYYYMMDDHHMMSS 형식으로 반환합니다. 
- DATE_FORMAT(date,format) : 입력된 date를 format 형식으로 반환합니다.
- PERIOD_DIFF(p1,p2) : YYMM이나 YYYYMM으로 표기되는 p1과 p2의 차이 개월을 반환합니다.



**SELECT 구문(CAST 형변환)**



[![img](https://cphinf.pstatic.net/mooc/20180227_7/1519696097137n1dmo_PNG/4.png?type=w760)](https://www.boostcourse.org/web326/lecture/258486?isDesc=false#)

- **SELECT 구문 (CAST 형변환)**

예제

```markup
mysql> select cast(now() as date);
+---------------------+
| cast(now() as date) |
+---------------------+
| 2003-09-25          |
+---------------------+
1 row in set (0.00 sec)
mysql> select cast(1-2 as unsigned);
+----------------------------+
|   cast(1-2 as unsigned)    |
+----------------------------+
|  18446744073709551615 |
+----------------------------+
```

 

**SELECT 구문(그룹함수)**

[![img](https://cphinf.pstatic.net/mooc/20180131_87/151738015308653Cmb_PNG/2_8_2_select_%28%29.PNG?type=w760)](https://www.boostcourse.org/web326/lecture/258486?isDesc=false#)

- **SELECT 구문(그룹함수)**

**SELECT 구문 예제(그룹함수)**

예제 : employee 테이블에서 부서번호가 30인 직원의 급여 평균과 총합계를 출력하시오.



```markup
SELECT AVG(salary) , SUM(salary)
FROM employee
WHERE deptno = 30;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_263/1517380309278sUNR3_PNG/2_8_2_select__%28%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258486?isDesc=false#)

- **SELECT 구문 예제(그룹함수)**

**SELECT 구문 예제(그룹함수와 groupby 절)**

예제 : employee 테이블에서 부서별 직원의 부서번호, 급여 평균과 총합계를 출력하시오.

```markup
SELECT deptno, AVG(salary) , SUM(salary)

FROM employee

group by deptno;
```

 

[![img](https://cphinf.pstatic.net/mooc/20180131_9/1517380488029v1nbz_PNG/2_8_2_select__%28_groupby_%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258486?isDesc=false#)

- **SELECT 구문 예제(그룹함수와 groupby 절)**



**데이터 입력 (INSERT문)**

```markup
INSERT INTO 테이블명(필드1, 필드2, 필드3, 필드4, … ) 
        VALUES ( 필드1의 값, 필드2의 값, 필드3의 값, 필드4의 값, … )

INSERT INTO 테이블명
        VALUES ( 필드1의 값, 필드2의 값, 필드3의 값, 필드4의 값, … )
```

- 필드명을 지정해주는 방식은 디폴트 값이 세팅되는 필드는 생력할 수 있다.
- 필드명을 지정해주는 방식은 추 후, 필드가 추가/변경/수정 되는 변경에 유연하게 대처 가능하다.
- 필드명을 생략했을 경우에는 모든 필드 값을 반드시 입력해야 한다.

 

**데이터 입력 실습 (INSERT문)**

예제 : ROLE테이블에 role_id는 200, description에는 'CEO'로 한건의 데이터를 저장하시오.

```markup
insert into ROLE (role_id, description) values ( 200, 'CEO');
```

[![img](https://cphinf.pstatic.net/mooc/20180131_67/1517380899399UDtk6_PNG/2_8_2___%28INSERT%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258487?isDesc=false#)

**데이터 수정(UPDATE문)**

```markup
 UPDATE  테이블명
        SET  필드1=필드1의값, 필드2=필드2의값, 필드3=필드3의값, …
   WHERE  조건식
```

- 조건식을 통해 특정 row만 변경할 수 있다다.
- 조건식을 주지 않으면 전체 로우가 영향을 미치니 조심해서 사용해야한다.

[예제11] user 번호가 1인 사용자의 이름을 영문으로 바꾸고,  join_date을 현재 시간이 적용되도록 수정하시오.



**데이터 수정 실습(UPDATE문)**

예제 : ROLE테이블에 role_id가 200일 경우 description을 'CTO'로 수정하시오.

```markup
update ROLE

set description = 'CTO'

where role_id = 200;
```

\* where절을 안줄 경우 모든 데이터가 수정되니 조심해야 합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_267/15173811095845ybA5_PNG/2_8_2___%28UPDATE%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258487?isDesc=false#)

- **데이터 수정 실습(UPDATE문)**

**데이터 삭제(DELETE문)**

```markup
 DELETE
      FROM  테이블명
WHERE  조건식
    
```

- 조건식을 통해 특정 row만 삭제할 수 있다.
- 조건식을 주지 않으면 전체 로우가 영향을 미치니 조심해서 사용

[예제12] user 번호가 1인 사용자를 삭제하시오.



**데이터 삭제 실습(DELETE문)**

예제 : ROLE테이블에서 role_id는 200인 정보를 삭제하시오.

```markup
delete from ROLE where role_id = 200;
```

\* where절을 안줄 경우 모든 데이터가 삭제되니 조심해야 합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_20/1517381432397wRROo_PNG/2_8_2___%28DELETE%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/258487?isDesc=false#)

- **데이터 삭제 실습(DELETE 문)**



**테이블 생성**

```markup
create table 테이블명( 
          필드명1 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT], 
          필드명2 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT], 
          필드명3 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT], 
          ........... 
          PRIMARY KEY(필드명) 
          );
```

- 데이터 형 외에도 속성값의 빈 값 허용 여부는 NULL 또는 NOT NULL로 설정
- DEFAULT 키워드와 함께 입력하지 않았을 때의 초기값을 지정
- 입력하지 않고 자동으로 1씩 증가하는 번호를 위한 AUTO_INCREMENT

 

**테이블 생성 실습**

EMPLOYEE와 같은 구조를 가진 EMPLOYEE2 테이블을 생성하시오.

[![img](https://cphinf.pstatic.net/mooc/20180131_144/1517387104021xnStV_PNG/2_8_3___.png?type=w760)](https://www.boostcourse.org/web326/lecture/58936?isDesc=false#)

- **테이블 생성 실습**

```markup
CREATE TABLE EMPLOYEE2(   
            empno      INTEGER NOT NULL PRIMARY KEY,  
           name       VARCHAR(10),   
           job        VARCHAR(9),   
           boss       INTEGER,   
           hiredate   VARCHAR(12),   
           salary     DECIMAL(7, 2),   
           comm       DECIMAL(7, 2),   
          deptno     INTEGER);
```

 

**테이블 수정 (컬럼 추가 / 삭제)**

```markup
alter table 테이블명
          add  필드명 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT];

alter table 테이블명
         drop  필드명;
```

 

**테이블 수정 실습 (컬럼 추가)**

실습 – EMPLOYEE2 테이블에 생일(birthdate)칼럼을 varchar(12)형식으로 추가하시오.

```markup
alter table EMPLOYEE2

add birthdate varchar(12);
```

[![img](https://cphinf.pstatic.net/mooc/20180131_255/15173873316052tWyD_PNG/2_8_3___%28%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/58936?isDesc=false#)

- **테이블 수정 실습(컬럼추가)**

**테이블 수정 실습 (컬럼 삭제)**

실습 – EMPLOYEE2 테이블의 생일(birthdate)칼럼을 삭제하시오.

```markup
alter table EMPLOYEE2

drop birthdate;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_264/15173874516941y662_PNG/2_8_3___%28%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/58936?isDesc=false#)

- **테이블 수정 실습(컬럼추가삭제)**

**테이블 수정 (컬럼 수정)**

```markup
alter table  테이블명
     change  필드명  새필드명 타입 [NULL | NOT NULL][DEFAULT ][AUTO_INCREMENT];
```

- change 키워드를 사용하고 칼럼을 새롭게 재정의 (이름부터 속성까지 전부)

 

**테이블 수정 실습 (컬럼 수정)**

실습 – EMPLOYEE2 테이블의 부서번호(deptno)를 dept_no로 수정하시오.

```markup
alter table EMPLOYEE2

change deptno dept_no int(11);
```

[![img](https://cphinf.pstatic.net/mooc/20180131_244/15173875762404JQ0U_PNG/2_8_3___%28%29.png?type=w760)](https://www.boostcourse.org/web326/lecture/58936?isDesc=false#)

- **테이블 수정 실습(컬럼수정)**

**테이블 이름 변경**

```markup
alter table  테이블명 rename 변경이름
```

 

**테이블 이름 변경 실습**

실습 – EMPLOYEE2 테이블의 이름을 EMPLOYEE3로 변경하시오.

```markup
alter table EMPLOYEE2

rename EMPLOYEE3;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_40/1517387645188A8ER4_PNG/2_8_3____.png?type=w760)](https://www.boostcourse.org/web326/lecture/58936?isDesc=false#)

- **테이블 이름 변경 실습**

**테이블 삭제하기**

```markup
drop table 테이블이름;
```

참고로, 제약 조건이 있을 경우에는 drop table 명령으로도 테이블이 삭제되지 않을 수 있습니다.

그럴 경우는 테이블을 생성한 반대 순서로 삭제를 해야합니다.

 

**테이블 삭제 실습**

\* 테이블 삭제 후 desc 명령을 수행하면, 존재하지 않는 테이블이라고 표시됩니다.

실습 – EMPLOYEE2 테이블을 삭제하시오.

```markup
drop table EMPLOYEE2;
```

[![img](https://cphinf.pstatic.net/mooc/20180131_181/15173877575931jc56_PNG/2_8_3___.png?type=w760)](https://www.boostcourse.org/web326/lecture/58936?isDesc=false#)

- **테이블 삭제 실습**
