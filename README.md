# code test

Using the following JSON feed:

http://jsonplaceholder.typicode.com/posts

Create REST endpoints that reads the above JSON feed using HTTP. The service should perform the following tasks: 

## Count endpoint :
Tally the number of unique user Ids in the JSON and return in a JSON response.

## Updated User List endpoint :
 Modify the 4th JSON array item, changing the title and body of the object to “1800Flowers”. Return the modified JSON object to the controller class from the service then in the endpoint JSON response.

Unit tests Should be runnable via “mvn test” Should be written to test all aspects of the application (include mock of the feed).

##Requirements 
- Use Java 1.8+ 
- Use Spring Boot 
- Use Maven 
- Use JUnit and Mockito 

All dependencies should be publicly available or properly included with the project and referenced within the POM Be creative, have fun and may the force be with you