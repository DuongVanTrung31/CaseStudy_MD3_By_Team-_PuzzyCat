package controller;

import model.Product;
import model.Users;
import model.enums.Role;
import service.implementService.UsersServiceImplement;
import service.interfaceService.IProductService;
import service.interfaceService.IUsersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final IUsersService iUsersService = new UsersServiceImplement();
    private final IProductService iProductService = new ProductServiceImplement();

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
//                break;
            case "login":
                login(request, response);
                break;
        }
    }
//
//    private void registration(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
//        String
//    }

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
            Users users1 = iUsersService.findById(userID);
            Role role = users1.getRole();
            HttpSession session = request.getSession();
            session.setAttribute("userID", userID);
            session.setAttribute("account", account);
            session.setAttribute("password", password);
            session.setAttribute("role", role);
            if (role == Role.ADMIN){
                response.sendRedirect("login/admin/product.jsp");
            } else if (role == Role.USER) {
                response.sendRedirect("/home");
            }
        }
    }


    public void registration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Date birthDate = new Date(request.getParameter("birthdate"));
        Users users = new Users(account,password,firstName,lastName,address,email,phone,birthDate);
        request.setAttribute("user", users);
        iUsersService.add(users);
        request.getRequestDispatcher("/login/index.jsp").forward(request,response);
    }
}
