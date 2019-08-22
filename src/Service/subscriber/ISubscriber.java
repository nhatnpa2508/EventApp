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

import Model.Subscriber;

import java.util.List;

public interface ISubscriber {
    public void createSubscriber(Subscriber subscriber);

    public Subscriber getSubscriberById(int id);

    public List<Subscriber> getAllSubscriber();
}
