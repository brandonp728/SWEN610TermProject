# WebCheckers

An online Checkers game system built in Java 8 and Spark, a web
microframework.

## Team
- Brian Kelly (Supreme Leader)

- Pierce Sams

- Brandon Palonis


## Prerequisites

- Java 8

- Maven

- PostgreSQL (install below)


## How to run it

1. Clone the repository and go to the root directory.

2. Execute `mvn compile exec:java`

3. Open in your browser `http://localhost:4567/`

4. Start a game and begin playing.

## Steps to start the database
1. Download PostgreSQL from here and install the file
2. During installation set password. This will be used for the PostgreSQL superuser postgres which will be used at all times when making a connection
3. Sign in at the command line using this (you will be prompted for your password):
```
  psql -U postgres
```

4) Create the database with the command. Don't forget the semicolon, it needs to be on all database commmands in the psql program:
  ```sql
    CREATE DATABASE webcheckers;
  ```

5) Type the following to quit:
  ```
    \q
  ```

6) #### For this part you must be in the same folder as the db-create.sql file.
Run the creation script with the command (This runs the file on the sam2020 database and creates the specified tables):
```
  psql -U postgres -f db-create.sql webcheckers
```

7) Connect to the database using:
  ```
    psql -U postgres webcheckers
  ```

8) Type this to see all data tables in the database:
  ```
  \dt
  ``` 
  To run sql commands in the psql console they must end in a semicolon (;)

### Setting it up in Java:
1) Download the postgresql jar file here: https://jdbc.postgresql.org/download.html

2) Move the Jar file to the root folder of the Maven Project

3) Run this command:
```   
  mvn install:install:file -Dfile=postgresql-42.2.8.jar -DgroupId=com.webcheckers -DartifactId=postgresql -Dversion=42.2.8 -Dpackaging=jar
```

4) Add this to pom.xml in the dependency tag
```xml
     <dependency>
        <groupId>com.webcheckers</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.2.8</version>
     </dependency>
```



## License
MIT License

See LICENSE for details.
