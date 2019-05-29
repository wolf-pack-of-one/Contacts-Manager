import java.nio.file.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ContactBuddy {

    String directory = "data";
    private static Path folder = Paths.get("data");
    private static Path file = Paths.get("data", "contacts.txt");

    static Scanner inputter = new Scanner(System.in);


        //=== Show All Contacts ==//



        //=== Add new contact ===//



        //=== Search a contact by name ===//



        //=== Delete an existing contact ===//



    //*******===== MAIN METHOD =====*******//


    public static void main(String[] args) {

//===== Create the directory and contacts file, if not already present. ====//

        if(Files.notExists(folder)){
            try {
                Files.createDirectories(folder);
                System.out.println(folder + " was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!Files.exists(file)){
            try {
                Files.createFile(file);
                System.out.println(file + " file was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //===== Interaction with the user =======//




    } //==== End Main Method ====//


}

