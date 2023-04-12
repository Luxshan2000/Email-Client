import java.util.ArrayList;
import java.util.List;

public class Personal extends Recipients {
    private String nickName;
    private String birthday;
    public static List<Personal> personals=new ArrayList<>();

    public Personal(String name,String mail,String nickName,String birthday){
        super(name,mail);
        this.birthday=birthday;
        this.nickName=nickName;
        personals.add(this);
    };

    public String sendWishes(){
        return "Hugs and Love On Your Birthday.";
    }

    public String getBirthday() {
        return this.birthday;
    }
}