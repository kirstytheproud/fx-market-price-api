# FX Market Price Handler API
1. Parses CSV data of various currencies/instruments into Price objects
2. Uses different REST endpoints to retrieve the only the latest price according to instrument name
3. Incomng prices are adjusted with commission (-0.1% for bid price, 0.1% for ask price)
4. Designed so via a UI, a user can save selected prices to a database to access again later
5. Unit Testing done with JUnit
