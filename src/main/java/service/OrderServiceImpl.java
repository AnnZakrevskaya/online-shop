package service;

import repository.OrderRepository;
import repository.OrderRepositoryImpl;
import service.converter.OrderConverter;
import service.model.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static OrderServiceImpl instance;

    private OrderServiceImpl() {
    }

    public static OrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    private OrderRepository orderRepository = OrderRepositoryImpl.getInstance();
    private UserService userService = UserServiceImpl.getInstance();
    private PerfumeService perfumeService = PerfumeServiceImpl.getInstance();
    private OrderConverter orderConverter = new OrderConverter();


    @Override
    public void addOrder(String username, String[] idPerfume) {
        int userId = userService.getUserIdByName(username);
        List<Integer> listIdPerfume = new ArrayList<>();
        int price = 0;
        for (String s : idPerfume) {
            listIdPerfume.add(Integer.parseInt(s));
            price += perfumeService.getOnePerfume(Integer.parseInt(s)).getPrice();
        }
        Double allPrice = 0d;
        if(listIdPerfume.size()>2){
           allPrice = price - price*0.1;
        }
        else if(listIdPerfume.size()==2){
            allPrice = price - price*0.05;
        }
        else{allPrice=Double.valueOf(price);}
        orderRepository.addToOrder(userId, listIdPerfume, allPrice);
    }

    @Override
    public List<OrderDTO> getListOrderForUser(String username) {
        System.out.println("попали в функцию отправки имени пользователя");
        System.out.println(username);
        int userId = userService.getUserIdByName(username);
        System.out.println(userId);
        return orderConverter.converterListOrderToOrderDTO(orderRepository.getOrder(orderRepository.getOrderItemForUser(userId)));
    }

    @Override
    public List<OrderDTO> getListAllOrder() {
        return orderConverter.converterListOrderToOrderDTO(orderRepository.getOrder(orderRepository.getOrderItemForAllUser()));
    }

    @Override
    public void updateStatusOrder(int idOrder) {
        orderRepository.updateOrder(idOrder);
    }

    @Override
    public void deleteOrder(int idOrder) {
        orderRepository.deleteOrder(idOrder);
    }
}
