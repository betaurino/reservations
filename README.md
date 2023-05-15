# Coherent Test Task
## _Hotel Reservations._

This is a java rest service which provides the basic functionality to create and manage reservations for hotel rooms.

## Features
- Create new reservations.
- Unique id generation for each reservation.
- Read all current reservations.
- Update a specific reservation.
- Persist reservation repository to the file system when the app stops, and restore the reservations when the app starts.

## Tech

This app uses the following technologies:

- Java 17
- Spring boot 2.7
- Gradle 8.1

## Installation

Download the code in your local machine:

```sh
git clone https://github.com/betaurino/reservations.git
```

#### Building and running
Run gradle build to download the dependencies and build the application:
```sh
gradle build
```

For running the application:
```sh
./gradlew bootRun
```

Get all reservations:
```sh
.curl --location 'http://localhost:8080/hotel/reservations'
```

Create a new reservation:
```sh
curl --location 'http://localhost:8080/hotel/reservations' \
--header 'Content-Type: application/json' \
--data '{
    "clientFullName": "Roberto Ruiz",
    "roomNumber": "701",
    "reservationDates": [
        "2020-12-01",
        "2020-12-31"
    ]
}'
```

Update a reservation:
```sh
.curl --location --request PUT 'http://localhost:8080/hotel/reservations/2626' \
--header 'Content-Type: application/json' \
--data '{
    "clientFullName": "Roberto Ruiz",
    "roomNumber": "707",
    "reservationDates": [
        "2020-12-01",
        "2020-12-31"
    ]
}'
```

## API documentation

The API documentation has been build using spring boot and swagger, you can find it by running the application and following the next link:
```sh
http://localhost:8080/swagger-ui/index.html
```
