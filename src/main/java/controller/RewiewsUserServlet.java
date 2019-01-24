package controller;

import repository.model.Rewiew;
import repository.model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RewiewsUserServlet extends HttpServlet {
    UserService userService= UserServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        List<Rewiew> list = userService.getRewiewsList();
        for (Rewiew rewiew : list) {
            System.out.println(rewiew.toString());
        }
        req.setAttribute("sizeRewiewList", list.size());
        session.setAttribute("rewiewAllList", list);
        req.setAttribute("rewiewsList", list);

        req.getRequestDispatcher("WEB-INF/pages/rewiewsUser.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=windows-1251");
        req.setCharacterEncoding("CP1251");
        HttpSession session = req.getSession();
        String username = req.getParameter("userName");
        String rewiew = req.getParameter("rewUser");
        System.out.println(username+" "+rewiew);
        userService.addRewiew(username, rewiew);
        System.out.println("ok");
        resp.sendRedirect("/rewiews");
    }
}
