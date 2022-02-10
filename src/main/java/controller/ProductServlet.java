package controller;

import model.Product;
import service.interfaceService.IProductService;
import service.implementService.ProductServiceImplement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/home")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductServiceImplement();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add-product":
            case "edit-product":
            case "delete-product":
            case "detail-product":
                findById(request,response);
                break;
            case "find-by-keyword":
                findByKeyword(request,response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = null;
        product = productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher rd = request.getRequestDispatcher("user/view/product.jsp");
        rd.forward(request,response);
    }

    private void findByKeyword(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Product> products = productService.findByKeyword(keyword);
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("user/view/store.jsp");
        rd.forward(request,response);

    }


    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("user/view/index.jsp");
        rd.forward(request, response);
    }


}
