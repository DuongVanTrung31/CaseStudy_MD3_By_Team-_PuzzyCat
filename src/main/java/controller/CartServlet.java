package controller;

import model.Brand;
import model.Item;
import model.Product;
import service.implementService.BrandServiceImplement;
import service.implementService.ProductServiceImplement;
import service.interfaceService.IProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private final IProductService iProductService = new ProductServiceImplement();
    private final List<Brand> brands = new BrandServiceImplement().getAll();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req,resp);
    }

    private void action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "add":
                addToCart(req,resp);
                break;
            case "remove":
                removeProduct(req,resp);
                break;
            case "checkout":
                checkoutCart(req,resp);
                break;
            default:
                displayCart(req,resp);
        }
    }

    private void checkoutCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        session.setAttribute("cart",cart);
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/client/view/checkout.jsp").forward(req,resp);
    }

    private void removeProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = iProductService.findById(id);
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        cart.removeIf(item -> item.getProduct().getId() == product.getId());
        int subtotal = 0;
        for (Item item:cart) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        session.setAttribute("subtotal", subtotal);
        session.setAttribute("cart",cart);
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/client/view/cart.jsp").forward(req,resp);
    }


    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        int quantity = 1;
        Product product = iProductService.findById(id);
        List<Item> cart;
        if(req.getParameter("quantity") != null){
            quantity = Integer.parseInt(req.getParameter("quantity"));
        }
        if(session.getAttribute("cart") == null){
            cart = new ArrayList<>();
            cart.add(new Item(product,quantity));
        } else {
            cart = (List<Item>) session.getAttribute("cart");
            boolean check = false;
            for (Item item:cart) {
                if(item.getProduct().getId() == product.getId()){
                    item.setQuantity(item.getQuantity() + quantity);
                    check = true;
                }
            }
            if(check == false){
                cart.add(new Item(product,quantity));
            }
        }
        int subtotal = 0;
        for (Item item:cart) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        session.setAttribute("subtotal", subtotal);
        session.setAttribute("cart",cart);
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/client/view/cart.jsp").forward(req,resp);
    }

    private void displayCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Item> cart;
        if(session.getAttribute("cart") == null){
            cart = new ArrayList<>();
        } else {
            cart = (List<Item>) session.getAttribute("cart");
        }
        int subtotal = 0;
        for (Item item:cart) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        session.setAttribute("subtotal", subtotal);
        session.setAttribute("cart",cart);
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/client/view/cart.jsp").forward(req,resp);
    }
}
