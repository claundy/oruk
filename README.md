# OpenReferrals UK REST API

A simple CRUD REST API implementation of the OpenReferrals UK specification using Spring Boot and MongoDB.

## Features

- **Organizations**: Manage organizations providing services
- **Locations**: Manage physical locations where services are provided
- **Services**: Manage services offered by organizations at specific locations

## Technology Stack

- Java 17
- Spring Boot 3.2.0
- Spring Data MongoDB
- Lombok
- Maven

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MongoDB 4.0+ (running on localhost:27017)

## Getting Started

### 1. Start MongoDB

```bash
# Using Docker
docker run -d -p 27017:27017 --name mongodb mongo:7 --volume mongodb:/data/db

# Or install MongoDB locally
```

### 2. Build the Application

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Endpoints

### Organizations

- `GET /api/organizations` - Get all organizations
- `GET /api/organizations/{id}` - Get organization by ID
- `GET /api/organizations/search?name={name}` - Search organizations by name
- `POST /api/organizations` - Create new organization
- `PUT /api/organizations/{id}` - Update organization
- `DELETE /api/organizations/{id}` - Delete organization

### Locations

- `GET /api/locations` - Get all locations
- `GET /api/locations/{id}` - Get location by ID
- `GET /api/locations/city/{city}` - Get locations by city
- `GET /api/locations/postalcode/{postalCode}` - Get locations by postal code
- `POST /api/locations` - Create new location
- `PUT /api/locations/{id}` - Update location
- `DELETE /api/locations/{id}` - Delete location

### Services

- `GET /api/services` - Get all services
- `GET /api/services/{id}` - Get service by ID
- `GET /api/services/search?name={name}` - Search services by name
- `GET /api/services/organization/{organizationId}` - Get services by organization
- `GET /api/services/location/{locationId}` - Get services by location
- `POST /api/services` - Create new service
- `PUT /api/services/{id}` - Update service
- `DELETE /api/services/{id}` - Delete service

## Example Requests

### Create Organization

```bash
curl -X POST http://localhost:8080/api/organizations \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Community Health Services",
    "description": "Providing healthcare to the community",
    "email": "info@healthservices.org",
    "url": "https://healthservices.org"
  }'
```

### Create Location

```bash
curl -X POST http://localhost:8080/api/locations \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Main Office",
    "address1": "123 High Street",
    "city": "London",
    "postalCode": "SW1A 1AA",
    "country": "UK",
    "latitude": 51.5074,
    "longitude": -0.1278
  }'
```

### Create Service

```bash
curl -X POST http://localhost:8080/api/services \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mental Health Support",
    "description": "Counseling and therapy services",
    "email": "mentalhealth@healthservices.org",
    "status": "active",
    "organization": {
      "id": "organization-id-here"
    },
    "location": {
      "id": "location-id-here"
    }
  }'
```

### Get All Services

```bash
curl http://localhost:8080/api/services
```

### Update Service

```bash
curl -X PUT http://localhost:8080/api/services/{service-id} \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mental Health Support - Updated",
    "description": "Expanded counseling and therapy services",
    "email": "mentalhealth@healthservices.org",
    "status": "active"
  }'
```

### Delete Organization

```bash
curl -X DELETE http://localhost:8080/api/organizations/{organization-id}
```

## Project Structure

```
src/main/java/uk/openreferrals/
├── OpenReferralsApplication.java
├── controller/
│   ├── OrganizationController.java
│   ├── LocationController.java
│   └── ServiceController.java
├── model/
│   ├── Organization.java
│   ├── Location.java
│   └── Service.java
├── repository/
│   ├── OrganizationRepository.java
│   ├── LocationRepository.java
│   └── ServiceRepository.java
└── service/
    ├── OrganizationService.java
    ├── LocationService.java
    └── ServiceService.java
```

## Data Models

### Organization
- id (String)
- name (String, required)
- description (String)
- email (String)
- url (String)
- logo (String)
- uri (String)
- createdAt (LocalDateTime)
- updatedAt (LocalDateTime)

### Location
- id (String)
- name (String, required)
- description (String)
- latitude (Double)
- longitude (Double)
- address1 (String)
- address2 (String)
- city (String)
- stateProvince (String)
- postalCode (String)
- country (String)
- createdAt (LocalDateTime)
- updatedAt (LocalDateTime)

### Service
- id (String)
- name (String, required)
- description (String)
- url (String)
- email (String)
- status (String)
- organization (DBRef to Organization)
- location (DBRef to Location)
- createdAt (LocalDateTime)
- updatedAt (LocalDateTime)

## Configuration

Database configuration can be modified in `src/main/resources/application.yaml`

## Development Notes

- All entities automatically track creation and update timestamps
- Validation is implemented using Jakarta Bean Validation
- MongoDB DBRef is used to maintain relationships between entities
- Search functionality uses case-insensitive pattern matching

## Future Enhancements

- Add authentication and authorization
- Implement pagination for list endpoints
- Add more complex search and filtering options
- Include contact information and service areas
- Add support for taxonomy and eligibility criteria
- Implement API versioning
- Add comprehensive error handling and custom exceptions
- Include API documentation with Swagger/OpenAPI

## License

This project is provided as-is for demonstration purposes.