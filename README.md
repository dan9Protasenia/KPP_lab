# Introduction to Cross-Platform Programming on Java

# Option 18 
## 1.Prime Check
##### Flow:
##### •	When: User inputs value to “Число” input field
##### •	Then: Presses “Проверить” button
##### •	And: «Да/Нет» value appears in “Простое” text field
##### •	And: «Да/Нет» value appears in “Четное” text field
 
![image](https://user-images.githubusercontent.com/100715839/171071351-f7bc17eb-28e2-47d1-906e-5568fc36b8ab.png)
___
## 2.EXCEPTIONS AND ERROR HANDLING
##### 1. Add validation for the input parameters returning 400 HTTP error in case of empty or incorrect params provided
##### 2. Add internal errors handling returning 500 HTTP error code in case of internal service exception/error
##### 3. Add logging of all process steps and errors (use different log levels for errors and debug messages)
##### 4. Add unit test for your service checking happy path and exceptional cases
___
## 3.COLLECTIONS
##### Add simple cache for your service as in-memory Map where key is an input parameter and value is calculation results. This Map (cache) should be stored as a separate class (bean). Use dependencies injection mechanism of Spring Framework (autowiring) for adding cache to your service.
##### Web service should check cache to get calculation results from it first, if there are no calculation results for input parameter yet, do the calculation and put it into the cache before returning results in response.
___ 
## 4.CONCURRENCY
##### 1. Add a new service (Counter) which calculates number of your main service calls and returns the number when requested. Counter should be implemented as a separate thread safe bean with synchronized access.
##### 2. Create high load test for your main service using JMeter, Postman or any other tool. The load test should make thousands of calls in short period of time. Then make sure that Counter correctly calculates number of service calls done by the load test.
___
## 5.FUNCTIONAL PROGRAMMING IN JAVA 8
##### In scope of this practical task we need to try functional programming approach using Java 8 new features:
##### •	Update initial service created in first practical task to have ability to process sequence (stream) of input parameters. Stream API and lambdas should be used for this.
##### •	Add new POST method which should get sequence of input parameters (they can be passed as JSON data in request body, or as simple CSV file), validate them and call new service for processing bulk data. Result can be returned as JSON or CSV file.
___
## 6.AGGREGATE OPERATIONS IN JAVA 8
##### In previous task we did bulk operation for a stream of input data. In this task we need to apply some statistics calculation using aggregation/reduction. Calculated statistic should be added into POST response data (either JSON or CSV file). Statistics should include: 
##### •	Total amount of input parameters (or pairs/triples of parameters) provided
##### •	Total amount of input parameters (or pairs/triples of parameters) which produced incorrect result (were not valid)
##### •	Maximum and minimum values from results calculated
##### •	Result which was returned most times (most popular)
___



