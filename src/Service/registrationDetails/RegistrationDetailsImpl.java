/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/2/2019                     *
 * Time: 5:27 PM                     *
 *************************************
 */

package Service.registrationDetails;

import Model.ConnectDatabase;
import Model.RegistrationDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDetailsImpl implements IRegistrationDetails {

    Connection connection = ConnectDatabase.getConnection();
    ResultSet resultSet = null;
    Statement statement;
    String sql;

    @Override
    public boolean createRegistrationDetails(RegistrationDetails registrationDetails) {
        try {
            statement = connection.createStatement();
            sql = "insert into registrationdetail(id_subscriber,id_event,time_registration,content_registration)" +
                    " values('" + registrationDetails.getId_subscriber() + "','" + registrationDetails.getId_event() + "','"
                    + registrationDetails.getTime_registration() + "','" + registrationDetails.getContent_registration() + "')";
            statement.executeUpdate(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<RegistrationDetails> getAllRegistrationDetails() {
        List<RegistrationDetails> registrationsList = new ArrayList<>();
        sql = "select event.name_event, event.place, event.day_organize, subscriber.fullName, subscriber.email, subscriber.phone, registrationdetail.content_registration \n" +
                "FROM events.registrationdetail \n" +
                "inner join subscriber \n" +
                "on registrationdetail.id_subscriber = subscriber.id \n" +
                "inner join event \n" +
                "on registrationdetail.id_event = event.id \n" +
                "order by event.name_event ASC;";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String nameEvent = resultSet.getString("name_event");
                String place = resultSet.getString("place");
                Date dayOrganize = resultSet.getDate("day_organize");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String contentRegistration = resultSet.getString("content_registration");

                RegistrationDetails registration = new RegistrationDetails(nameEvent, place, dayOrganize, fullName, email, phone, contentRegistration);
                registrationsList.add(registration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrationsList;
    }


    @Override
    public List<RegistrationDetails> getAllRegistrationDetailsByEventName(String name_event) {
        sql = "select subscriber.*, event.name_event, registrationdetail.* " +
                "FROM events.registrationdetail " +
                "inner join subscriber on registrationdetail.id_subscriber = subscriber.id " +
                "inner join event on registrationdetail.id_event = event.id " +
                "where event.name_event like = '%" + name_event + "%'";
        List<RegistrationDetails> registrationDetailsList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_subscriber = resultSet.getInt("id_subscriber");
                int id_event = resultSet.getInt("id_event");
                Date time_registration = resultSet.getDate("time_registration");
                String content_registration = resultSet.getString("content_registration");
                String email_subscriber = resultSet.getString("email");
                RegistrationDetails registrationDetails = new RegistrationDetails(id_subscriber, id_event, time_registration, content_registration,
                        email_subscriber, name_event);
                registrationDetailsList.add(registrationDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrationDetailsList;
    }

    @Override
    public List<RegistrationDetails> getAllRegistrationDetailsBySubscriberEmail(String email) {
        sql = "select subscriber.*, event.name_event, registrationdetail.* " +
                "FROM events.registrationdetail " +
                "inner join subscriber on registrationdetail.id_subscriber = subscriber.id " +
                "inner join event on registrationdetail.id_event = event.id " +
                "where subscriber.email like '%" + email + "%'";
        List<RegistrationDetails> registrationDetailsList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_subscriber = resultSet.getInt("id_subscriber");
                int id_event = resultSet.getInt("id_event");
                Date time_registration = resultSet.getDate("time_registration");
                String content_registration = resultSet.getString("content_registration");
                String name_event = resultSet.getString("name_event");
                RegistrationDetails registrationDetails = new RegistrationDetails(id_subscriber, id_event, time_registration, content_registration,
                        email, name_event);
                registrationDetailsList.add(registrationDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrationDetailsList;
    }

    /*@Override
    public String getSubscriberEmail(String email) {
        String subscriberEmail = "";
        sql = "select subscriber.email from subscriber where subscriber.email = '" + email + "'";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                subscriberEmail = resultSet.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriberEmail;
    }*/

    @Override
    public boolean checkSubscriber(String email, int id_event) {
        sql = "select subscriber.*, registrationdetail.* " +
                "FROM events.registrationdetail " +
                "inner join subscriber on registrationdetail.id_subscriber = subscriber.id " +
                "where subscriber.email = '" + email + "' and registrationdetail.id_event = '" + id_event + "'";
        boolean check = true;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                if (id > 0) {
                    check = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}