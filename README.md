# FleetOps - Notification Service

Part of the **FleetOps Fleet & Logistics Dispatch System**, submitted for the
Enterprise Cloud Architecture (ITS 2130) capstone project.

## Student Information
- **Name:** K.D. Chanuth Dewhan
- **Student ID:** 241722017
- **Slack Handle:** @chanuthdewhan
- **GCP Project ID:** fleet-ops-506803

## Project Description
A lightweight notification log for the FleetOps system. Receives
notification events from the Order & Dispatch and Trip & Telemetry services
whenever a significant state change occurs — an order is created, a trip
starts, or a delivery completes — and exposes them to the frontend as a
per-role notification feed. Deliberately kept simple: its role is to
demonstrate genuine inter-service communication and give dispatchers and
drivers visibility into system activity, not to carry complex business
logic of its own.

## Technology Stack
- Java 25
- Spring Boot 4.1
- Spring Data MongoDB
- Spring Cloud Config Client, Eureka Client
- Lombok
- RFC 9457 Problem Details for structured error responses

## Setup / Getting Started

```bash
git clone https://github.com/chanuthdewhan/fleetops-notification-service.git
cd fleetops-notification-service
./mvnw spring-boot:run
```

Runs on port `8002` locally. Requires `fleetops-service-registry` and
`fleetops-config-server` running first, along with a local MongoDB instance.

## Key Endpoints
- `POST /api/v1/notifications` — internal, called by other services
- `GET /api/v1/notifications?recipientRole={role}&read={bool}`
- `PATCH /api/v1/notifications/{id}/read`

## Live Deployment
- **GCP Project ID:** fleet-ops-506803
- **Region:** asia-southeast1
- **Deployment model:** IaaS — Compute Engine, managed via PM2
- **Accessed via API Gateway:** http://34.21.225.166:80