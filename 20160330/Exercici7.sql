CREATE TABLE PRODUCT(
  ID NUMBER(8),
  NAME VARCHAR(50),
  DESCRIPTION VARCHAR2(500),
  PRIMARY KEY(ID)
);

CREATE TABLE PRODUCT_CUSTOMER(
  PRODUCT_ID NUMBER(8),
  CUSTOMER_ID NUMBER(8),
  CREATION_DATE DATE,
  FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(ID),
  FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(ID)
);

ALTER TABLE PRODUCT_CUSTOMER ADD CONSTRAINT pk_product_customer PRIMARY KEY(PRODUCT_ID, CUSTOMER_ID);
