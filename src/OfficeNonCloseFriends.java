import java.util.ArrayList;
import java.util.List;

public class OfficeNonCloseFriends extends Recipients {
    private String designation;
    public static List<OfficeNonCloseFriends> officeNonCloseFriends=new ArrayList<>();

    public OfficeNonCloseFriends(String name, String mail,String designation) {
        super(name, mail);
        this.designation=designation;
        officeNonCloseFriends.add(this);
    }
}
