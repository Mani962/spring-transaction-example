package ttn.growth.springtransaction.dao;

import org.springframework.stereotype.Service;
import ttn.growth.springtransaction.model.Customer;

@Service
public interface CustomerDAO {
    Customer create(Customer customer);
}
