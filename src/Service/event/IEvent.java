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

import Model.Event;

import java.util.List;

public interface IEvent {

    public void createPost(Event event);

    public Event getPostById(int id);

    public List<Event> getAllEvents();

    public List<Event> getAllEventsByCategory(String category);

    public List<Event> getSearchResults(String keyword);

    public Event getPopulateEvent();

    public void updateEvent(Event event);

    public void deleteEvent(int id);

    public void softDeleteEvent(int id);

    public void restoreSoftDeleteEvent(int id);
}
