package service;

import service.model.OrderDTO;

import java.util.List;

public interface OrderService {
    void addOrder(String username, String[] idPizza);
    List<OrderDTO> getListOrderForUser(String username);
    List<OrderDTO> getListAllOrder();
    void updateStatusOrder(int idOrder);
    void deleteOrder(int idOrder);
}
