package ua.com.ledison.service;

import ua.com.ledison.entity.SoldUnit;

import java.util.List;

public interface SoldUnitService {

    List<SoldUnit> getSoldUnitsList();
    SoldUnit getSoldUnitById(int soldUnitId);
    void update(SoldUnit soldUnit);
}
