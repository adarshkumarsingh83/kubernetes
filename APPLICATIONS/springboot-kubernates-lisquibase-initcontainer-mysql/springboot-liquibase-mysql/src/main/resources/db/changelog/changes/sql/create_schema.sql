DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  emp_id INT NOT NULL PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);