# MovieApp

A Spring Boot application for managing movie playlists and fetching movie data from The Movie Database (TMDB) API. This project was developed as part of the Teads Summer School program.

## Features

- **Movie Discovery**: Fetch popular movies from TMDB API
- **Movie Search**: Search movies by name
- **Movie Details**: Get detailed information about specific movies
- **Streaming Providers**: Find where movies are available to stream
- **Movie Videos**: Get trailers and videos for movies
- **Playlist Management**: Create and manage movie playlists
- **Database Storage**: Save movies to playlists in PostgreSQL database
- **Monitoring & Observability**: Integrated with Prometheus, Grafana, and ELK stack

## Architecture

The application follows a layered architecture:

- **Controllers**: REST API endpoints for handling HTTP requests
- **Services**: Business logic for movie operations and data processing
- **Repositories**: Data access layer for database operations
- **Entities**: JPA entities for database mapping
- **Client**: External API client for TMDB integration

### Tech Stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **Database**: PostgreSQL with pgvector extension
- **Monitoring**: Prometheus, Grafana, Elasticsearch, Kibana, Filebeat
- **Containerization**: Docker & Docker Compose
- **Build Tool**: Maven

## Quick Start

### Prerequisites

- Java 21
- Maven
- Docker & Docker Compose

### Running with Docker Compose

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   cd MovieApp
   ```

2. **Start all services**

   ```bash
   docker-compose up -d
   ```

3. **Build and run the application**
   ```bash
   mvn clean package
   java -jar target/MovieApp-0.0.1-SNAPSHOT.jar
   ```

The application will be available at `http://localhost:8080`

### Running Locally

1. **Start the database and monitoring stack**

   ```bash
   docker-compose up -d postgres prometheus grafana elasticsearch kibana filebeat
   ```

2. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

## Monitoring & Observability

The application includes comprehensive monitoring:

- **Prometheus**: Metrics collection at `http://localhost:9090`
- **Grafana**: Dashboards at `http://localhost:3000` (admin/admin)
- **Elasticsearch**: Log aggregation at `http://localhost:9200`
- **Kibana**: Log visualization at `http://localhost:5601`

### Available Metrics

- `search_results`: Counter for movie searches
- `search_timer`: Timer for search operations
- Spring Boot actuator metrics

## API Endpoints

### Movies

- `GET /api/movies` - Get popular movies
- `GET /api/movies/n/{name}` - Search movies by name
- `GET /api/movies/{id}` - Get movie details
- `GET /api/movies/{id}/streaming` - Get streaming providers
- `GET /api/movies/{id}/videos` - Get movie videos
- `POST /api/movies/save/{id}?i={playlistId}` - Save movie to playlist

### Playlists

- `GET /api/playlists` - Get user playlists
- `POST /api/playlists` - Create new playlist
- `GET /api/playlists/{id}` - Get playlist by ID
- `GET /api/playlists/{id}/movies` - Get movies in playlist

### Health & Monitoring

- `GET /actuator/health` - Application health check
- `GET /actuator/metrics` - Application metrics
- `GET /actuator/prometheus` - Prometheus metrics endpoint

## Database Schema

The application uses PostgreSQL with the following main entities:

- **MovieEntity**: Stores movie information and metadata
- **PlaylistEntity**: Manages user playlists
- **Provider**: Streaming service information
- **MovieVideo**: Video content for movies

## Configuration

### Environment Variables

- `api.auth.key`: TMDB API authentication token
- `spring.datasource.url`: Database connection URL
- `spring.datasource.username`: Database username
- `spring.datasource.password`: Database password

### Profiles

- **default**: Development configuration with H2 database
- **production**: Production configuration with PostgreSQL

## Logging

The application uses structured logging with Logback and Logstash encoder. Logs are:

- Written to `logs/application.log`
- Archived daily to `logs/archived/`
- Forwarded to Elasticsearch via Filebeat

## Testing

Run tests with:

```bash
mvn test
```

## Docker

### Building the Image

```bash
docker build -t movieapp .
```

### Running the Container

```bash
docker run -p 8080:80 movieapp
```

## 📄 License

This project is part of the Teads Summer School program.

## External Dependencies

- **The Movie Database (TMDB) API**: For movie data and metadata
- **PostgreSQL**: Primary database
- **Prometheus**: Metrics collection
- **Grafana**: Metrics visualization
- **Elasticsearch**: Log aggregation
- **Kibana**: Log visualization
