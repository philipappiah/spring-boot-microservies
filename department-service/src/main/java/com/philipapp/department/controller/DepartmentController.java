
package com.philipapp.department.controller;
import com.philipapp.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

import com.philipapp.department.entity.Department;
import com.philipapp.department.model.response.ActionMessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping
    public Department saveDepartment(@RequestBody Department department){

        log.info("Inside saveDepartment method of department controller");
        return departmentService.saveDepartment(department);

    }

    @GetMapping
    public List<Department> findDepartments(){
        log.info("Inside findDepartmentById department method of department controller");
        return departmentService.getDepartments();
    }

    @GetMapping(path = "/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById department method of department controller");
        return departmentService.findByDepartmentId(departmentId);
    }

    @PutMapping(path = "/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) throws Exception{
        log.info("Inside findDepartmentById department method of department controller");
        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping(path = "/{id}")
    public ActionMessage updateDepartment(@PathVariable Long departmentId){
        log.info("Inside findDepartmentById department method of department controller");

        return departmentService.delteDepartment(departmentId);
    }

    
}
