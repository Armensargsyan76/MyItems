package servlet;

import Manager.CategoryManager;
import Manager.ItemManager;
import model.Item;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomePageServlet extends HttpServlet {

    CategoryManager categoryManager = new CategoryManager();

    ItemManager itemManager = new ItemManager();



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("categoryId");
        List<Item> items;
        if (idStr == null || idStr.equals("")) {
            items = itemManager.getLastTwentyItems();
        } else {
            int categoryId = Integer.parseInt(idStr);
            items = itemManager.getLastTwentyItemsByCategory(categoryId);
        }
        req.setAttribute("items", items);
        req.setAttribute("categories", categoryManager.getAll());
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
