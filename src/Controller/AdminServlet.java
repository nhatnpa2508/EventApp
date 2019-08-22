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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admins")
public class AdminServlet extends HttpServlet {

    private IAdmin adminImpl = new AdminImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                updateAdminInfo(request, response);
                break;
            case "changePassword":
                updateAdminPassword(request, response);
                break;
            default:
                listAdmin(request, response);
                break;
        }
    }

    private void updateAdminInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
/*        Admin admin = adminImpl.getAdminById(id);*/
        String fullName = request.getParameter("fullName");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String image = request.getParameter("image");
        Admin admin = new Admin(id,fullName,dayOfBirth,phone,email,address,image);

        request.setAttribute("admin", admin);
        request.setAttribute("message", "Admin was updated");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/admin/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateAdminPassword(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Admin admin = adminImpl.getAdminById(id);
        String password = request.getParameter("password");
        String passwordDB = admin.getPassword();
        RequestDispatcher dispatcher;
        if (password.equals(passwordDB)){
            String newPassword = request.getParameter("newPassword");
            admin.setPassword(newPassword);
            this.adminImpl.updateAdminPassword(admin);
            request.setAttribute("message", "Password was change");
            dispatcher = request.getRequestDispatcher("manager/admin/changePassword.jsp");
        } else {
            request.setAttribute("message", "Wrong password");
            dispatcher = request.getRequestDispatcher("manager/admin/changePassword.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEditInfoForm(request, response);
                break;
            case "changePassword":
                showEditPasswordForm(request, response);
                break;
            case "view":
                showViewForm(request, response);
                break;
            default:
                listAdmin(request, response);
                break;
        }
    }

    private void showEditInfoForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Admin admin = adminImpl.getAdminById(id);
        request.setAttribute("admin", admin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manager/admin/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditPasswordForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Admin admin = adminImpl.getAdminById(id);
        request.setAttribute("admin", admin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manager/admin/changePassword.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Admin admin = adminImpl.getAdminById(id);
        request.setAttribute("admin", admin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manager/admin/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listAdmin(HttpServletRequest request, HttpServletResponse response) {
        List<Admin> admins = this.adminImpl.getAllAdmin();
        request.setAttribute("admins", admins);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manager/admin/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}