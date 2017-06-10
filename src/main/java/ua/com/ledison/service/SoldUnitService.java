package ua.com.ledison.service;

import ua.com.ledison.entity.Product;
import ua.com.ledison.entity.SoldUnit;

import java.util.List;

public interface SoldUnitService {

    List<SoldUnit> getSoldUnitsList();
    List<Product> get8MostPopularProducts();
    SoldUnit getSoldUnitById(int soldUnitId);
    void update(SoldUnit soldUnit);
}
