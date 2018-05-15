package capo.ostkit.sdk;

/**
 * Created by TinhVC on 5/14/18.
 */

public class Users {
    private String userName;
    public Users(String userName){
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
