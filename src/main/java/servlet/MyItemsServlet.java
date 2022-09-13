package servlet;

import Manager.CategoryManager;
import Manager.ItemManager;
import model.Category;
import model.Item;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myItems")
public class MyItemsServlet extends HttpServlet {

   private ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Item> items = itemManager.getLastTwentyItemsByUserId(user.getId());
        req.setAttribute("items", items);
        req.getRequestDispatcher("/WEB-INF/myPage.jsp").forward(req, resp);
    }


}
