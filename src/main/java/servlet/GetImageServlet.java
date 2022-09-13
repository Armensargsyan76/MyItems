package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/getImage")
public class GetImageServlet extends HttpServlet {

    private static final String IMAGE_PATH = "C:\\Users\\Armen\\IdeaProjects\\MyItems\\image";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemImage = req.getParameter("image");
        if (itemImage == null || itemImage.length()==0){
            resp.sendRedirect("/myItems");
        }
        String filePath = IMAGE_PATH + File.separator + itemImage;
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            try (FileInputStream inStream = new FileInputStream(imageFile)) {
                resp.setContentType("image/jpeg");
                resp.setContentLength((int) imageFile.length());
                OutputStream outputStream = resp.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead=inStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/myItems");
    }
}
