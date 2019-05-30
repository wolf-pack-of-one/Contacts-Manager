package manager.contact;

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

// I need to add getters and setters for the private data


        //=== Show All Contacts ==//

        //======= Delay ============//
        public static void delay() {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(".....");
            }
        } //========End Pause==========//


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
        System.out.println("\n ====================\n");
        delay();
        delay();

    }

        //=== Add new contact ===//

    public static void newContact() {
        ArrayList<String> contactInfo = new ArrayList<>();

        System.out.println("Please enter the contact name (Last, First): \n");
        String name = inputter.nextLine();
        System.out.println("Please enter the contact phone number (###-###-####): \n");
        String phone = inputter.nextLine();

        contactInfo.add("Name: " + name + " // Phone: " + phone + "\n");

        try {
            Files.write(
                    file,
                    contactInfo,
                    StandardOpenOption.APPEND
            );
            delay();
            System.out.println("\n");
            System.out.println("New contact \"" + name + "\" added!\n");
            delay();
            delay();
            System.out.println("===============\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


        //=== Search a contact by name ===//



        //=== Delete an existing contact ===//


        //==== User interaction =====//

    public static void startContacting() {
        System.out.println(
                "Hey! I'm your Contact Buddy! Whatcha want?\n" +
                        "---------------------- \n" +
                "1. Browse All Contacts\n" +
                "2. Add A New Contact\n" +
                "3. Search By Name\n" +
                "4. Delete Unwanted Contact\n" +
                "5. Exit\n" +
                "Enter an option (1, 2, 3, 4, or 5): "
        );
            String userSelection = inputter.nextLine();

            switch (userSelection) {
                case "1":
                    displayContacts();
                    startContacting();
                    break;
                case "2":
                    newContact();
                    startContacting();
                    break;
                case "3":
                    System.out.println(("This is my favorite option."));
                    startContacting();
                    break;
                case "4":
                    System.out.println("I don't want to do this.");
                    startContacting();
                    break;
                case "5":
                    System.out.println("Goodbye.");
                    break;

            }

    }



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

        startContacting();




    } //==== End Main Method ====//


}

