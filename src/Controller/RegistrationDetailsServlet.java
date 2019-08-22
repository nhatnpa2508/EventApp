package Controller;

import Model.RegistrationDetails;
import Service.registrationDetails.IRegistrationDetails;
import Service.registrationDetails.RegistrationDetailsImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistrationDetailsServlet", urlPatterns = "/registration")
public class RegistrationDetailsServlet extends HttpServlet {

    private IRegistrationDetails registrationDetailsDAO = new RegistrationDetailsImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //showCreateForm(request, response);
                break;
            case "createComment":
                //createComment(request, response);
                break;
            case "edit":
                //showEditForm(request, response);
                break;
            case "delete":
                //showDeleteForm(request, response);
                break;
            case "view":
                //viewPosts(request, response);
                break;
            default:
                listRegistrations(request, response);
                break;
        }
    }

    private void listRegistrations(HttpServletRequest request, HttpServletResponse response) {
        List<RegistrationDetails> registrationsList = this.registrationDetailsDAO.getAllRegistrationDetails();
        request.setAttribute("registrationsList", registrationsList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/registrationDetails/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
