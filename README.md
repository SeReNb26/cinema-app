# Cinema-app
![taxi](https://businessvisit.com.ua/wp-content/uploads/2017/02/VO-cinema.jpg)
<hr>
This project is an example of a simple web program for buying movie tickets. Built on a 3-tier architecture (Dao, Service, Controller)<br><br> 
The project supports the following functionality: <br><br>
<li>Registration and Login. Endpoints - ("/register", "/login"). For non-authorized users only</li>
<li>Show all cinema halls. Endpoint - (HttpMethod.GET, "/cinema-halls"). For user and admin roles</li>
<li>Add new cinema hall. Endpoint - (HttpMethod.POST, "/cinema-halls"). For admin role</li>
<li>Show all movies. Endpoint - (HttpMethod.GET, "/movies"). For user and admin roles</li>
<li>Show available movie sessions on a given day as parameter. Endpoint - (HttpMethod.GET, "/movie-sessions/available"). For user and admin roles</li>
<li>Add new movie session. Endpoint - (HttpMethod.POST, "/movie-sessions"). For admin role</li>
<li>Update movie session. Endpoint - (HttpMethod.PUT, "/movie-sessions/{id}"). For admin role</li>
<li>Delete movie session. Endpoint - (HttpMethod.DELETE, "/movie-sessions/{id}"). For admin role</li>
<li>Show all orders. Endpoint - (HttpMethod.GET, "/orders"). For user role</li>
<li>Complete order. Endpoint - (HttpMethod.POST, "/orders/complete"). For user role</li>
<li>Add movies session to shopping cart. Endpoint - (HttpMethod.POST, "/shopping-carts/movie-sessions"). For user role</li>
<li>Show all movies in shopping cart. Endpoint - (HttpMethod.GET, "/shopping-carts/by-user"). For user role</li>
<li>Get user by login (email). Endpoint - (HttpMethod.GET, "/users/by-email"). For admin role</li>
<hr>

## Technologies
<hr>
<li>Spring(Core, MVC, Security)</li>
<li>Hibernate</li>
<li>Apache Tomcat</li>
<li>Apache Maven</li>
<li>Data Base: MySQL</li>
<hr>

## Instructions for launching
<hr>
1. Copy the project into your IDE <br>
2. Add tomcat configuration <br>
3. Install MySQL & Workbench <br>
4. Create new schema with name "spring" <br>
5. Go to db.properties file and change login and password to your own <br>
6. Run the program <br>
7. Test all functionality in Postman or other webclient