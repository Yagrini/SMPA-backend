package entities.composite_key;

import entities.Notification;
import entities.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class UserNotificationCK implements Serializable {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "notification_id")
    private Integer notificationId;
}
