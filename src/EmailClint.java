// 200359K
//T.LUXSHAN
import java.io.File;
import java.util.Scanner;
public class EmailClint {
    public static void main(String[] args){
        //set Host Password,name,username
        /******************Please Set*******************/
        MailHost host=MailHost.getInstance();
        host.setName("T.LuxShan");
        host.setUsername("luxshanlux2000@gmail.com");
        host.setPassword("ryacglikbnoereor");

        /***********************************************/
        //Make sure to create startup contents
        FileManager.update();
        //check birthday
        BirthdayManager.checker();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");
        boolean loop=true;
        while (loop) {
            System.out.print("Option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter (Should be the standard format)");
                    System.out.println("[Eg:Official: nimal,nimal@gmail.com,ceo");
                    System.out.println("    Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12");
                    System.out.println("    Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10]");
                    scanner.nextLine();
                    String content = scanner.nextLine();
                    String type = content.strip().split(":")[0].strip();
                    FileManager.writeFile(content, type);
                    BirthdayManager.checker();
                    break;
                case 2:
                    System.out.print("To: ");
                    String email = scanner.next();
                    email = email.strip();
                    scanner.nextLine();
                    System.out.print("Subject: ");
                    String subject = scanner.nextLine();
                    //scanner.nextLine();
                    subject = subject.strip();
                    System.out.print("Content: ");
                    String contentt = scanner.nextLine();
                    contentt = contentt.strip();
                    MailSender.send(email, subject, contentt);
                    break;

                case 3:
                    System.out.print("Date(MM/dd): ");
                    scanner.nextLine();
                    String date = scanner.nextLine();
                    date = date.strip();
                    BirthdayManager.printBirthday(date);
                    break;

                case 4:
                    System.out.print("Date(yyyy/MM/dd): ");
                    scanner.nextLine();
                    String d = scanner.nextLine();
                    d = d.strip();
                    MailHistory.getHistory(d);
                    break;

                case 5:
                    System.out.println("Number Of Recipient Objects In The Application Is " + Recipients.count());
                    scanner.nextLine();
                    break;
            }
            System.out.println("Are you want to continue more operation?(YES or NO)");
            String lo = scanner.nextLine();
            if(lo.equalsIgnoreCase("no")){
                loop=false;
            }
        }
    }
}