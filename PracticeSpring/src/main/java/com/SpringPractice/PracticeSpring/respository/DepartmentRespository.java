package com.SpringPractice.PracticeSpring.respository;

import com.SpringPractice.PracticeSpring.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRespository extends JpaRepository<Department,Long> {
    public  Department findBydepartmentName(String departmentName);

    public  Department findBydepartmentNameIgnoreCase(String departmentName);
}
