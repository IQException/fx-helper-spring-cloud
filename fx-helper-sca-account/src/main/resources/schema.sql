CREATE SCHEMA IF NOT EXISTS "fx";
SET SCHEMA "fx";

CREATE TABLE IF NOT EXISTS "fx_account"
(
    account_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT         NOT NULL UNIQUE,
    balance    NUMERIC(10, 2) NOT NULL DEFAULT 0.0,
    --  0 正常 其他不正常
    status     INTEGER        NOT NULL DEFAULT 0,
    created_at TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE INDEX IF NOT EXISTS "fx_account_idx_created_at" ON "fx_account" (created_at);
CREATE INDEX IF NOT EXISTS "fx_account_idx_updated_at" ON "fx_account" (updated_at);
