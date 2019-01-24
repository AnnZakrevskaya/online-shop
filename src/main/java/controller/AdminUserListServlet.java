package controller;

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

public class AdminUserListServlet extends HttpServlet {
    UserService userService= UserServiceImpl.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        List<User> list = userService.getUserAllList();
        for (User user : list) {
            System.out.println(user.toString());
        }
        req.setAttribute("sizeUserList", list.size());
        session.setAttribute("userAllList", list);
        req.setAttribute("userList", list);
        req.getRequestDispatcher("/WEB-INF/pages/userList.jsp").forward(req, resp);

    }
}
