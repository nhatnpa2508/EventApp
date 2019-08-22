/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/2/2019                     *
 * Time: 5:26 PM                     *
 *************************************
 */

package Service.admin;

import Model.Admin;
import Model.ConnectDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminImpl implements IAdmin{

    Connection connection = ConnectDatabase.getConnection();
    ResultSet resultSet = null;
    Statement statement;
    String sql;

    @Override
    public Admin getAdminById(int id) {
        sql = "select * from admin where id = '" + id + "'";
        Admin admin = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String dayOfBirth = resultSet.getString("DoB");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String image = resultSet.getString("image");
                Date create_date = resultSet.getDate("create_date");
                Date last_edited_date = resultSet.getDate("last_edited_date");
                admin = new Admin(id, username, password, fullName, dayOfBirth, phone, email,
                        address, image, create_date,last_edited_date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        sql = "select * from admin " +
                " where username = '" + username + "'";
        Admin admin = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String dayOfBirth = resultSet.getString("DoB");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String image = resultSet.getString("image");
                Date create_date = resultSet.getDate("create_date");
                Date last_edited_date = resultSet.getDate("last_edited_date");
                admin = new Admin(id, username, password, fullName, dayOfBirth, phone, email,
                        address, image, create_date,last_edited_date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> adminList = new ArrayList<>();
        sql = "select * from admin";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String dayOfBirth = resultSet.getString("DoB");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String image = resultSet.getString("image");
                Date create_date = resultSet.getDate("create_date");
                Date last_edited_date = resultSet.getDate("last_edited_date");
                Admin admin = new Admin(id, username, password, fullName, dayOfBirth, phone, email,
                        address, image, create_date,last_edited_date);
                adminList.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    @Override
    public boolean updateAdminInfo(Admin admin) {
        try {
            statement = connection.createStatement();
            sql = "update admin set fullName = '" + admin.getFullName() + "', DoB = '" + admin.getDayOfBirth()
                    + "', phone = '" + admin.getPhone() + "', email = '" + admin.getEmail()
                    + "', address = '" + admin.getAddress() + "', image = '" + admin.getImage()
                    + "', last_edited_date = NOW() where id = '" + admin.getId() + "'";
            statement.executeUpdate(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAdminPassword(Admin admin) {
        try {
            statement = connection.createStatement();
            sql = "update admin set password = '" + admin.getPassword() + "', lastModifiedDate = NOW() where id = '" + admin.getId() + "'";
            statement.executeUpdate(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(Admin admin) {
        try {
            statement = connection.createStatement();
            sql = "delete from admin where id = '" + admin.getId() + "'";
            statement.executeUpdate(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getPasswordByUsername(String username) {
        sql = "select password from admin where username = '" + username + "'";
        String password = "";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }
}
