package UserProfile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletLogin", urlPatterns = "/login")
public class Login extends HttpServlet {

    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter printWriter = response.getWriter();

        if (password.equals("123") && email.equals("admin@gmail.com")) {
            HttpSession session = request.getSession();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome");
            Cookie emailCookie = new Cookie("email", email);
            response.addCookie(emailCookie);
            Cookie passwordCookie = new Cookie("password", password);
            response.addCookie(passwordCookie);
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            requestDispatcher.forward(request, response);
        } else {

            printWriter.println("Incorrect Username or Password.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.include(request, response);

        }
        printWriter.close();
    }

    public void doDestroy() {

    }
}


