package ttn.growth.springtransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ttn.growth.springtransaction.dao.CustomerDAO;
import ttn.growth.springtransaction.model.Address;
import ttn.growth.springtransaction.model.Customer;

@Controller
public class CustomerController {

    @Autowired
    CustomerDAO customerDAO;

    @GetMapping("/customer")
    public Customer create() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Pankaj");
        Address address = new Address();
        address.setId(2);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("Albany Dr, San Jose, CA 95129");
        customer.setAddress(address);
        return customerDAO.create(customer);
    }
}
