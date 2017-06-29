package ua.com.ledison.service;

import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.entity.User;

public interface MailService {
    void sendMailAboutOrderSuccess(User user);
    void sendMailAboutOrderStatusChanging(User user, CustomerOrder customerOrder);
}
