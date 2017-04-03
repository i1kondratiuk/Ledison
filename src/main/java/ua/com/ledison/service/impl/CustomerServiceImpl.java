package ua.com.ledison.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.dao.CustomerDao;
import ua.com.ledison.entity.Customer;
import ua.com.ledison.service.CustomerService;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public Customer getCustomerById(int customerId) {
        return null;
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public Customer getCustomerByUsername(String username) {
        return null;
    }
}
