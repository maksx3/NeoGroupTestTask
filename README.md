## Requirements 
* Installed MySQL
* Installed Maven
* Installed Java 21

## Hot to start project?
* In `src/main/resources/application.properties` specify DB connection
* In root project directory run `mvn clean install`
  * If multiple Java-s are installed use ``JAVA_HOME=`/usr/libexec/java_home -v 21` mvn clean install``
* To run test use `mvn test`
  * If multiple Java-s are  installed use ``JAVA_HOME=`/usr/libexec/java_home -v 21` mvn test``
* To run test with report use `mvn surefire-report:report`
  * Report is located in `/target/site/surefire-report.html`
  * If multiple Java-s are  installed use ``JAVA_HOME=`/usr/libexec/java_home -v 21` mvn surefire-report:report``
* To start project use `mvn spring-boot:run`
  * If multiple Java-s are  installed use ``JAVA_HOME=`/usr/libexec/java_home -v 21` mvn spring-boot:run``

## Main page
* Link http://localhost:8088/