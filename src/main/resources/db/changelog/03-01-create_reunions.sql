CREATE TABLE IF NOT EXISTS reunions (
created_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
cagnotte BOOLEAN,
active BOOLEAN,
CONSTRAINT pk_reunions PRIMARY KEY (created_date));

