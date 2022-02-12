package controller;

import model.Brand;
import model.Category;
import model.Product;
import service.implementService.BrandServiceImplement;
import service.implementService.CategoryServiceImplement;
import service.implementService.ProductServiceImplement;
import service.interfaceService.IBrandService;
import service.interfaceService.ICategoryService;
import service.interfaceService.IProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NavigationServlet", urlPatterns = "/nav")
public class NavigationServlet extends HttpServlet {
    private final IProductService productService = new ProductServiceImplement();
    private final IBrandService brandService = new BrandServiceImplement();
    private final ICategoryService categoryService = new CategoryServiceImplement();
    private final List<Brand> brands = brandService.getAll();
    private final List<Category> categories = categoryService.getAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req,resp);
    }

    private void action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "store":
                storeAll(req,resp);
                break;
            case "laptop":
                storeLap(req,resp);
                break;
            case "sm":
                storeSmartPhone(req,resp);
                break;
            case "tablet":
                storeTablet(req,resp);
                break;
            case "search":
                findByKeyword(req,resp);
                break;
            case "filter":
                filterForm(req,resp);
                break;
        }
    }

    private void filterForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private void storeAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        req.setAttribute("activen1","active");
        req.setAttribute("brands",brands);
        req.setAttribute("categories",categories);
        req.setAttribute("products", products);
        req.getRequestDispatcher("client/view/store.jsp").forward(req,resp);
    }

    private void storeLap(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Laptop");
        req.setAttribute("activen2","active");
        req.setAttribute("brands",brands);
        req.setAttribute("categories",categories);
        req.setAttribute("products", products);
        req.getRequestDispatcher("client/view/store.jsp").forward(req,resp);

    }

    private void storeSmartPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("SmartPhone");
        req.setAttribute("activen3","active");
        req.setAttribute("brands",brands);
        req.setAttribute("categories",categories);
        req.setAttribute("products", products);
        req.getRequestDispatcher("client/view/store.jsp").forward(req,resp);
    }

    private void storeTablet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Tablet");
        req.setAttribute("activen4","active");
        req.setAttribute("brands",brands);
        req.setAttribute("categories",categories);
        req.setAttribute("products", products);
        req.getRequestDispatcher("client/view/store.jsp").forward(req,resp);
    }

    private void findByKeyword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Product> products = productService.findByKeyword(keyword);
        req.setAttribute("brands",brands);
        req.setAttribute("categories",categories);
        req.setAttribute("products", products);
        req.getRequestDispatcher("client/view/store.jsp").forward(req,resp);
    }
}
