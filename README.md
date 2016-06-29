# springboot-restclient

This program is Spring Boot , RestTemplate client which invokes the weather service and displays the result.

Use Application.java to start the SpringBoot application. This starts an embedded Tomcat server which serves the form to input the City.
 
Thymeleaf template has been used for the front-end, on submission of the form the request is sent to api.openweathermap.org and results are displayed on the form.

If the webservice resturns an error it would be displayed on the form.

In case of an exception the user would be forwarded to a generic exception page.

Following technologies have been used -
1) SpringBoot
2) Thymeleaf templates
3) Maven
4) Spring Test
5) Jackson ObjectMapper