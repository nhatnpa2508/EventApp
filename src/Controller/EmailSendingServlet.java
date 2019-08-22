package Controller;

import Model.RegistrationDetails;
import Service.registrationDetails.EmailUtility;
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

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 */

@WebServlet(name = "EmailSendingServlet", urlPatterns = "/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {

    private IRegistrationDetails registrationDetailsDAO = new RegistrationDetailsImpl();

    private String host = "smtp.gmail.com";
    private String port = "587";
    private String user = "haicodegym@gmail.com";
    private String pass = "1qaz0plm#";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        String resultMessage = "";

        try {
            EmailUtility.sendMail(host, port, user, pass, recipient, subject, content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/manager/registrationDetails/result.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //showCreateForm(request, response);
                break;
            default:
                showFormSendMail(request, response);
                break;
        }
    }

    private void showFormSendMail(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        request.setAttribute("email", email);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/registrationDetails/sendmail.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
