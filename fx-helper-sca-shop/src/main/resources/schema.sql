CREATE SCHEMA IF NOT EXISTS "fx";
SET SCHEMA "fx";

CREATE TABLE IF NOT EXISTS  "fx_shop"
(
    shop_id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    owner_user_id BIGINT       NOT NULL,
    shop_name     VARCHAR(50)  NOT NULL,
    logo          VARCHAR(255) NOT NULL,
    intro         VARCHAR(255) NOT NULL,
    address       VARCHAR(255) NOT NULL,
    --  0 关闭返现 1 开启返现
    status        INTEGER      NOT NULL DEFAULT 0,
    phone         CHAR(11)     NOT NULL,
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS "fx_shop_idx_shop_name"  ON "fx_shop" (shop_name);
CREATE INDEX IF NOT EXISTS "fx_shop_idx_phone"  ON "fx_shop" (phone);
CREATE INDEX IF NOT EXISTS "fx_shop_idx_owner_user_id" ON "fx_shop" (owner_user_id);
CREATE UNIQUE INDEX IF NOT EXISTS "fx_shop_idx_shop_name_&_address" ON "fx_shop" (shop_name, address);
CREATE INDEX IF NOT EXISTS "fx_shop_idx_created_at" ON "fx_shop" (created_at);
CREATE INDEX IF NOT EXISTS "fx_shop_idx_updated_at" ON "fx_shop" (updated_at);

CREATE TABLE IF NOT EXISTS "fx_serial_no"
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    shop_id    BIGINT       NOT NULL,
    serial_no  VARCHAR(100) NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX IF NOT EXISTS "fx_serial_idx_no_created_at" ON "fx_serial_no" (created_at);
CREATE UNIQUE INDEX IF NOT EXISTS "fx_serial_idx_no_shop_i_&_serial_no" ON "fx_serial_no" (shop_id, serial_no);