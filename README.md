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

**IntelliJ**

If using Intellij `Application` can be run directly from the main method. Edit configurations to alter the test file used.

### Test Output

| Test Case          | Filename         | Output            |
|--------------------|------------------|-------------------|
| Move               | `testInput1.txt` | Output: 0,1,NORTH |
| Rotate             | `testInput2.txt` | Output: 0,0,WEST  |
| Move & Rotate      | `testInput3.txt` | Output: 3,3,NORTH |
| Multiple Placement | `testInput4.txt` | Output: 1,0,EAST  |
| Invalid Movement   | `testInput5.txt` | Output: 0,0,WEST  |
| Invalid Placement  | `testInput6.txt` | Output: 0,1,NORTH |
