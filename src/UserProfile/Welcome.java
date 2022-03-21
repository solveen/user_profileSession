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


@WebServlet(name = "ServletWelcome", urlPatterns = "/welcome")
public class Welcome extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriters = response.getWriter();
        HttpSession session = request.getSession(false);

        String email = (String) session.getAttribute("email");

        printWriters.println("<form action = 'profile' method = 'Post' >");
        printWriters.println("<h1>Welcome</h1>");
        //double quote for the object written in java code inside the html code
        printWriters.println("<input type = 'hidden' name = 'email' value = " + email + ">");
        printWriters.println("<button type = 'submit'> View Your Profile</button>");
        printWriters.println("</form>");
        printWriters.close();

    }

    public void doDestroy() {

    }
}
