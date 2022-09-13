package servlet;

import Manager.CategoryManager;
import Manager.ItemManager;
import model.Category;
import model.Item;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/item/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100)
public class ItemAddServlet extends HttpServlet {

    CategoryManager categoryManager = new CategoryManager();

    ItemManager itemManager = new ItemManager();

    private static final String IMAGE_PATH = "C:\\Users\\Armen\\IdeaProjects\\MyItems\\image";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryManager.getAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/itemAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int id = Integer.parseInt(req.getParameter("categoryId"));
        Part profilePicPart_id = req.getPart("image");
        String fileName = null;
        if (profilePicPart_id != null) {
            long nanoTime = System.nanoTime();
            fileName = nanoTime + "_" + profilePicPart_id.getSubmittedFileName();
            String fullFileName = IMAGE_PATH + File.separator + fileName;
            profilePicPart_id.write(fullFileName);
        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Item item = Item.builder()
                .title(title)
                .price(price)
                .category(categoryManager.getCategoryById(id))
                .picUrl(fileName)
                .user(user)
                .build();
        itemManager.addItem(item);
        resp.sendRedirect("/myPage");
    }
}