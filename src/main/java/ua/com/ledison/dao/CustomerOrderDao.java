package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.CustomerOrder;

public interface CustomerOrderDao extends JpaRepository<CustomerOrder,Integer> {

}
