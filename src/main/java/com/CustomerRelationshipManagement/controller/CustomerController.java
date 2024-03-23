package com.CustomerRelationshipManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;
import com.CustomerRelationshipManagement.service.EmailService;


@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		List<Customer> listCustomer = customerService.findAllCustomer();
		model.addAttribute("customers", listCustomer);
		return "customer-list";
	}
	
	@GetMapping("/addForm")
	public String addForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		emailService.sendMail(customer.getEmail(), customer.getFirstName(), customer.getLastName());
		return "redirect:/customers/list";
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("customerId") Integer id, Model model) {
		Customer customer = customerService.findCustomerById(id);
		model.addAttribute("customer", customer);
		return "customer-update-form";
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return ResponseEntity.ok("Customer updated successfully");
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {   
		customerService.deleteById(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
