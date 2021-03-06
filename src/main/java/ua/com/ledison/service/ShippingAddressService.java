package ua.com.ledison.service;

import ua.com.ledison.entity.ShippingAddress;

public interface ShippingAddressService {

    void addShippingAddress(ShippingAddress shippingAddress);
    void updateShippingAddress(ShippingAddress shippingAddress);
    ShippingAddress getShippingAddressById(int shippingAddressId);
}
