# InsuranceManagementPlatform
A simple insurance management system

*To run this application create a database with a name : insurancemanagementPlatform
and port number :8181
*Used Spring Data JPA to create repositories for the domain models and interact with the
embedded database or mysql
*Implemented exception handling and validation to ensure proper API usage and data
integrity
*used embedded tomcat server

Implemented RESTful APIs for the following actions:
a. Clients:
i. GET /api/clients: Fetch all clients.
ii. GET /api/clients/{id}: Fetch a specific client by ID.
iii. POST /api/clients: Create a new client.
iv. PUT /api/clients/{id}: Update a client's information.
v. DELETE /api/clients/{id}: Delete a client.
b. Insurance Policies:
i. GET /api/policies: Fetch all insurance policies.
ii. GET /api/policies/{id}: Fetch a specific insurance policy by ID.
iii. POST /api/policies: Create a new insurance policy.
iv. PUT /api/policies/{id}: Update an insurance policy.
v. DELETE /api/policies/{id}: Delete an insurance policy.
c. Claims:
i. GET /api/claims: Fetch all claims.
ii. GET /api/claims/{id}: Fetch a specific claim by ID.
iii. POST /api/claims: Create a new claim.
iv. PUT /api/claims/{id}: Update a claim's information.
v. DELETE /api/claims/{id}: Delete a claim
