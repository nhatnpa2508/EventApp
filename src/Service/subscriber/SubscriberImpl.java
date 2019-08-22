/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/2/2019                     *
 * Time: 5:27 PM                     *
 *************************************
 */

package Service.subscriber;

import Model.ConnectDatabase;
import Model.Subscriber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriberImpl implements ISubscriber {
    Connection connection = ConnectDatabase.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    String sql = null;
    ResultSet resultSet;

    @Override
    public void createSubscriber(Subscriber subscriber) {
        sql = "insert into (id, fullname, email, phone, address) value(?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subscriber.getId());
            preparedStatement.setString(2, subscriber.getFullName());
            preparedStatement.setString(3, subscriber.getEmail());
            preparedStatement.setString(4, subscriber.getPhone());
            preparedStatement.setString(5, subscriber.getAddress());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Subscriber getSubscriberById(int id) {
        sql = "select * from subscriber where id = '" + id + "'";
        Subscriber subscriber = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                subscriber = new Subscriber(id, fullName, email, phone, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriber;
    }

    @Override
    public List<Subscriber> getAllSubscriber() {
        List<Subscriber> listSubscriber = new ArrayList<>();
        sql = "select * from subscriber";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Subscriber subscriber = new Subscriber(id, fullName, email, phone, address);
                listSubscriber.add(subscriber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSubscriber;

    }
}
