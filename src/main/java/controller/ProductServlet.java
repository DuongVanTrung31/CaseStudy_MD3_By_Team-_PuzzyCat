package controller;

import model.Product;
import model.Review;
import service.implementService.ReviewServiceImplement;
import service.interfaceService.IProductService;
import service.implementService.ProductServiceImplement;
import service.interfaceService.IReviewService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/home")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductServiceImplement();
    private final IReviewService reviewService = new ReviewServiceImplement();
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
            case "review":
                findListReviewById(request,response);
                break;
            case "findByKeyword":
                findByKeyword(request,response);
                break;
            case "laptop":
                laptopIndex(request,response);
                break;
            case "tablet":
                tabletIndex(request,response);
                break;
            case "smartPhone":
                smartPhoneIndex(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void findListReviewById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        List<Review> reviews = reviewService.findListReviewById(productId);
        request.setAttribute("reviews", reviews);

    }


    private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("client/view/product.jsp").forward(request,response);
    }

    private void findByKeyword(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Product> products = productService.findByKeyword(keyword);
        request.setAttribute("products", products);
        request.getRequestDispatcher("client/view/store.jsp").forward(request,response);
    }


    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        request.setAttribute("active1", "active");
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("client/view/index.jsp");
        rd.forward(request, response);
    }

    private void laptopIndex(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Laptop");
        request.setAttribute("active2", "active");
        request.setAttribute("products", products);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }
    private void tabletIndex(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Tablet");
        request.setAttribute("active3", "active");
        request.setAttribute("products", products);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }
    private void smartPhoneIndex(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Smart Phone");
        request.setAttribute("active4", "active");
        request.setAttribute("products", products);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }

}
