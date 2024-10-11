-- liquibase formatted sql

--changeset IBor:1
CREATE TABLE wallet (
    wallet_id UUID Primary Key,
    operation_type VARCHAR(10) CHECK (operation_type IN ('DEPOSIT', 'WITHDRAW')),
    amount DOUBLE PRECISION
);