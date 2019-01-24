package repository;

import repository.model.Cart;
import repository.model.Order;

import java.util.List;

public interface OrderRepository {
    boolean addToOrder(int userId, List<Integer> perfumeId, Double price);
    Integer findNumber();
    Integer findIdLastOrder();
    List<Cart> getOrderItemForUser(int userId);
    List<Order> getOrder(List<Cart> orderItemList);
    List<Cart> getOrderItemForAllUser();
    void updateOrder(int orderId);
    void deleteOrder(int orderId);
}
