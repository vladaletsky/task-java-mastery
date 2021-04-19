package com.mastery.java.task.rest;

import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class EmployeePageController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public String getAllEmployee(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/add-employee-page")
    public String addUserPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping("/edit-employee-page/{id}")
    public String editUserPage(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @PostMapping("/edit-employee/{id}")
    public String editUser(@PathVariable("id") int id, @ModelAttribute Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/";
    }
}
