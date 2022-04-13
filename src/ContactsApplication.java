package src;
import java.util.*;

public class ContactsApplication {


    public static void main(String[] args)  {

    Scanner scanner=new Scanner(System.in);


        String choice="yes";
        String directory="data";
        String fileName="contacts.txt";


        FileManager contactsFile=new FileManager(fileName,directory);



//            creates data directory and empty contacts file
        contactsFile.writeFile();

//      starts program UI
      do {

          System.out.println("1. View contacts.\n" +
                  "2. Add a new contact.\n" +
                  "3. Search a contact by name.\n" +
                  "4. Delete an existing contact.\n" +
                  "5. Exit.\n" +
                  "Enter an option (1, 2, 3, 4 or 5):");



          String userChoice = scanner.nextLine();



          if (userChoice.equals("1")) {
//              code to view contacts
              System.out.println("you picked View Contacts");

              contactsFile.printLines();

          }
          if (userChoice.equals("2")) {
//              code to add new contact
              System.out.println("you picked  Add a Contact ");
              System.out.println();
              System.out.println("please enter Contacts Name");
              String userCreateName=scanner.nextLine();
              System.out.println("please enter Contacts Number");
              String userCreateNumber=scanner.nextLine();
              Contact userContact=new Contact(userCreateName,userCreateNumber);
              System.out.println("You have entered \n"+userContact.getNameNumber());

              contactsFile.addLine(userContact.getNameNumber());

              contactsFile.writeFile();


          }
          if (userChoice.equals("3")) {
//              code to search a contact by name
              System.out.println("you picked Search by Name");
              System.out.println("Please enter a contact Name");
              String userSearch= scanner.nextLine();
              contactsFile.getContact(userSearch);
          }
          if (userChoice.equals("4")) {
//              code to delete and existing contact.
              System.out.println("you picked delete an existing contact");
              contactsFile.printLines();
//              System.out.println();
              System.out.println("Please enter the Name of the contact you would like to delete");
              String userSelection= scanner.nextLine();
                contactsFile.removeLine(userSelection);


          }
          if (userChoice.equals("5")) {
              System.out.println("you picked 5, Good Bye!");
              choice="no";
              break;
          }

          System.out.println("Would you like to continue y/n?");

          choice=scanner.nextLine();

      }while (choice.equalsIgnoreCase("y"));





    }


}
