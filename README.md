# Draft Demo Application

## Prerequisites
- Docker and Docker Compose
- Java 24
- Maven

## Running the Database

Start the PostgreSQL database using Docker Compose:

```bash
docker-compose up -d
```

The database will be available on port **5433** (to avoid conflict with other PostgreSQL instances).

To stop the database:

```bash
docker-compose down
```

To stop and remove all data:

```bash
docker-compose down -v
```

## Running the Application

Once the database is running, start the Spring Boot application:

```bash
./mvnw.cmd spring-boot:run
```

## API Endpoints

- `GET /api/drafts/{id}` - Fetch a draft by ID

Example:
```bash
curl http://localhost:8080/api/drafts/1
```

## Database Configuration

- **Host**: localhost
- **Port**: 5433
- **Database**: draftdb
- **Username**: draftuser
- **Password**: draftpass
services:
  postgres:
    image: postgres:16
    container_name: draft-postgres
    environment:
      POSTGRES_DB: draftdb
      POSTGRES_USER: draftuser
      POSTGRES_PASSWORD: draftpass
    ports:
      - "5433:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U draftuser -d draftdb"]
      interval: 10s
      timeout: 5s
      retries: 5

volumes:
  postgres_data:

