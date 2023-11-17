# pawshake-saga
## 2023 Unitec project

### Reference web site for modeling
- https://www.pawshake.co.nz/

### Modeling
<img width="1585" alt="스크린샷 2023-11-08 오후 11 30 30" src="https://github.com/midi79/pawshake-saga/assets/19512435/935573e7-be9c-4232-be91-974509cb108d">
- https://labs.msaez.io/#/storming/pawshake
 
### Prerequisite
- Install and run Docker
- Create User, Pet, Sitter data

### Applications
- pawshake-pet : Normal web application
- pawshake-review : Normal web application
- pawshake-saga-payment : Saga participant application
- pawshake-saga-reservation : Saga participant application
- pawshake-saga-sitter : Saga participant application
- pawshake-saga-user  : Saga orchestration/participant application

### How to run
1. cd eventuate-cdc
2. docker-compose up
3. run application : User, Reservation, Sitter, Payment
4. Orchestration saga Test : POST http://localhost:8081/api/v1/user/pay
5. Choreography saga Test : POST http://localhost:8081/api/v1/user/choreography/pay
6. If the Saga process succeeds, Payment status and Reservation status should match, indicating a successful and synchronized transaction.

### How to create sample data
- User : POST http://localhost:8081/api/v1/user/create
```
{
    "name":"Alice",
    "status":"EMPTY",
    "address": "Auckland, New Zealand",
    "email":"alice99@gmail.com",
    "phone":"027-999-0000"
}
```
- Sitter : POST http://localhost:8083/api/v1/sitter/create
```
{
    "name":"Anderson",
    "status":"EMPTY",
    "address":"Great North Road, Waterview, Auckland, New Zealand",
    "email":"anderson9990@gmail.com",
    "phone":"027-888-0000",
    "serviceType":"Board",
    "price":50,
    "availableTime":"Daytime",
    "introduce":"I have experience about 5 years for pet sitting!",
    "experience":5,
    "language":"Korea,English"
}
```
- Pet : POST http://localhost:8082/api/v1/pet/create
```
{
    "name":"Black",
    "userId":1,
    "birthYear":"2020",
    "breed":"poodle",
    "size":"small",
    "gender":"female",
    "characteristic":"Kind,Shy,Cute"
}
```

### Reference sources
- https://github.com/msa-school/lab-shop-eventuate-orchestration/tree/main
- https://github.com/jinyoung/lab-shop-eventuate
- https://github.com/eventuate-tram/eventuate-tram-sagas-examples-customers-and-orders
- https://github.com/eventuate-tram/eventuate-tram-examples-customers-and-orders
