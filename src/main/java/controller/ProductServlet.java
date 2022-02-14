package controller;

import model.Brand;
import model.Product;
import model.Review;
import service.implementService.BrandServiceImplement;
import service.implementService.ReviewServiceImplement;
import service.interfaceService.IBrandService;
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
    private final IBrandService brandService = new BrandServiceImplement();
    private final List<Brand> brands = brandService.getAll();
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
            case "detail":
                findById(request,response);
                break;
            case "laptop":
                laptopHome(request,response);
                break;
            case "smartphone":
                smartPhoneHome(request,response);
                break;
            case "tablet":
                tabletHome(request,response);
                break;
            default:
                allProductHome(request, response);
                break;
        }
    }


    private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        List<Review> reviews = reviewService.findListReviewById(id);
        request.setAttribute("brands", brands);
        request.setAttribute("reviews",reviews);
        request.setAttribute("product", product);
        request.getRequestDispatcher("client/view/product.jsp").forward(request,response);
    }

    private void allProductHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        List<Product> laptops = productService.findByKeyword("laptop");
        List<Product> sms = productService.findByKeyword("smartphone");
        List<Product> tablets = productService.findByKeyword("tablet");
        request.setAttribute("active1", "active");
        request.setAttribute("products", products);
        request.setAttribute("brands", brands);
        request.setAttribute("laptops", laptops);
        request.setAttribute("sms", sms);
        request.setAttribute("tablets", tablets);
        RequestDispatcher rd = request.getRequestDispatcher("client/view/index.jsp");
        rd.forward(request, response);
    }

    private void laptopHome(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Laptop");
        List<Product> laptops = productService.findByKeyword("laptop");
        List<Product> sms = productService.findByKeyword("smartphone");
        List<Product> tablets = productService.findByKeyword("tablet");
        request.setAttribute("active2", "active");
        request.setAttribute("products", products);
        request.setAttribute("laptops", laptops);
        request.setAttribute("sms", sms);
        request.setAttribute("tablets", tablets);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }


    private void tabletHome(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Tablet");
        List<Product> laptops = productService.findByKeyword("laptop");
        List<Product> sms = productService.findByKeyword("smartphone");
        List<Product> tablets = productService.findByKeyword("tablet");
        request.setAttribute("active3", "active");
        request.setAttribute("products", products);
        request.setAttribute("brands", brands);
        request.setAttribute("laptops", laptops);
        request.setAttribute("sms", sms);
        request.setAttribute("tablets", tablets);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }

    private void smartPhoneHome(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("SmartPhone");
        List<Product> laptops = productService.findByKeyword("laptop");
        List<Product> sms = productService.findByKeyword("smartphone");
        List<Product> tablets = productService.findByKeyword("tablet");
        request.setAttribute("active4", "active");
        request.setAttribute("products", products);
        request.setAttribute("brands", brands);
        request.setAttribute("laptops", laptops);
        request.setAttribute("sms", sms);
        request.setAttribute("tablets", tablets);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }
}
