
package com.philipapp.department.repository;

import org.springframework.stereotype.Repository;
import com.philipapp.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


 Department findByDepartmentId(Long departmentId);
    
}
