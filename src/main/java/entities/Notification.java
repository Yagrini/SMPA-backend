package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "object")
    private String object;

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "message")
    private String message;

    @NotNull(message = "This field is required")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "notification")
    private Collection<UserNotification> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<UserNotification> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserNotification> users) {
        this.users = users;
    }
}
