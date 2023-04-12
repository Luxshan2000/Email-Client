import java.util.HashMap;

abstract class Recipients {
    private String name;
    private String mail;
    private  static HashMap<String,String> collection=new HashMap<String,String>();

    public Recipients(String name, String mail) {
        this.name=name;
        this.mail=mail;
        collection.put(this.name,this.mail);
    }

    public void Recipients(String name, String mail){
        this.mail=mail;
        this.name=name;
    }

    public static int count() {
        return collection.size();
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }
}
