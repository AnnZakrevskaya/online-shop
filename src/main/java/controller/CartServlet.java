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
import java.util.Iterator;
import java.util.List;

public class CartServlet extends HttpServlet {
    private OrderService orderService = OrderServiceImpl.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") != null) {
            List<PerfumeDTO> list = (List<PerfumeDTO>) session.getAttribute("cart");
            int sizeCart = list.size();
            Double dsum = 0d; Double sum = 0d;
            if(sizeCart == 2){
                for (PerfumeDTO perfumeDTO : list) {
                    sum += perfumeDTO.getPrice();
                }
                dsum=sum;
               sum=sum - sum*0.05;
            }
            else if(sizeCart > 2){
                for (PerfumeDTO perfumeDTO : list) {
                    sum += perfumeDTO.getPrice();
                }
                dsum = sum;
                sum = sum - sum*0.1;
            }
            else {
                for (PerfumeDTO perfumeDTO : list) {
                    sum += perfumeDTO.getPrice();
                }
                dsum=sum;
            }
            System.out.println(sum);
            req.setAttribute("orderPrice", sum);
            req.setAttribute("sumWithhout", dsum);
            req.setAttribute("sizeCart", sizeCart);
            req.setAttribute("listCartsNew", list);
        }
        req.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<PerfumeDTO> cart = (List<PerfumeDTO>) session.getAttribute("cart");
        if (req.getParameter("del") != null) {
            int id = Integer.parseInt(req.getParameter("del"));
            System.out.println(id);
            Iterator<PerfumeDTO> it = cart.iterator();
            while (it.hasNext()) {
                if (it.next().getId_perfume() == id) {
                    it.remove();
                }
            }
            session.setAttribute("cart", cart);
            resp.sendRedirect("/cart");
        } else {
            if (req.getParameter("toOrder") != null) {
                System.out.println("попали в заказ товара в сервлете");
                if (cart.size() != 0) {
                    int sizeOrder = cart.size();
                    System.out.println(sizeOrder);
                    String[] values = new String[sizeOrder];
                    for (int i = 0; i < sizeOrder; i++) {
                        values[i] = String.valueOf(cart.get(i).getId_perfume());
                    }
                    String username = req.getParameter("userName");
                    orderService.addOrder(username, values);
                    System.out.println("ok");
                }
                session.removeAttribute("cart");
                //session.removeAttribute("number");
                resp.sendRedirect("/ordersUser");
            }
        }
    }
}