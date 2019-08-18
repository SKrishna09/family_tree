# family_tree

mvn clean install -Dmaven.test.skip=true
ls target/*.jar
java -jar target/geektrust.jar

mvn package -Dmaven.test.skip=true
ls target/*.jar
java -jar target/familytree-0.0.1-SNAPSHOT.jar
mvn test -Dtest=TestRelationShip
mvn test -Dtest=TestCreateChild
