CREATE SCHEMA IF NOT EXISTS "fx";
SET SCHEMA "fx";


CREATE TABLE IF NOT EXISTS "fx_user"
(
    user_id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    nick_name   VARCHAR(20)  NOT NULL,
    avatar      VARCHAR(255) NOT NULL,
    open_id     VARCHAR(255) NOT NULL UNIQUE,
    union_id    VARCHAR(255),
    session_key VARCHAR(255),
    phone       CHAR(11),
    pay_secret  CHAR(64),
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS "fx_user_idx_nick_name" ON "fx_user" (nick_name);
CREATE INDEX IF NOT EXISTS "fx_user_idx_open_id" ON "fx_user" (open_id);
CREATE INDEX IF NOT EXISTS "fx_user_idx_union_id" ON "fx_user" (union_id);
CREATE INDEX IF NOT EXISTS "fx_user_idx_session_key" ON "fx_user" (session_key);
CREATE INDEX IF NOT EXISTS "fx_user_idx_phone" ON "fx_user" (phone);
CREATE INDEX IF NOT EXISTS "fx_user_idx_created_at" ON "fx_user" (created_at);
CREATE INDEX IF NOT EXISTS "fx_user_idx_updated_at" ON "fx_user" (updated_at);


