package com.walmart.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.walmart.employee.model.Employee;
import com.walmart.employee.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    

    @GetMapping("/employee")
    public String index(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "list";
    }

    @GetMapping("/employee/create")
    public String create(Model model) {
        model.addAttribute("employees", new Employee());
        return "form";
    }

    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employees", employeeService.findOne(id));
        return "update";
    }
    
    @PostMapping("/employee/update")
    public String Update(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
    	//model.addAttribute("employees", employeeService.findOne(employee.getEid()));
    	if (result.hasErrors()) {
            return "update";
        }
        employeeService.Update(employee);
        redirect.addFlashAttribute("success", "employee Updated successfully!");
        return "redirect:/employee";
        
    }

    @PostMapping("/employee/save")
    public String save(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "form";
        }
        employeeService.save(employee);
        redirect.addFlashAttribute("success", "Saved employee successfully!");
        return "redirect:/employee";
        
    }

    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        employeeService.delete(id);
        redirect.addFlashAttribute("success", "Deleted employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/employee/search")
    public String search(@RequestParam("s") String s, Model model) {
        if (s.equals("")) {
            return "redirect:/employee";
        }

        model.addAttribute("employees", employeeService.search(s));
        return "list";
    }
}