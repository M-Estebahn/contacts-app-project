package src;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ContactsApplication {


    public static void main(String[] args)  {

    Scanner scanner=new Scanner(System.in);


        String choice="yes";
        String directory="data";
        String fileName="contacts.txt";

        Path dataDir= Paths.get(directory);
        Path contactsPath=Paths.get(directory, fileName);

        List<String> fileData=new ArrayList<>();


//            creates data directory and empty contacts file
        try{
            if (Files.notExists(dataDir)) {
                Files.createDirectories(dataDir);
            }
            if (Files.notExists(contactsPath)){
                Files.createFile(contactsPath);

            }  //        read the contents of the file and store in string list

        } catch (IOException e) {
            System.out.println("issue creating directory and file");
            e.printStackTrace();
        }



      do {

          System.out.println("1. View contacts.\n" +
                  "2. Add a new contact.\n" +
                  "3. Search a contact by name.\n" +
                  "4. Delete an existing contact.\n" +
                  "5. Exit.\n" +
                  "Enter an option (1, 2, 3, 4 or 5):");

          List<String> userContact=new ArrayList<>();
          String userChoice = scanner.nextLine();

          try {
              Files.write(contactsPath ,fileData);
          } catch (IOException e) {
              e.printStackTrace();
              System.out.println("Error writing to file: " + contactsPath.getFileName());
          }
          if (userChoice.equals("1")) {
//              code to view contacts
              System.out.println("you picked 1");
          }
          if (userChoice.equals("2")) {
//              code to add new contact
              System.out.println("you picked  Add a Contact ");
              System.out.println();
              System.out.println("please enter Contacts Name|Phone#");
              userContact= Collections.singletonList(scanner.nextLine());

              try {
                  Files.write(contactsPath,userContact, StandardOpenOption.APPEND);
              } catch (IOException e) {
                  System.out.println("issue writing files");
                  e.printStackTrace();
              }


          }
          if (userChoice.equals("3")) {
//              code to search a contact by name
              System.out.println("you picked 3");
          }
          if (userChoice.equals("4")) {
//              code to delete and existing contact.
              System.out.println("you picked 4");
          }
          if (userChoice.equals("5")) {
              System.out.println("you picked 5, Good Bye!");
              choice="no";
              break;
          }
          System.out.println("would you like to continue y/n?");

          choice=scanner.nextLine();
      }while (choice.equalsIgnoreCase("y"));





    }


}
