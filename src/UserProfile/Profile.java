package UserProfile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProfile", urlPatterns = "/profile")
public class Profile extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriters = response.getWriter();

        String name = request.getParameter("email");

        printWriters.println("<form action = 'logout' method = 'Post'>");
        printWriters.println("<h2> This is your profile </h2>");
        printWriters.println("<h3>" + name + "</h3>");
        printWriters.println("<input type = 'submit' value = 'Logout'> ");
        printWriters.println("</form>");

    }

    public void doDestroy() {

    }
}

