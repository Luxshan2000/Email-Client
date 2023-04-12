abstract class FileManager {
    //set paths as final
    private static final String contacts="contacts\\clientList.txt";

    public static void reset(){
        FileHandler fileHandler=FileHandler.getInstance();
        /*--delete all --*/
        fileHandler.deleteFile(contacts);
        /*--create empty file--*/
        fileHandler.createFile(contacts);
    }

    public static void writeFile(String content,String type){
        FileHandler fileHandler=FileHandler.getInstance();
        if(type.equalsIgnoreCase("Official")){
            fileHandler.writeFile(contacts,content,true);
        }
        if(type.equalsIgnoreCase("Office_friend")){
            fileHandler.writeFile(contacts,content,true);
        }
        if(type.equalsIgnoreCase("Personal")){
            fileHandler.writeFile(contacts,content,true);
        }
    }
    public static void update(){
        FileHandler fileHandler=FileHandler.getInstance();
        fileHandler.readFile(contacts,true);
    }

}
