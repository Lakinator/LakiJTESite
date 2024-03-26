# Laki JTE Site

See it running [here](https://jte.deepstackdriver.dev/)

## IntelliJ Configuration

- Make sure to select the right active profile in the application.properties file
- Select the jte-classes directory as generated sources-root directory

## Build Configuration

- Select prod profile in application.properties file
- run maven install

## Docker

The Docker image is available on [Docker Hub](https://hub.docker.com/r/lakinator/lakijtesite)
as `lakinator/lakijtesite`.

### Example `docker-compose.yml`

```yaml
version: '3.1'

services:
  lakijtesite:
    image: lakinator/lakijtesite:latest
    restart: always
    ports:
      - 8080:8080
    environment:
      TEST: test
    volumes:
      - /home/laki/data:/app/data
```