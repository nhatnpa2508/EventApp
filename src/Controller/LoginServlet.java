package Controller;

import Model.Admin;
import Service.admin.AdminImpl;
import Service.admin.IAdmin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    private IAdmin adminImpl = new AdminImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        String userName = request.getParameter("loginUsername");
        String password = request.getParameter("loginPassword");

        String passwordBD = adminImpl.getPasswordByUsername(userName);
        if (password.equals(passwordBD)) {
            session.setAttribute("Admin", userName);
            Admin admin = adminImpl.getAdminByUsername(userName);
            int idAdmin = admin.getId();
            session.setAttribute("idAdmin", idAdmin);
            dispatcher = request.getRequestDispatcher("/admin.jsp");
        } else {
            request.setAttribute("message", "Wrong Password");
            dispatcher = request.getRequestDispatcher("login.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
