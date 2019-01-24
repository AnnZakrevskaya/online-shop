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

public class AdminOrdersServlet extends HttpServlet{
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDTO> list = orderService.getListAllOrder();
        req.setAttribute("sizeOrderAllList", list.size());
        req.setAttribute("listAllOrder", list);
        req.getRequestDispatcher("/WEB-INF/pages/ordersAdmin.jsp").forward(req, resp);
    }
}
