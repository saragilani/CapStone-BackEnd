# Orbit: Carer Management Platform
<img alt="TransparentLogo" src="https://user-images.githubusercontent.com/68750584/219557422-e9f048b4-2910-4c5b-b724-faf8792d4d9c.png" height="200"/>
<h1 align="center" >Orbit</h1>

---

This is the backend of our teams capstone project 'Orbit'. It is a platform designed to help users (carers) organise and manage the needs individuals under their care and allows a collaborative capabalility with other family members that also care for that individual.

The platform allows users to set up profiles for individuals under their care. 
- The caree profiles have important information about the individual including a bio, and `needsList`.
- These profiles can then be shared with other users using a `uniqueId`. 
- All carers connected to the caree profile are able to edit the profile and more specifically add/remove and assign themselves a need from the `needsList`.
## Tech Stack :

---
- Intellij IDE, JDK 17
- Spring Boot
- PostgresSQL
- Postico
- Postman


### Spring Initializr

The backend API was created with Spring Boot using the following:

- Project: Maven
- Language: Java 17.0.5
- Dependencies:
  - Spring Web
  - Spring Boot DevTools 
  - Spring Data JPA
  - Spring Security
  - PostgreSQL Driver

## Installation 

---
Within your terminal...

Clone the project:

```
  git clone git@github.com:saragilani/CapStone-BackEnd.git
```
Create a local database named 'orbit':
```
  createdb orbit
```
Ensure postgresql is also installed using this command:
```a
    brew install postgresql
```

You can now open the API within intelliJ and run it in the file named 'OrbitApplication'

## Entity-Relationship Diagram

---

<img alt="ERD" src="https://user-images.githubusercontent.com/68750584/219558606-b2867198-30b5-484f-85ab-77b9b6ad332d.png" height="500"/>

The classes `User` and `Caree` will be connected via the many-to-many relationship they each have with `Need`.

## UML Diagram

---

<img alt="UML" src="https://user-images.githubusercontent.com/68750584/219558998-030767ec-eca4-4c51-808f-b25966e0f809.png"/>

Here we see the structure in which we designed the API to allow us to manipulate the classes within our database. Included is a `controller`, `service`, `model` and `repository` class each for `Caree`, `Need` and `User`. 

## Routes 

---
 localhost:8080...

| HTTP Request Path | Request Type | Description        |
|:-----------------:|:-------------|:-------------------|
|     .../user      | GET          | Display all users  |
|    .../user/1     | GET          | Find user by id    |
|     .../users     | POST         | Add new user       |
|    .../user/1     | DELETE       | Delete user        |
|    .../user/1     | PATCH        | Update user        |
|    .../carees     | GET          | Display all carees |
|   .../carees/1    | GET          | Find caree id      |
|    .../carees     | POST         | Add a new caree    |
|   .../carees/1    | DELETE       | Remove a caree     |
|   .../carees/1    | PATCH        | Update caree       |
|     .../needs     | GET          | Display all needs  |
|    .../needs/1    | GET          | Find a need by id  |
|     .../needs     | POST         | Add a new need     |
|    .../needs/1    | DELETE       | Remove a need      |
|    .../needs/1    | PATCH        | Update a need      |

