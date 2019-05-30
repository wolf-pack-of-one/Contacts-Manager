import java.nio.file.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ContactBuddy {

    private static Path folder = Paths.get("data");
    private static Path file = Paths.get("data", "contacts.txt");

    static Scanner inputter = new Scanner(System.in);



        //=== Show All Contacts ==//

    public static void displayContacts() {
//        ArrayList<String> contactsArray = new ArrayList<>();
        // read the text file, if there are contacts display them.  If not, say "No contacts"

        try {

            List<String> contactsArray = Files.readAllLines(file);

            for (int i = 0; i < contactsArray.size(); i += 1) {
                System.out.println((i + 1) + ": " + contactsArray.get(i));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }


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
displayContacts();



    } //==== End Main Method ====//


}

