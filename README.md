# REST and HTTP
https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate

REST builds on top of HTTP (Hypertext Transfer Protocol). HTTP is the language of the web.

## HTTP has a few important verbs.
```
POST - Create a new resource
GET - Read a resource
PUT - Update an existing resource
DELETE - Delete a resource
```
## HTTP also defines standard response codes.
```
200 - SUCESS
404 - RESOURCE NOT FOUND
400 - BAD REQUEST
201 - CREATED
401 - UNAUTHORIZED
415 - UNSUPPORTED TYPE - Representation not supported for the resource
500 - SERVER ERROR
```
## Restful Service Constraints

>Client - Server : There should be a service producer and a service consumer.

>The interface (URL) is uniform and exposing resources. Interface uses nouns (not actions)

>The service is stateless. Even if the service is called 10 times, the result must be the same.

>The service result should be Cacheable. HTTP cache, for example.

>Service should assume a Layered architecture. Client should not assume direct connection to server - it might be getting info from a middle layer - cache.