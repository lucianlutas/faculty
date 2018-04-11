package Model;

public class User {

    private int id;
    private int type;
    private String username;
    private String pass;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

}
