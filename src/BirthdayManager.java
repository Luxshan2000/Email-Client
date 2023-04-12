import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BirthdayManager {

    public static void checker(){
        try {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd");
            String formattedDate = myDateObj.format(myFormatObj);

            List<Personal> personals = Personal.personals;
            List<OfficeCloseFriends> officeCloseFriends = OfficeCloseFriends.officeCloseFriends;
            String[] bDate;

            //send birthday wishes to personal
            for (int i = 0; i < personals.size(); i++) {
                bDate = personals.get(i).getBirthday().split("/", 2);
                if (bDate[1].equalsIgnoreCase(formattedDate)) {
                    Personal personal = personals.get(i);
                    if (!sentOrNotWishes(personal.getMail())) {
                        MailSender.send(personal.getMail(), "Birthday Wishes", personal.sendWishes());
                    }
                }
            }

            //send birthday wishes to officialCloseFriends
            for (int i = 0; i < officeCloseFriends.size(); i++) {
                bDate = officeCloseFriends.get(i).getBirthday().split("/", 2);
                if (bDate[1].equalsIgnoreCase(formattedDate)) {
                    OfficeCloseFriends officeCloseFriend = officeCloseFriends.get(i);
                    if (!sentOrNotWishes(officeCloseFriend.getMail())) {
                        MailSender.send(officeCloseFriend.getMail(), "Birthday Wishes", officeCloseFriend.sendWishes());
                    }


                }
            }
        }catch (Exception e){
            System.out.println("Error Occurred While Checking Birthday!!!");
        }
    }

    public static Boolean sentOrNotWishes(String email) {
        try{
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy_MM_dd");
            String formattedDate = myDateObj.format(myFormatObj);
            File myFile = new File("history\\"+formattedDate+".txt");
            if(myFile.exists()) {
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    data=data.strip();
                    String [] datat=data.split("\t");
                    if(email.equalsIgnoreCase(datat[0])){
                        if(datat[1].equalsIgnoreCase("Birthday Wishes")){
                            return true;
                        }
                    }
                }
                myReader.close();
            }
        }
        catch (Exception e){
            System.out.println("Error Occurred While Checking Sent Birthday!!!");
            return false;
        }
        return false;
    }
    public static void printBirthday(String date){
        //Shallow copy
        List<Personal> personals=Personal.personals;
        List<OfficeCloseFriends> officialCloseFriends=OfficeCloseFriends.officeCloseFriends;
        //to print personal
        String date_s;
        String [] date_a;
        for (int i=0;i<personals.size();i++){
            date_s=personals.get(i).getBirthday();
            date_a=date_s.split("/",2);
            date_s=date_a[1];
            if(date_s.equalsIgnoreCase(date)){
                System.out.print(personals.get(i).getName()+", ");
            }
        }
        //to print officialCloseFriends
        for (int i=0;i<officialCloseFriends.size();i++){
            date_s=officialCloseFriends.get(i).getBirthday();
            date_a=date_s.split("/",2);
            date_s=date_a[1];
            if(date_s.equalsIgnoreCase(date)){
                System.out.print(officialCloseFriends.get(i).getName()+", ");
            }
        }
        System.out.println("");//create a new line
    }
}