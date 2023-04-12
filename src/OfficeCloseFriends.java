import java.util.ArrayList;
import java.util.List;

public class OfficeCloseFriends extends Recipients {
    private String designation;
    private String birthday;
    public static List<OfficeCloseFriends> officeCloseFriends=new ArrayList<>();
    public OfficeCloseFriends(String name, String mail,String designation,String birthday) {
        super(name, mail);
        this.birthday=birthday;
        this.designation=designation;
        officeCloseFriends.add(this);
    }
    public String sendWishes(){
        return "Wish You a Happy Birthday.";
    }

    public String getBirthday() {
        return this.birthday;
    }
}