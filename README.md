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
 <li> Following the MVC framework I separated my methods into a Price Class, PriceController, PriceService and PriceRepository. 
   <li>In the PriceService I have a methods that parse CSV data of various currencies/instruments into Price objects and adjusts incoming prices with a commission. The commission is as follows:(-0.1% for bid price, +0.1% for ask price) All prices are rounded up to 4 decimal places.
<li>The PriceController uses different REST endpoints to retrieve only the latest price according to each instrument name.
<br>
  <img src="https://user-images.githubusercontent.com/37534696/172996666-3ee29d3f-a565-4c82-a581-f9f23c58a85b.png"/>
  <br>
<li>The API is designed so via a user interface, a user can save selected prices to a database to access again later using a PriceRepository.
  
  # Testing
  I created separate test files for the PriceController and PriceService
  <br>
  I attempted to use Mockito as part of my testing process, but this created many errors. Mockito appears to be used with dummy/mock data, but in this case I already had data to use and test. Due to time constraints I removed my Mockito code to keep my code clean, and chose to do continue my unit tests in JUnit. Unit Testing was done with JUnit to test the following cases:
 <li> That prices are being processed in sequence and none are missing
 <li> That only the latest price for a given instrument is stored (and client can not see older prices)
  <li> Each price is validated to ensure that bid < ask and that the commission has been applied correctly
    
 Integration Testing done with Postman to ensure that all REST endpoints worked effectively.
                                                                                                              
 Proposed strategy for E2E testing:
 For E2E automation testing I think Mockito and Selenium would be the right test automation frameworks to use. Can be used to automate the Mockito tests, and automate the Postman tests without us having to manually do it each time the API code is altered.
                                                       
 
                                                       
 
