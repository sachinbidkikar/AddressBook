import java.util.Arrays;
import java.util.Scanner;

public class AddressBookMgmtSys {
    private static Scanner scanner = new Scanner(System.in);
    private static Contact[] contacts = new Contact[20];

    public static void main(String[] args) {
        AddressBookMgmtSys sys = new AddressBookMgmtSys();

        System.out.println("Welcome to Address Book Management System..!");
        System.out.println();

        sys.contactImplOperations();
    }

    public void contactImplOperations() {
        boolean isExist = false;
        while (!isExist) {
            System.out.println("Please Select Option\n1.addContact\n2. edit contact");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    System.out.println("Enter name to edit");
                    String name = scanner.nextLine();
                    int contactIndex = findContactByName(name);
                    System.out.println(contactIndex);
                    if (contactIndex == -1) {
                        System.out.println("Contact not found with name: " + name);
                    } else {
                        Contact contact = editContact(contacts[contactIndex]);
                        contacts[contactIndex] = contact;
                    }
                    System.out.println(Arrays.toString(contacts));
                    break;
                default:
                    System.out.println("Invalid Choice Please Select Valid Option...!");

            }
        }
    }

    private static Contact addContact() {
        Contact contact = new Contact();    //constructor is created in contact class (empty)
        System.out.println("Enter First Name :");
        contact.setfName(scanner.nextLine());

        System.out.println("Enter Middle Name :");
        contact.setmName(scanner.nextLine());

        System.out.println("Enter Last Name :");
        contact.setlName(scanner.nextLine());

        System.out.println("Enter Residential address :");
        contact.setAdd(scanner.nextLine());

        System.out.println("Enter City Name  :");
        contact.setCity(scanner.nextLine());

        System.out.println("Enter State  Name :");
        contact.setState(scanner.nextLine());

        System.out.println("Enter Country Name :");
        contact.setCountry(scanner.nextLine());

        System.out.println("Enter PinCode :");
        contact.setPinCode(scanner.nextInt());

        System.out.println("Enter Phone Number :");
        contact.setPhoneNum(scanner.nextLong());

        System.out.println("Enter Email Address:");
        contact.setEmail(scanner.nextLine());

        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                contacts[i] = contact;
                System.out.println("Contact Added Successfully in Address book system....!");
                return contact;
            }
        }
        System.out.println("Contact List is Full No Space For New Contacts");
        return contact;
    }
    private static UC1Contact editContact(UC1Contact contact) {
        System.out.println("Edit first name");
        contact.setfName(scanner.nextLine());
        return contact;
    }
    private static int findContactByName(String name) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (contacts[i].getfName().equals(name) ||
                        contacts[i].getlName().equals(name)) {
                    return i;
                }
            }
        }
        return -1;
    }
}