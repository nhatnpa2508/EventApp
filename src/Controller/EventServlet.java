package Controller;

import Model.Event;
import Service.event.EventImpl;
import Service.event.IEvent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EventServlet", urlPatterns = "/events")
public class EventServlet extends HttpServlet {

    private IEvent eventImpl = new EventImpl();
    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEvent(request, response);
                break;
            case "edit":
                updateEvent(request, response);
                break;
            case "delete":
                deleteEvent(request, response);
                break;
            case "softDelete":
                softDeleteEvent(request, response);
                break;
            case "restoreSoftDelete":
                restoreSoftDeleteEvent(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        /*Event deletePost = this.eventImpl.getPostById(id);*/
        this.eventImpl.deleteEvent(id);
        try {
            response.sendRedirect("/events");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void restoreSoftDeleteEvent(HttpServletRequest request, HttpServletResponse response) {
        int id = (Integer) session.getAttribute("idEvent");
        this.eventImpl.restoreSoftDeleteEvent(id);

        Event event = this.eventImpl.getPostById(id);
        request.setAttribute("event", event);
        request.setAttribute("message", "Event was restore soft deleted");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/event/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void softDeleteEvent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.eventImpl.softDeleteEvent(id);

        Event event = this.eventImpl.getPostById(id);
        request.setAttribute("event", event);
        request.setAttribute("message", "Event was soft deleted");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/event/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name_event = request.getParameter("name_event");
        String image = request.getParameter("image");
        String image_note= request.getParameter("image_note");
        String place = request.getParameter("place");
        session = request.getSession();
        int idAdmin = (Integer) session.getAttribute("idAdmin");
        String day = request.getParameter("day_organize");
        Date day_organize = null;
        try {
            day_organize = (Date) new SimpleDateFormat("YYYY/MM/dd").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String organizer = request.getParameter("organizer");
        String introduce = request.getParameter("introduce");
        String detailed_program = request.getParameter("detailed_program");
        String name_Category = request.getParameter("category");
        Event event = new Event(id, name_event, image, image_note, place, day_organize,
                organizer, introduce,detailed_program,name_Category,idAdmin);

        this.eventImpl.updateEvent(event);

        request.setAttribute("event", event);
        request.setAttribute("message", "Event was updated");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/event/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createEvent(HttpServletRequest request, HttpServletResponse response) {
        session = request.getSession();
        String name_event = request.getParameter("name_event");
        String image = request.getParameter("image");
        String image_note= request.getParameter("image_note");
        String place = request.getParameter("place");
/*        java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
        String ngaynhap = df.format(resultSet.getDate("ngaynhap"));*/
        String day = request.getParameter("day_organize");
        Date day_organize = null;
        try {
            day_organize = (Date) new SimpleDateFormat("YYYY/MM/dd").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String organizer = request.getParameter("organizer");
        String introduce = request.getParameter("introduce");
        String detailed_program = request.getParameter("detailed_program");
        String name_Category = request.getParameter("category");
        int idAdmin = 1;
        /*int idAdmin = (Integer) session.getAttribute("idAdmin");*/

        Event event = new Event(0, name_event, image, image_note, place, day_organize,
                organizer, introduce,detailed_program,name_Category,idAdmin);
        this.eventImpl.createPost(event);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/event/create.jsp");
        request.setAttribute("message", "New event was created");
        try {
            requestDispatcher.forward(request, response);
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
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewEvent(request, response);
                break;
            default:
                listEvent(request, response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Event event = this.eventImpl.getPostById(id);
        request.setAttribute("event", event);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/event/delete.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listEvent(HttpServletRequest request, HttpServletResponse response) {
        List<Event> eventList = this.eventImpl.getAllEvents();
        request.setAttribute("eventList", eventList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/event/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewEvent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        session.setAttribute("idEvent",id);

        Event event = this.eventImpl.getPostById(id);
        request.setAttribute("event", event);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("single.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Event event = this.eventImpl.getPostById(id);
        request.setAttribute("event", event);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/event/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager/event/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}