package sample;

public class User {
    private String username;
    private String email;
    private String password;
    private String creationdate;
    private String password_reset;
    private String user_token;
    private String token_timestamp;
    private String is_deleted;

    public User(String username, String email, String password, String password_reset){
        this.username=username;
        this.email=email;
        this.password = password;
        this.password_reset = password_reset;
    }
    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getPassword_reset() {
        return password_reset;
    }

    public void setPassword_reset(String password_reset) {
        this.password_reset = password_reset;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public String getToken_timestamp() {
        return token_timestamp;
    }

    public void setToken_timestamp(String token_timestamp) {
        this.token_timestamp = token_timestamp;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }
}
