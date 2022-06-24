# MySQLGraalVM
An attempt to use JDBC + MySQL + GraalVm and Docker.

However, we have a connection problem that we haven't been able to resolve yet.

## To work locally
These are the steps to run the code locally

### 1. Change [Main] java class
Change the mysql connection information:
```
public static final String MYSQL_JDBC_URL = "jdbc:mysql://abcd.efghijklm.us-east-1.rds.amazonaws.com:3306/database";
public static final String MYSQL_USERNAME = ...;
public static final String MYSQL_PASSWORD = ...;
```

### 2. Build jar with Maven
The following file will be generated: `./target/mySQLGraalVM-1.0.jar`

### 3. Build image with Docker
Run the following command: `docker build -t mysql-graalvm .`

### 4. Run image
Run the following command: `docker run -d mysql-graalvm`

## Connection error
This error only occurs using `ghcr.io/graalvm/graalvm-ce`, if we use another VM like `amazoncorretto:18-alpine` everything works perfect.

We haven't found a solution yet.


```
Exception in thread "main" java.sql.SQLNonTransientConnectionException: Cannot connect to MySQL server on abcd.efghijklm.us-east-1.rds.amazonaws.com:3,306.

Make sure that there is a MySQL server running on the machine/port you are trying to connect to and that the machine this software is running on is able to connect to this host/port (i.e. not firewalled). Also make sure that the server has not been started with the --skip-networking flag.


	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:110)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:89)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:63)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:73)
	at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:462)
	at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:241)
	at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:198)
	at java.sql.DriverManager.getConnection(DriverManager.java:677)
	at java.sql.DriverManager.getConnection(DriverManager.java:228)
	at com.testjdbc.Main.testJDBC(Main.java:48)
	at com.testjdbc.Main.main(Main.java:57)
Caused by: java.lang.ClassCastException: com.mysql.cj.exceptions.CJException cannot be cast to com.mysql.cj.exceptions.UnableToConnectException
	at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:825)
	at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:448)
	... 6 more

```


[Main]: https://github.com/ederbaum/MySQLGraalVM/blob/master/src/main/java/com/testjdbc/Main.java
