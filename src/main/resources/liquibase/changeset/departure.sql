-- liquibase formatted sql

-- changeset garry:3
CREATE TABLE departure (
    departure_number           VARCHAR(50) NOT NULL PRIMARY KEY,
    departure_airport_id    BIGINT NOT NULL REFERENCES airport,
    arrival_airport_id      BIGINT NOT NULL REFERENCES airport,
    airline_id              BIGINT NOT NULL REFERENCES airline,
    departure_date          TIMESTAMP NOT NULL,
    arrival_date            TIMESTAMP NOT NULL
);