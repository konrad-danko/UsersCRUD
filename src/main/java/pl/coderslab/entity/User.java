package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private long id;
    private String userName;
    private String email;
    private String password;

    public User() { }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        //w konstruktorze od razu hashujemy hasło:
        this.password = hashPassword(password);
    }

    public User(long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        //w konstruktorze od razu hashujemy hasło:
        this.password = hashPassword(password);
    }

    //metoda zwracająca zahashowane hasło:
    public String hashPassword(String password) {return BCrypt.hashpw(password, BCrypt.gensalt());}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //getter hasła zahashowanego:
    public String getPassword() {
        return password;
    }
    //setter hasła zahashowanego:
    public void setHashPassword (String password) {
        this.password = password;
    }
    //setter hashujący hasło:
    public void setPassword(String password) {
        this.password = hashPassword(password);
    }
}
