--DROP TABLE users IF EXISTS;

CREATE TABLE partner (
  id  INTEGER PRIMARY KEY auto_increment,
  name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE campaign (
  id  INTEGER PRIMARY KEY auto_increment,
  name VARCHAR(30),
  partner_id varchar(20),
  duration varchar(30),
  ad_content varchar(200),
  active varchar(5)
);


--ALTER TABLE campaign
--ADD FOREIGN KEY (partner_id) 
--REFERENCES partner(id);

