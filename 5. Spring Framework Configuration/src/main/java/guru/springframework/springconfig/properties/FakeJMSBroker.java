package guru.springframework.springconfig.properties;

/*
PROJECT NAME : 5. Spring Framework Configuration
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/12/2022 10:42 PM
*/

public class FakeJMSBroker {

    private String username;
    private String password;
    private String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
