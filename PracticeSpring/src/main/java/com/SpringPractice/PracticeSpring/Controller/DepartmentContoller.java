package com.SpringPractice.PracticeSpring.Controller;

import com.SpringPractice.PracticeSpring.entity.Department;
import com.SpringPractice.PracticeSpring.error.DepartmentNotFoundException;
import com.SpringPractice.PracticeSpring.service.DepartmentService;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentContoller {
   @Autowired
    private DepartmentService departmentService;

   /*Initiating Loggers */
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentContoller.class);


    @PostMapping("/departments")
    public Department saveDepartment (@Valid @RequestBody Department department){
        LOGGER.info("InSide SaveDepartment of Department  ");
     return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentlist(){
        LOGGER.info("Inside GetDepartment Names  ");

        return  departmentService.fetchDepartmentlist();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartbyId(@PathVariable("id") Long departmentid ) throws DepartmentNotFoundException {
        LOGGER.info("Inside GetDepartmentBy ID   ");
        return (Department) departmentService.fetchDepartbyId(departmentid);
    }
    @DeleteMapping("/departments/{id}")
    public String deletebyId(@PathVariable("id") Long departmentid){
        LOGGER.info("Inside Deleting  Names  ");
        departmentService.deletebyId(departmentid);
        return "Department id Deleted succesfully ";
    }
    @PutMapping("/departments/{id}")
    public Department updateData(@PathVariable("id") Long departmentid,@RequestBody Department department){
        LOGGER.info("Updating  Department by ID ");
        return departmentService.updateData(department,departmentid);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
