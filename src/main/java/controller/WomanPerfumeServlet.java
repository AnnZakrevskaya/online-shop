package controller;

import service.PerfumeService;
import service.PerfumeServiceImpl;
import service.model.PerfumeDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WomanPerfumeServlet extends HttpServlet {
    private PerfumeService perfumeService = PerfumeServiceImpl.getInstance();
    List<PerfumeDTO> listInSession = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PerfumeDTO> list = perfumeService.getListAllPerfume();
        req.setAttribute("listAllPerfume", list);
        req.getRequestDispatcher("/WEB-INF/pages/woman.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("nam"));
        PerfumeDTO perfumeDTO = perfumeService.getOnePerfume(id);
        if (session.getAttribute("cart") == null) {
            List<PerfumeDTO> cart = new ArrayList<>();
            cart.add(perfumeDTO);
            session.setAttribute("cart", cart);
        } else {
            List<PerfumeDTO> cart = (List<PerfumeDTO>) session.getAttribute("cart");
            cart.add(perfumeDTO);
            session.setAttribute("cart", cart);
        }
        doGet(req, resp);
    }
}
