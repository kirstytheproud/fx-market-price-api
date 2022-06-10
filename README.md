# FX Market Price Handler API
# Brief


This was created using the following tech stack:
<li>Java
  <li>Spring Boot
    <li>Maven
      <li>MySQL
        <li>JUnit
          <li>Postman

            
# Process
   <li> Parses CSV data of various currencies/instruments into Price objects
<li> Uses different REST endpoints to retrieve the only the latest price according to instrument name
<li> Incomng prices are adjusted with commission (-0.1% for bid price, 0.1% for ask price)
  
<br>
  <img src="https://user-images.githubusercontent.com/37534696/172996666-3ee29d3f-a565-4c82-a581-f9f23c58a85b.png"/>
  <br>
<li> Designed so via a UI, a user can save selected prices to a database to access again later using a PriceRepository
  
  
  # Testing
 
  Unit Testing done with JUnit
Integration Testing done with Postman
