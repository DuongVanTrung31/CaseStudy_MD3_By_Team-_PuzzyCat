package controller;

import model.Product;
import model.Users;
import model.enums.Role;
import service.implementService.UsersServiceImplement;
import service.interfaceService.IUsersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final IUsersService iUsersService = new UsersServiceImplement();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);

    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "registration":
//                registration(request, response);
                break;
            case "login":
                login(request, response);
                break;
        }
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Users users = new Users(account, password);
        int userID = iUsersService.findByUser(users);
        if (userID == -1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/index.jsp");
            String message = "Account or password is invalid";
            request.setAttribute("message", message);
            dispatcher.forward(request, response);
        } else {
            Role role = users.getRole();
            HttpSession session = request.getSession();
            session.setAttribute("userID", userID);
            session.setAttribute("account", account);
            session.setAttribute("password", password);
            session.setAttribute("role", role);
            if (role.equals(Role.ADMIN)){
               response.sendRedirect("/");
            } else if (role.equals(Role.USER)) {
                response.sendRedirect("user/view/index.jsp");
            } else if (role.equals(Role.STAFF)) {
                response.sendRedirect("/");
            }
        }
    }
}