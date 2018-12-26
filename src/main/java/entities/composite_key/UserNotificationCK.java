package entities.composite_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class UserNotificationCK implements Serializable {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "notification_id")
    private Integer notificationId;
}
