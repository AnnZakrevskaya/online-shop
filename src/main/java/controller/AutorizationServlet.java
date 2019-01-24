package controller;

import controller.validator.UserNameValidator;
import service.OrderService;
import service.OrderServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import service.model.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="AutorizationServlet", urlPatterns = "/controller")
public class AutorizationServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("logError");
        System.out.println("servlet");
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        System.out.println(username + " " + password +" "+  role);
        List<String> errors = new ArrayList<>();
        if (role.equalsIgnoreCase("user")) {
            UserNameValidator.checkUserName(username, errors);
            if (!errors.isEmpty()) {
                resp.getWriter().write("Errors: " + errors);
            } else {

                if (userService.isUserValid(username, password)) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("user", username);
                    session.setAttribute("role", role);
                    session.setMaxInactiveInterval(30 * 60);
                    resp.sendRedirect("/index.jsp");
                } else {
                    HttpSession session = req.getSession(true);
                    resp.sendRedirect("/login");
                    session.setAttribute("logError", "Ошибка входа: Проверьте введённые данные или зарегистрируйтесь!");
                    session.setMaxInactiveInterval(30 * 60);

                }
            }
        } else {
            if(userService.isAdminValid(username, password)){
                HttpSession session = req.getSession(true);
                session.setAttribute("user", username);
                session.setAttribute("role", role);
                session.setMaxInactiveInterval(30 * 60);
                resp.sendRedirect("/index.jsp");
            } else {
                HttpSession session = req.getSession(true);
                resp.sendRedirect("/login");
                session.setAttribute("logError", "Ошибка входа: Проверьте введённые данные или зарегистрируйтесь!");
                session.setMaxInactiveInterval(30 * 60);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);

    }

}
