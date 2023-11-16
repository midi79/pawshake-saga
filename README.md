# pawshake-saga
2023 Unitec project

Reference web site for modeling
- https://www.pawshake.co.nz/

Modeling
<img width="1585" alt="스크린샷 2023-11-08 오후 11 30 30" src="https://github.com/midi79/pawshake-saga/assets/19512435/935573e7-be9c-4232-be91-974509cb108d">
- https://labs.msaez.io/#/storming/pawshake
 
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
6. If the Saga process succeeds, Payment status and Reservation status should match, indicating a successful and synchronized transaction.


Reference sources
- https://github.com/msa-school/lab-shop-eventuate-orchestration/tree/main
- https://github.com/jinyoung/lab-shop-eventuate
- https://github.com/eventuate-tram/eventuate-tram-sagas-examples-customers-and-orders
- https://github.com/eventuate-tram/eventuate-tram-examples-customers-and-orders
