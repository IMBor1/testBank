-- liquibase formatted sql

--changeset IBor:
CREATE TABLE Wallet (
    wallet_id UUID Primary Key,
    operation_type VARCHAR(10) CHECK (operation_type IN ('DEPOSIT', 'WITHDRAW')),
    amount NUMERIC(19, 2) NOT NULL,
);