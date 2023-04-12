public class MailHost {
    private String username;
    private String password;
    private String name;
    private static MailHost instance;

    private MailHost(){};
    public synchronized static MailHost getInstance() {
        if(instance==null){
            instance=new MailHost();
        }
        return instance;
    }

    public void setUsername(String username) {
        username=username.strip();
        this.username = username;
    }

    public void setPassword(String password) {
        password=password.strip();
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        name=name.strip();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
}
