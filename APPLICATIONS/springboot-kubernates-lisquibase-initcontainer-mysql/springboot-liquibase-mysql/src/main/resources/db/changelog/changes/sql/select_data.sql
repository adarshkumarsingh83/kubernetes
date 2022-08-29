
DROP PROCEDURE IF EXISTS getEmployee;
//
CREATE PROCEDURE getEmployee(IN EMP_NO INT(10))
BEGIN
   SELECT GROUP_CONCAT(emp_id,' ', first_name,' ',last_name,' ',career) FROM employee WHERE emp_id = EMP_NO;
END //
//

