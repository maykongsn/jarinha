CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    limit_amount INTEGER NOT NULL,
    balance INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    amount INTEGER NOT NULL,
    type VARCHAR(1) NOT NULL,
    description VARCHAR(10),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_accounts_id_transaction FOREIGN KEY (account_id) REFERENCES accounts(id)
);

DO $$
BEGIN
  INSERT INTO accounts (name, limit_amount)
  VALUES
    ('o barato sai caro', 1000 * 100),
    ('zan corp ltda', 800 * 100),
    ('les cruders', 10000 * 100),
    ('padaria joia de cocaia', 100000 * 100),
    ('kid mais', 5000 * 100);
END;
$$