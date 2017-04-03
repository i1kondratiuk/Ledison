package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.ShippingAddress;

public interface ShippingAddressDao extends JpaRepository<ShippingAddress, Integer> {

}
