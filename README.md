# NasserProvider

## Overview
This project, **NasserProvider**, is a Spring Boot application designed to interact with multiple providers for sending SMS messages. It features scheduled SMS sending and interacts with providers using REST APIs.

## Features
- Scheduled SMS sending every 30 seconds.
- Uses `RestTemplate` to interact with two providers.
- Stores SMS messages and other details like phone numbers and message content in an H2 database.
- Includes a CRUD system for managing `RequestPayload` entities.
- Full Swagger/OpenAPI documentation for API endpoints.