/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/2/2019                     *
 * Time: 5:23 PM                     *
 *************************************
 */

package Model;

import java.sql.Date;

public class Admin {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String dayOfBirth;
    private String phone;
    private String email;
    private String address;
    private String image;
    private Date create_date;
    private Date last_edited_date;

    public Admin() {
    }

    public Admin(int id) {
        this.id = id;
    }

    public Admin(int id, String fullName, String dayOfBirth,String phone, String email, String address,String image){
        this.id = id;
        this.fullName = fullName;
        this.dayOfBirth = dayOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.image = image;
    }

    public Admin(int id, String username, String password, String fullName, String dayOfBirth, String phone, String email, String address, String image,
                 Date create_date, Date last_edited_date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dayOfBirth = dayOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.image = image;
        this.create_date = create_date;
        this.last_edited_date = last_edited_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_edited_date() {
        return last_edited_date;
    }

    public void setLast_edited_date(Date last_edited_date) {
        this.last_edited_date = last_edited_date;
    }
}
