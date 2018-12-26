package models;

import entities.User;
import utils.Util;

import javax.persistence.Query;

public class UserDAO extends Model{
// select a user
    public User selectUser(String email){
        User user = null;
        try {
            Query query = this.getEm().createQuery("SELECT u FROM User u WHERE u.email = :email",User.class);
            query.setParameter("email", email);
            this.getEm().getTransaction().begin();
            user = (User) query.getSingleResult();
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
// get role of user
    public String selectRole(String email){
        String role = null;
        try {
            Query query = this.getEm().createQuery("SELECT TYPE(u) FROM User u WHERE u.email = :email",User.class);
            query.setParameter("email", email);
            this.getEm().getTransaction().begin();
            String str[] = query.getSingleResult().toString().split("\\.");
            role = str[str.length-1];
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }
// update token of user
    public void updateToken(String email, String token){
        User user = null;
        try {
            user = selectUser(email);
            user.setRememberToken(token);
            this.getEm().getTransaction().begin();
            this.getEm().merge(user);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
// update user
    public User update(User user){
        User dbUser = null;
        try {
            dbUser = selectUser(user.getEmail());
            dbUser.setPassword(Util.hashing(user.getPassword()));
            this.getEm().getTransaction().begin();
            this.getEm().merge(dbUser);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
}
