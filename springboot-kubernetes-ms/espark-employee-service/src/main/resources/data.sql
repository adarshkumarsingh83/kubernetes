DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstName VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (id,firstName, lastName, career) VALUES
  (1,'adarsh', 'kumar', 'It'),
  (2,'radha', 'singh', 'IT'),
  (3,'amit', 'kumar', 'Finance');