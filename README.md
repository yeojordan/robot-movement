## Robot Movement Simulator

### Usage

**Building an executable fat jar**

````
mvn clean compile package
````

**Running the application**

````
java -jar target/robot-movement-1.0-SNAPSHOT-jar-with-dependencies.jar <test-file>
````

**Modifying the test file**
* `test-file` can be swapped with any of the file in `src/main/java/resources/`
* Existing test files can be modified or added. If added the executable must be rebuilt.

**Running unit tests**

Unit tests are included for `ActionRunner` and ` Position`

````
mvn test
````
