# Acme Logging

A Spring Boot custom starter demonstrating auto-configuration patterns.

## Project Structure

This project showcases the standard Spring Boot starter architecture:

- **acme-logging** - Core library containing `AcmeLogger` and `LogLevel` classes
  - GitHub repo: https://github.com/rafaspimenta/acme-logging (this repo)
- **acme-logging-spring-boot-autoconfigure** - Auto-configuration module that configures `AcmeLogger` beans
  - GitHub repo: https://github.com/rafaspimenta/acme-logging-spring-boot-autoconfigure
- **acme-logging-spring-boot-starter** - Starter module that imports the auto-configuration
  - GitHub repo: https://github.com/rafaspimenta/acme-logging-spring-boot-starter

## Usage

Add the starter dependency to your Spring Boot application:

```xml
<dependency>
    <groupId>com.pimenta</groupId>
    <artifactId>acme-logging-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

The `AcmeLogger` bean will be automatically configured and available for injection.

## Configuration

Configure via `application.properties` or `application.yml`:

```properties
acme.logging.enabled=true
acme.logging.level=INFO
```

**Supported log levels**: `DEBUG`, `INFO` (default), `WARN`, `ERROR`

## Requirements

- Java 25+
- Spring Boot 4.0.0+
