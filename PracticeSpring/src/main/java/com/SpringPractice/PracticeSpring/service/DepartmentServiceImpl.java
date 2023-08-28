package com.SpringPractice.PracticeSpring.service;

import com.SpringPractice.PracticeSpring.entity.Department;
import com.SpringPractice.PracticeSpring.error.DepartmentNotFoundException;
import com.SpringPractice.PracticeSpring.respository.DepartmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRespository departmentRespository;


    @Override
    public Department saveDepartment(Department department) {
        return departmentRespository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentlist() {
        return  departmentRespository.findAll();
    }

    @Override
    public Department fetchDepartbyId(Long departmentid) throws DepartmentNotFoundException {
        Optional<Department>department= departmentRespository.findById(departmentid);
        if(!department.isPresent()){
           throw new DepartmentNotFoundException("Please enter Dept ID");
        }
        return department.get();
    }

    @Override
    public void deletebyId(Long departmentid) {
        departmentRespository.deleteById(departmentid);
    }

    @Override
    public Department updateData(Department department, Long departmentid) {
        Department depDb= departmentRespository.findById(departmentid).get();
        if(Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.departmentName)){
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.departmentAddress)){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.departmentCode)){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRespository.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRespository.findBydepartmentNameIgnoreCase(departmentName);
    }


}
