package service;

import java.util.ArrayList;

import dto.Customer;

public class AuthenService {
	
	CustomerService customerService = new CustomerService(); 

	public Customer login (String id, String password) {
		ArrayList<Customer> customers = customerService.getCustomers();
		for (Customer c : customers) {
			if (c.id.equals(id) && c.password.equals(password)) {
				return c; 
			}
		}
        return null;
    }
}
