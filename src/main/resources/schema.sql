DROP TABLE IF EXISTS price;
CREATE TABLE price (
  price_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  brand_id BIGINT NOT NULL,
  start_date DATETIME2 NOT NULL,
  end_date  DATETIME2 NOT NULL,
  price_list BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  priority INT NOT NULL ,
  price BIGINT NOT NULL,
  curr VARCHAR2(10) NOT NULL
);