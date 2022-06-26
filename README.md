# flight-search-service

## Spring Boot Application

####Endpoints:
<p><b>GET  http://localhost:8084/flight-search-service/swagger-ui.html</b></br>
Swagger API documentation</p>



<p><b>GET /flights/{date}</b></br>
Retrieves the Flight details.</br>
Input Date format is: YYYY-mm-DD</br>
ex: 2022-06-27
</p>


#### How to test and run the application?
You need to have the following softwares in your system
<ul>
<li>Java 8</li>
<li>Maven 3.x.x</li>
</ul>

<br/>
To run the tests, go to the parent directory and run <b>mvn clean test</b>
<br/>

<br/>
To run the application, go to the parent directory and run <b>mvn spring-boot:run</b>
<br/>