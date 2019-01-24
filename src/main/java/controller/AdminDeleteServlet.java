package controller;

import service.OrderService;
import service.OrderServiceImpl;
import service.model.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminDeleteServlet extends HttpServlet {
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer index = Integer.parseInt(req.getParameter("delete"));
        System.out.println("пытаемся удалять");
        System.out.println(index);
        List<OrderDTO> list = orderService.getListAllOrder();
        int idOrder = list.get(index-1).getIdorder();
        System.out.println("выбрали  " + idOrder);
        orderService.deleteOrder(idOrder);
        resp.sendRedirect("/ordersAdmin");
    }
}
