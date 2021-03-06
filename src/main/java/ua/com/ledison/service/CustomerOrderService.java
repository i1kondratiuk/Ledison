package ua.com.ledison.service;


import ua.com.ledison.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    List<CustomerOrder> getAllOrders();
    CustomerOrder findCustomerOrderById(int customerOrderId);
    void addCustomerOrder(CustomerOrder customerOrder);
    double getCustomerOrderGrandTotal(int cartId);
    void updateCustomerOrder(CustomerOrder customerOrder);
}
