# pawshake-saga
2023 Unitec project

Reference web site for modeling
- https://www.pawshake.co.nz/
 
Prerequisite
- Install and run Docker
- Create User, Pet, Sitter data

Applications
- pawshake-pet : Normal web application
- pawshake-review : Normal web application
- pawshake-saga-payment : Saga participant application
- pawshake-saga-reservation : Saga participant application
- pawshake-saga-sitter : Saga participant application
- pawshake-saga-user  : Saga orchestration/participant application

How to run
1. cd eventuate-cdc
2. docker-compose up
3. run application : User, Reservation, Sitter, Payment
4. Orchestration saga Test : POST http://localhost:8081/api/v1/user/pay
5. Choreography saga Test : POST http://localhost:8081/api/v1/user/choreography/pay


Reference sources
- https://github.com/msa-school/lab-shop-eventuate-orchestration/tree/main
- https://github.com/jinyoung/lab-shop-eventuate
- https://github.com/eventuate-tram/eventuate-tram-sagas-examples-customers-and-orders
- https://github.com/eventuate-tram/eventuate-tram-examples-customers-and-orders
