DROP TABLE IF EXISTS address;

CREATE TABLE address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  streetName VARCHAR(250) NOT NULL,
  cityName VARCHAR(250) NOT NULL,
  country VARCHAR(250) DEFAULT NULL
);

INSERT INTO address (id,streetName, cityName, country) VALUES
  (1,'jpb street', 'jbp', 'india'),
  (2,'hyd street', 'hyd', 'india'),
  (3,'delhi street', 'delhi', 'india');
