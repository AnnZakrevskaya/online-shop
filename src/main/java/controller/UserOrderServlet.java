package controller;

import service.OrderService;
import service.OrderServiceImpl;
import service.model.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserOrderServlet extends HttpServlet {
    OrderService orderService= OrderServiceImpl.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        List<OrderDTO> list=orderService.getListOrderForUser((String)session.getAttribute("user"));
        for (OrderDTO orderDTO : list) {
            System.out.println(orderDTO.toString());
        }
        req.setAttribute("sizeOrderList", list.size());
        session.setAttribute("orderListForUser", list);
        req.setAttribute("listOrder", list);
        req.getRequestDispatcher("/WEB-INF/pages/ordersUser.jsp").forward(req, resp);

    }
}
