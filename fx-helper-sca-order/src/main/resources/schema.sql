CREATE SCHEMA IF NOT EXISTS "fx";
SET SCHEMA "fx";

CREATE TABLE IF NOT EXISTS "fx_order"
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    shop_id    BIGINT         NOT NULL,
    user_id    BIGINT         NOT NULL,
    capture    VARCHAR(255)   NOT NULL,
    amount     NUMERIC(10, 2) NOT NULL,
    fx_time    TIMESTAMP,
    -- 0 待审核 1 已返现 2 返现中 9 返现失败
    status     INTEGER        NOT NULL DEFAULT 0,
    -- 序列号 同一店铺每个二维码都有一个唯一的序列号，防止重复返现
    serial_no  VARCHAR(100)   NOT NULL,
    fail_msg   VARCHAR,
    created_at TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE INDEX IF NOT EXISTS "fx_order_idx_shop_id" ON "fx_order" (shop_id);
CREATE INDEX IF NOT EXISTS "fx_order_idx_user_id" ON "fx_order" (user_id);
CREATE INDEX IF NOT EXISTS "fx_order_idx_fx_time" ON "fx_order" (fx_time);
CREATE UNIQUE INDEX IF NOT EXISTS "fx_order_idx_shop_id_&_serial_no" ON "fx_order" (shop_id, serial_no);
CREATE INDEX IF NOT EXISTS "fx_order_idx_created_at" ON "fx_order" (created_at);
CREATE INDEX IF NOT EXISTS "fx_order_idx_updated_at" ON "fx_order" (updated_at);

CREATE TABLE IF NOT EXISTS "fx_serial_no"
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    shop_id    BIGINT       NOT NULL,
    serial_no  VARCHAR(100) NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX IF NOT EXISTS "fx_serial_idx_no_created_at" ON "fx_serial_no" (created_at);
CREATE UNIQUE INDEX IF NOT EXISTS "fx_serial_idx_no_shop_i_&_serial_no" ON "fx_serial_no" (shop_id, serial_no);
