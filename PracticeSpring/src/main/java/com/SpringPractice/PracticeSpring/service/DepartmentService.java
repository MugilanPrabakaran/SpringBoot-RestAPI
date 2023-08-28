package com.SpringPractice.PracticeSpring.service;

import com.SpringPractice.PracticeSpring.entity.Department;

import java.util.List;


public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentlist();


    public Department fetchDepartbyId(Long departmentid);

    public void deletebyId(Long departmentid);

    public Department updateData(Department department, Long departmentid);

    public Department fetchDepartmentByName(String departmentName);
}
