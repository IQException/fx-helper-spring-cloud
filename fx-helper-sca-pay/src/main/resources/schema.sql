CREATE SCHEMA IF NOT EXISTS "fx";
SET SCHEMA "fx";



CREATE TABLE IF NOT EXISTS "fx_pay_info"
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    --1 余额 2 微信
    from_channel   INTEGER        NOT NULL,
    from_account   VARCHAR(200)   NOT NULL,
    from_trx_id    VARCHAR(200),
    --1 余额 2 微信
    to_channel     INTEGER        NOT NULL,
    to_account     VARCHAR(200)   NOT NULL,
    to_trx_id      VARCHAR(200),
    biz_id         VARCHAR(200)   NOT NULL UNIQUE,
    amount         NUMERIC(10, 2) NOT NULL,
    status         VARCHAR(20),
    pay_acct_info  JSON,
    recv_acct_info JSON,
    created_at     TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS "fx_pay_info_idx_from_account" ON "fx_pay_info" (from_account);
CREATE INDEX IF NOT EXISTS "fx_pay_info_idx_to_account" ON "fx_pay_info" (to_account);
CREATE INDEX IF NOT EXISTS "fx_pay_info_idx_biz_id" ON "fx_pay_info" (biz_id);
CREATE INDEX IF NOT EXISTS "fx_pay_info_idx_created_at" ON "fx_pay_info" (created_at);
CREATE INDEX IF NOT EXISTS "fx_pay_info_idx_updated_at" ON "fx_pay_info" (updated_at);
