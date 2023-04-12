abstract class ContactsManager {
    public static void createContact(String content){
        try {
            String[] contact = content.strip().split(":", 2);
            String type = contact[0].strip();
            String details = contact[1].strip();
            String[] line = details.split(",");

            if (type.equalsIgnoreCase("Personal")) {
                createPersonal(type, line);
            } else if (type.equalsIgnoreCase("Official")) {
                createOffice(type, line);
            } else if (type.equalsIgnoreCase("Office_friend")) {
                createOffice_friend(type, line);
            } else {
                System.out.println("Error Occurred While Creating Contact!!!");
            }
        }
        catch (Exception e){
            System.out.println("Error Occurred While Creating Contact!!!");
        }
    }

    private static void createPersonal(String type,String[] details){
        try{
            String name=details[0].strip();
            String mail=details[2].strip();
            String nickName=details[1].strip();
            String birthday=details[3].strip();
            Personal personal=new Personal(name,mail,nickName,birthday);
        }
        catch (Exception e){
            System.out.println("Error Occurred While Creating Contact!!!");
        }

    }
    private static void createOffice(String type,String[] details){
        try{
            String name=details[0].strip();
            String mail=details[1].strip();
            String designation=details[2].strip();
            OfficeNonCloseFriends officeNonCloseFriends;
            officeNonCloseFriends=new OfficeNonCloseFriends(name,mail,designation);
        }
        catch (Exception e){
            System.out.println("Error Occurred While Creating Contact!!!");
        }

    }
    private static void createOffice_friend(String type,String[] details){
        try{
            String name=details[0].strip();
            String mail=details[1].strip();
            String designation=details[2].strip();
            String birthday=details[3].strip();
            OfficeCloseFriends officeCloseFriends;
            officeCloseFriends=new OfficeCloseFriends(name,mail,designation,birthday);
        }
        catch (Exception e){
            System.out.println("Error Occurred While Creating Contact!!!");
        }
    }
}