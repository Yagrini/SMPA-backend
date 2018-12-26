package models;

import entities.Notification;
import entities.User;
import entities.UserNotification;

import javax.persistence.Query;
import java.util.Collection;

public class NotificationDAO extends Model {

// get all notifications by user
    public Collection<Notification> getNotificationByUser(int id){
        Collection<Notification> notifications = null;
        try {
            Query query = this.getEm().createNamedQuery("Notification.getByUser");
            query.setParameter("id", id);
            this.getEm().getTransaction().begin();
            notifications = query.getResultList();
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return notifications;
    }
// create notification
    //  Remark :
    //  To create/ update or delete all users concerned by this notification (UserNotification) we just need
    //  to add CASCADE in Notification entity before Collection<UserNotification>.
    public Notification createNotification(Notification notification){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().persist(notification);
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return notification;
    }
// update notification
    public Notification updateNotification(Notification notification){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().merge(notification);
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return notification;
    }
}
