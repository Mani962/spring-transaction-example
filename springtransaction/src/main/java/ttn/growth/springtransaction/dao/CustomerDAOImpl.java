package ttn.growth.springtransaction.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttn.growth.springtransaction.model.Customer;

import javax.sql.DataSource;

@Service
@Slf4j
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired(required = true)
    DataSource dataSource;

    @Override
    @Transactional
    public Customer create(Customer customer) {
        String queryCustomer = "insert into Customer (id, name) values (?,?)";
        String queryAddress = "insert into Address (id, address,country) values (?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(queryCustomer, customer.getId(),
                customer.getName());
        System.out.println("Inserted into Customer Table Successfully");
        jdbcTemplate.update(queryAddress, customer.getId(),
                customer.getAddress().getAddress(),
                customer.getAddress().getCountry());
        System.out.println("Inserted into Customer Table Successfully");
        return customer;
    }
}
