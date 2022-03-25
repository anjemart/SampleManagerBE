CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;

CREATE TABLE IF NOT EXISTS sample(
    id INT GENERATED ALWAYS AS IDENTITY,
    external_id VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS customer(
    id INT GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    home_phone VARCHAR(20),
    cell_phone VARCHAR(20),
    email VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS checked_out_sample(
    id INT GENERATED ALWAYS AS IDENTITY,
    sample_id INT,
    customer_id INT,
    followed_up BOOLEAN,
    created_on TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    last_modified_on TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_CUSTOMER
      FOREIGN KEY(customer_id)
        REFERENCES customer(id),
    CONSTRAINT FK_SAMPLE
          FOREIGN KEY(sample_id)
            REFERENCES sample(id)
);