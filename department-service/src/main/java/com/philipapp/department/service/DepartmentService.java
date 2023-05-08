package com.philipapp.department.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.philipapp.department.entity.Department;
import com.philipapp.department.model.response.ActionMessage;
import com.philipapp.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){

        log.info("Inside saveDepartment method of department service");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId){

        log.info("Inside findDepartmentById method of department service");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> getDepartments(){

        log.info("Inside getDepartments method of department service");
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    public List<Department> getDepartmentsV(){

        log.info("Inside getDepartments method of department service");
        List<Department> departments = new ArrayList<>();
        Iterable<Department> departmentIts = departmentRepository.findAll();

        for (Department dt: departmentIts){

            departments.add(dt);
        }


        return departments;
    }

    public Department updateDepartment(Long departmentId, Department department) throws Exception {

        // find department By Id
        Department returnedDepartment = departmentRepository.findByDepartmentId(departmentId);
        if(returnedDepartment == null){
            throw new Exception("No department found");
        }

        // check non-empty fields and set them
        if(department.getDepartmentAddress() != null) returnedDepartment.setDepartmentAddress(department.getDepartmentAddress());
        if(department.getDepartmentCode() != null) returnedDepartment.setDepartmentCode(department.getDepartmentCode());
        if(department.getDepartmentName() != null) returnedDepartment.setDepartmentName(department.getDepartmentName());

        //save the data
        return departmentRepository.save(returnedDepartment);
    }

    public ActionMessage delteDepartment(Long departmentId) {

        // find department By Id
        ActionMessage deleteDepartmentRest = new ActionMessage();
        Department returnedDepartment = departmentRepository.findByDepartmentId(departmentId);
        if(returnedDepartment == null){
            deleteDepartmentRest.setMessage("No department found with that ID");
            return deleteDepartmentRest;
        }

        departmentRepository.delete(returnedDepartment);
        deleteDepartmentRest.setMessage("Department deleted successfully");
        return deleteDepartmentRest;

        
    }
    
}
