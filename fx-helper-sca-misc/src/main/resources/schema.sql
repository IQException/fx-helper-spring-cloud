CREATE SCHEMA IF NOT EXISTS "fx";
SET SCHEMA "fx";


CREATE TABLE IF NOT EXISTS "fx_wx_msg_subs"
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    open_id     VARCHAR(255) NOT NULL,
    template_id VARCHAR(255) NOT NULL,
    count       INTEGER      NOT NULL DEFAULT 1,
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE UNIQUE INDEX IF NOT EXISTS "fx_wx_msg_subs_idx_open_id_&_template_id" on "fx_wx_msg_subs" (open_id, template_id);

CREATE TABLE IF NOT EXISTS "fx_wx_message"
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    open_id     VARCHAR(255)  NOT NULL,
    template_id VARCHAR(255)  NOT NULL,
    page        VARCHAR(255),
    msg_body    VARCHAR(2000) NOT NULL,
    -- 0 created 1 succeed -1 failed
    status      INTEGER       NOT NULL DEFAULT 0,
    fail_msg    VARCHAR(2000),
    created_at  TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE INDEX IF NOT EXISTS "fx_message_idx_open_id" ON "fx_wx_message" (open_id);
CREATE INDEX IF NOT EXISTS "fx_message_idx_template_id" ON "fx_wx_message" (template_id);
CREATE INDEX IF NOT EXISTS "fx_message_idx_created_at" ON "fx_wx_message" (created_at);
CREATE INDEX IF NOT EXISTS "fx_message_idx_updated_at" ON "fx_wx_message" (updated_at);