package service.converter;

import repository.model.Order;
import service.model.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    PerfumeConverter converter= new PerfumeConverter();
    public OrderDTO orderToOrderDTO(Order order){
        return OrderDTO.newBuilder()
                .id(order.getIdorder())
                .user(order.getUser())
                .price(order.getPrice())
                .status(order.getStatus())
                .adress(order.getAdress())
                .perfumes(converter.converterPerfumeList(order.getPerfumes()))
                .build();
    }
    public List<OrderDTO> converterListOrderToOrderDTO(List<Order> orderList){
        for (Order order : orderList) {
            System.out.println(order.toString());
            System.out.println(order.getIdorder());
        }
        List<OrderDTO> orderDTOList= new ArrayList<>();
        for (Order order : orderList) {
            orderDTOList.add(orderToOrderDTO(order));
        }
        return orderDTOList;
    }
}
