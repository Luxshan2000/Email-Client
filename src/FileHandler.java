import java.io.*;
import java.util.Scanner;

public class FileHandler {
    private static FileHandler instance=null;
    //Singleton Pattern , to avoid thread
    public static synchronized FileHandler getInstance(){
        if(instance==null){
            instance=new FileHandler();
        }
        return instance;
    }
    private FileHandler(){};//prevent to create instant by constructor
    public void createFile(String path){
        try {
            File contacts=new File(path);
            contacts.createNewFile();
        }
        catch (IOException e) {
            System.out.println("Error Occurred While Creating File!!!");
            e.getStackTrace();
        }
    }

    /*--add new lines without erasing previous content--*/
    public void writeFile(String path,String content,boolean addContact){
        try {
            FileWriter myWriter=new FileWriter(path,true);
            BufferedWriter bw=new BufferedWriter(myWriter);
            bw.write(content+"\n");
            bw.close();
        }
        catch (IOException e) {
            System.out.println("Error Occurred While Writing On File!!!");
            e.getStackTrace();
        }
        if(addContact){
            ContactsManager.createContact(content);
        }
    }

    /*--read the file line by line--*/
    public void readFile(String path,boolean addContact){
        try {
            File contacts=new File("contacts");
            if(!contacts.exists()){
                contacts.mkdir();
            }
            File history=new File("history");
            if(!history.exists()){
                history.mkdir();
            }
            File myFile = new File(path);
            if(!myFile.exists()){
                myFile.createNewFile();
            }
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(addContact){
                    //Create Recipient Instance
                    ContactsManager.createContact(data.strip());
                }
                else{
                    //used to print history
                    System.out.println(data);
                }

            }
            myReader.close();
        }
        catch (Exception e){
            System.out.println("Error Occurred While Reading The Contact File!!!");
        }
    }

    public static void deleteFile(String path){
        File myObj = new File(path);
        if(myObj.exists()){
            myObj.delete();
        }
    }
}
