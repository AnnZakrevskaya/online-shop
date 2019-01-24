package controller;

import service.OrderService;
import service.OrderServiceImpl;
import service.model.PerfumeDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderAddServlet extends HttpServlet {
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<PerfumeDTO> cart = (List<PerfumeDTO>) session.getAttribute("cart");
        if(req.getParameter("del") != null){
            int id = Integer.parseInt(req.getParameter("del"));
            for (PerfumeDTO perfumeDTO : cart) {
                if(perfumeDTO.getId_perfume()==id){
                    cart.remove(perfumeDTO);
                }
            }
            session.setAttribute("cart", cart);
        }
        if(req.getParameter("toOrder") != null){
            int sizeOrder = cart.size();
            String[] values = new String[sizeOrder];
            for(int i=0;i<sizeOrder;i++){
                values[i]= String.valueOf(cart.get(i).getId_perfume());
            }
            String username = req.getParameter("userName");
            orderService.addOrder(username, values);
            System.out.println("ok");
            session.removeAttribute("cart");
            session.removeAttribute("number");
            resp.sendRedirect("/cart");
        }
        doGet(req, resp);
    }
}
