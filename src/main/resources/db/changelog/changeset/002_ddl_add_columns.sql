--liquibase formatted sql
--changeset samusev:add_columns_to_users
ALTER TABLE users
ADD COLUMN first_arg DOUBLE PRECISION,
ADD COLUMN second_arg DOUBLE PRECISION,
ADD COLUMN result DOUBLE PRECISION
