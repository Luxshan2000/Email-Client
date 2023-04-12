import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MailHistory {
    private static final String history="history\\";

    public static void saveHistory(String content) {
        //save daily activity in a .txt file in History Folder
        //yyyy_MM__dd.txt
        FileHandler fileHandler=FileHandler.getInstance();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        String formattedDate = myDateObj.format(myFormatObj);
        String address=history+formattedDate+".txt";
        File myObj = new File(address);
        if(!myObj.exists()){
            fileHandler.createFile(address);
        }
        fileHandler.writeFile(address,content,false);
    }

    public static void getHistory(String date){
        String newDate=date.replace("/","_");
        String address=history+newDate+".txt";
        File myObj=new File(address);
        if(myObj.exists()){
            FileHandler fileHandler=FileHandler.getInstance();
            fileHandler.readFile(address,false);
        }
        else {
            System.out.println("Empty!!!");
        }
    }
}
