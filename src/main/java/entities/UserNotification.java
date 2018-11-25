package entities;

import entities.composite_key.UserNotificationCK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_notification")
public class UserNotification implements Serializable {

    @EmbeddedId
    UserNotificationCK userNotificationCK;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("notificationId")
    private Notification notification;

    @Column(name = "mark_as_read")
    private Boolean markAsRead;

    public UserNotificationCK getUserNotificationCK() {
        return userNotificationCK;
    }

    public void setUserNotificationCK(UserNotificationCK userNotificationCK) {
        this.userNotificationCK = userNotificationCK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Boolean getMarkAsRead() {
        return markAsRead;
    }

    public void setMarkAsRead(Boolean markAsRead) {
        this.markAsRead = markAsRead;
    }
}
