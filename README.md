# Orbit: Carer Management Platform
<img alt="TransparentLogo" src="https://user-images.githubusercontent.com/68750584/219557422-e9f048b4-2910-4c5b-b724-faf8792d4d9c.png" height="200"/>

This is the backend of our teams capstone project 'Orbit'. It is a platform designed to help users (carers) organise and manage the needs individuals under their care and allows a collaborative capabalility with other family members that also care for that individual.

## Tech Stack :
- Intellij, JDK 17
- Spring Boot
- PostgresSQL


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

## Entity-Relationship Diagram



<img alt="ERD" src="https://user-images.githubusercontent.com/68750584/219558606-b2867198-30b5-484f-85ab-77b9b6ad332d.png" height="500"/>

<h4> The classes
  `User` and `Caree` will be connected via the many-to-many relationship they each have with `Need`. 
</h4>

## UML Diagram
<img alt="UML" src="https://user-images.githubusercontent.com/68750584/219558998-030767ec-eca4-4c51-808f-b25966e0f809.png" height="500"/>
