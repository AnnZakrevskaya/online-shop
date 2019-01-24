package controller;

import service.RegistrService;
import service.RegistrServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private RegistrService registrService = RegistrServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("WEB-INF/pages/registr.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=windows-1251");
        req.setCharacterEncoding("CP1251");
        HttpSession session = req.getSession();
        String fio = req.getParameter("us_fio");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone= req.getParameter("phone");
        String adress = req.getParameter("adress");
        System.out.println(fio+" "+adress+" "+login);
        if(registrService.addUser(fio, login, password, phone, adress, email)==false){
            resp.sendRedirect("/registr");
            session.setAttribute("loginError", "Ошибка: Такой логин уже существует!");
            session.setMaxInactiveInterval(30 * 60);
        }
        else {
            System.out.println("ok");
            resp.sendRedirect("/login");
        }
    }
}
