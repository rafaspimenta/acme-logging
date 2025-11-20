# Acme Logging

A Spring Boot custom starter demonstrating auto-configuration patterns.

## Project Structure

This project showcases the standard Spring Boot starter architecture:

- **acme-logging** - Core library containing `AcmeLogger` and `LogLevel` classes
- **acme-logging-spring-boot-autoconfigure** - Auto-configuration module that configures `AcmeLogger` beans
- **acme-logging-spring-boot-starter** - Starter module that imports the auto-configuration

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

Configure the log level via `application.properties`:

```properties
acme.logging.level=INFO
```

Supported levels: `DEBUG`, `INFO`, `WARN`, `ERROR`

