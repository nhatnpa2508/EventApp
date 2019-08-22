/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/2/2019                     *
 * Time: 5:26 PM                     *
 *************************************
 */

package Service.event;

import Model.ConnectDatabase;
import Model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventImpl implements IEvent {
    Connection connection = ConnectDatabase.getConnection();
    ResultSet resultSet = null;
    Statement statement;
    String sql;

    @Override
    public void createPost(Event event) {
        try {
            statement = connection.createStatement();
            sql = "insert into event(id,name_event,image,image_note,place,day_organizem,organizer,introduce,detailed_program,category,id_Admin)" +
                    " values('" + event.getId() + "','" + event.getName_event() + "','" + event.getImage() + "','"
                    + event.getImage_note() + "','" + event.getPlace() + "','" + event.getDay_organize() + "','"
                    + event.getOrganizer() + "','" + event.getIntroduce() + "','" + event.getDetailed_program() + "','"
                    + event.getName_Category() + "','" + event.getId_Admin() + "')";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Event getPostById(int id) {
        sql = "select * from event where id = '" + id + "'";
        Event event = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name_event = resultSet.getString("name_event");
                String image = resultSet.getString("image");
                String image_note = resultSet.getString("image_note");
                String place = resultSet.getString("place");
                Date day_organize = resultSet.getDate("day_organize");
                String organizer = resultSet.getString("organizer");
                String introduce = resultSet.getString("introduce");
                String detailed_program = resultSet.getString("detailed_program");
                String is_delete = resultSet.getString("is_delete");
                Date post_date = resultSet.getDate("post_date");
                Date last_edited_date = resultSet.getDate("last_edited_date");
                int id_Admin = resultSet.getInt("id_Admin");
                String name_Category = resultSet.getString("name_Category");
                String name_Admin = resultSet.getString("name_Admin");
                event = new Event(id, name_event, image, image_note, place, day_organize, organizer
                        , introduce, detailed_program, is_delete, post_date, last_edited_date, id_Admin, name_Category, name_Admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> eventList = new ArrayList<>();
        sql = "select * from event";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name_event = resultSet.getString("name_event");
                String image = resultSet.getString("image");
                String image_note = resultSet.getString("image_note");
                String place = resultSet.getString("place");
                Date day_organize = resultSet.getDate("day_organize");
                String organizer = resultSet.getString("organizer");
                String introduce = resultSet.getString("introduce");
                String detailed_program = resultSet.getString("detailed_program");
                String is_delete = resultSet.getString("is_delete");
                Date post_date = resultSet.getDate("post_date");
                Date last_edited_date = resultSet.getDate("last_edited_date");
                int id_Admin = resultSet.getInt("id_Admin");
                String name_Category = resultSet.getString("name_Category");
                String name_Admin = resultSet.getString("name_Admin");
                Event event = new Event(id, name_event, image, image_note, place, day_organize, organizer
                        , introduce, detailed_program, is_delete, post_date, last_edited_date, id_Admin, name_Category, name_Admin);
                eventList.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    @Override
    public List<Event> getAllEventsByCategory(String category) {
        return null;
    }

    @Override
    public List<Event> getSearchResults(String keyword) {
        List<Event> eventList = new ArrayList<>();
        sql = "select * from event where name_event like '%" + keyword + "%'";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name_event = resultSet.getString("name_event");
                String image = resultSet.getString("image");
                String image_note = resultSet.getString("image_note");
                String place = resultSet.getString("place");
                Date day_organize = resultSet.getDate("day_organize");
                String organizer = resultSet.getString("organizer");
                String introduce = resultSet.getString("introduce");
                String detailed_program = resultSet.getString("detailed_program");
                String is_delete = resultSet.getString("is_delete");
                Date post_date = resultSet.getDate("post_date");
                Date last_edited_date = resultSet.getDate("last_edited_date");
                int id_Admin = resultSet.getInt("id_Admin");
                String name_Category = resultSet.getString("name_Category");
                String name_Admin = resultSet.getString("name_Admin");
                Event event = new Event(id, name_event, image, image_note, place, day_organize, organizer
                        , introduce, detailed_program, is_delete, post_date, last_edited_date, id_Admin, name_Category, name_Admin);
                eventList.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    @Override
    public Event getPopulateEvent() {
        sql = "select event.*, count(id_event) from registrationdetail " +
                "inner join event where event.id = registrationdetail.id_event and event.is_delete = 0 " +
                " group by id_event order by count(id_event) DESC limit 1;";
        Event event = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name_event = resultSet.getString("name_event");
                String image = resultSet.getString("image");
                String image_note = resultSet.getString("image_note");
                String place = resultSet.getString("place");
                Date day_organize = resultSet.getDate("day_organize");
                String organizer = resultSet.getString("organizer");
                String introduce = resultSet.getString("introduce");
                String detailed_program = resultSet.getString("detailed_program");
                String is_delete = resultSet.getString("is_delete");
                Date post_date = resultSet.getDate("post_date");
                Date last_edited_date = resultSet.getDate("last_edited_date");
                int id_Admin = resultSet.getInt("id_Admin");
                String name_Category = resultSet.getString("name_Category");
                String name_Admin = resultSet.getString("name_Admin");
                event = new Event(id, name_event, image, image_note, place, day_organize, organizer
                        , introduce, detailed_program, is_delete, post_date, last_edited_date, id_Admin, name_Category, name_Admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public void updateEvent(Event event) {
        try {
            statement = connection.createStatement();
            sql = "update event set name_event = '" + event.getName_event() + "', image = '" + event.getImage()
                    + "', image_note = '" + event.getImage_note()+ "', place = '" + event.getPlace()
                    + "', day_organize = '" + event.getDay_organize()+ "', introduce = '" + event.getIntroduce()
                    + "', detailed_program = '" + event.getDetailed_program()+ "', is_delete = '" + event.getIs_delete()
                    + "', name_Category = '" + event.getName_Category()+ "', id_Admin = '" + event.getId_Admin()
                    + "', last_edited_date = NOW() where id = '" + event.getId() + "'";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(int id) {
        try {
            statement = connection.createStatement();
            sql = "delete from event where id = '" + id + "'";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void softDeleteEvent(int id) {
        try {
            statement = connection.createStatement();
            sql = "update event set is_delete = 1 where id = '" + id + "'";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void restoreSoftDeleteEvent(int id) {
        try {
            statement = connection.createStatement();
            sql = "update event set is_delete = 0 where id = '" + id + "'";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
