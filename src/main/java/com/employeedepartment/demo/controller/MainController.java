package com.employeedepartment.demo.controller;

import com.employeedepartment.demo.entity.Department;
import com.employeedepartment.demo.entity.Employee;
import com.employeedepartment.demo.repository.DepartmentRepository;
import com.employeedepartment.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/")
    public String homePage(){
        return "homepage";
    }

    @RequestMapping("/addemployee")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentRepository.findAll());
        return "addemployee";
    }

    @PostMapping("/processemployee")
    public String processEmployee(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @RequestMapping("/adddepartment")
    public String addDepartment(Model model){
        model.addAttribute("newDepartment", new Department());
        return "adddepartment";
    }

    @PostMapping("/processdepartment")
    public String processDepartment(Department department){
        departmentRepository.save(department);
        return "redirect:/";
    }

    @RequestMapping("/allemployees")
    public String allEmployees(Model model){
        model.addAttribute("allEmployees", employeeRepository.findAll());
        return "allemployees";
    }

    @RequestMapping("/alldepartments")
    public String allDepartments(Model model){
        model.addAttribute("allDepartments", departmentRepository.findAll());
        return "alldepartments";
    }
    @RequestMapping("/editemployee/{id}")
    public String editEmployee(@PathVariable("id") long id, Model model){
        model.addAttribute("employee",employeeRepository.findById(id).get());
        return "editemployee";
    }

    @RequestMapping("/processeditemployee")
    public String processEditEmployee(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @RequestMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable("id") long id){
        employeeRepository.deleteById(id);
        return "redirect:/";
    }
}
