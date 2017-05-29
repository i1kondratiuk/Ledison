package ua.com.ledison.service;

import ua.com.ledison.entity.Power;

import java.util.List;

public interface PowerService {

    List<Power> getPowerList();
    Power getPowerById(int id);
    void addPower(Power power);
    void editPower(Power power);
    void deletePower(Power power);
}
