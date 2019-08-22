/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/2/2019                     *
 * Time: 5:24 PM                     *
 *************************************
 */

package Model;

import java.sql.Date;

public class RegistrationDetails {
    private int id_subscriber;
    private int id_event;
    private Date time_registration;
    private String content_registration;
    private String name_subscriber;
    private String name_event;
    private String place;
    private Date dayOrganize;
    private String email;
    private String phone;
    private String contentRegistration;

    public RegistrationDetails() {
    }

    public RegistrationDetails(int id_subscriber, int id_event) {
        this.id_event = id_event;
        this.id_subscriber = id_subscriber;
    }

    public RegistrationDetails(int id_subscriber, int id_event, Date time_registration, String content_registration,
                               String name_subscriber, String name_event) {
        this.id_event = id_event;
        this.id_subscriber = id_subscriber;
        this.time_registration = time_registration;
        this.content_registration = content_registration;
        this.name_event = name_event;
        this.name_subscriber = name_subscriber;
    }

    public RegistrationDetails(String nameEvent, String place, Date dayOrganize, String fullName, String email,
                               String phone, String contentRegistration) {
        this.name_event = nameEvent;
        this.place = place;
        this.dayOrganize = dayOrganize;
        this.name_subscriber = fullName;
        this.email = email;
        this.phone = phone;
        this.content_registration = contentRegistration;
    }


    public int getId_subscriber() {
        return id_subscriber;
    }

    public void setId_subscriber(int id_subscriber) {
        this.id_subscriber = id_subscriber;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public Date getTime_registration() {
        return time_registration;
    }

    public void setTime_registration(Date time_registration) {
        this.time_registration = time_registration;
    }

    public String getContent_registration() {
        return content_registration;
    }

    public void setContent_registration(String content_registration) {
        this.content_registration = content_registration;
    }

    public String getName_subscriber() {
        return name_subscriber;
    }

    public void setName_subscriber(String name_subscriber) {
        this.name_subscriber = name_subscriber;
    }

    public String getName_event() {
        return name_event;
    }

    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDayOrganize() {
        return dayOrganize;
    }

    public void setDayOrganize(Date dayOrganize) {
        this.dayOrganize = dayOrganize;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContentRegistration() {
        return contentRegistration;
    }

    public void setContentRegistration(String contentRegistration) {
        this.contentRegistration = contentRegistration;
    }
}
