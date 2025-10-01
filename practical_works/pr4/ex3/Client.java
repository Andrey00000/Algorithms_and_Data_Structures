package pr4.ex3;

public class Client {
    private final String login;
    private final String password;
    private boolean isLoggedIn;
    private boolean logout;

    public Client(String login, String password){
        this.login = login;
        this.password = password;
        this.isLoggedIn = false;
        this.logout = false;
    }

    public String getLogin() {
        return login;
    }

    public boolean LoggedIn(String login, String password){
        if (this.login.equals(login) && this.password.equals(password)){
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    public boolean isLoggedIn(){
        return isLoggedIn;
    }

    public void logout(){
        this.logout = true;
    }

    public boolean isLogout() {
        return logout;
    }
}
