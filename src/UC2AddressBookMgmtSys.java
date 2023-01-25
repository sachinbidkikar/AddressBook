import java.util.Scanner;

public class UC2AddressBookMgmtSys {
    private static Scanner scanner = new Scanner(System.in);
    private static UC1Contact[] contacts = new UC1Contact[20];

    public static void main(String[] args) {
        UC2AddressBookMgmtSys sys = new UC2AddressBookMgmtSys();

        System.out.println("Welcome to Address Book Management System..!");
        System.out.println();

        sys.addEditDeleteFindContact();
    }

    public void addEditDeleteFindContact() {
        boolean isExist = false;
        while (!isExist) {
            System.out.println("Please Select Option\n1.addContact");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addContact();
                    break;
                default:
                    System.out.println("Invalid Choice Please Select Valid Option...!");

            }
        }
    }

    private static UC1Contact addContact() {
        UC1Contact contact = new UC1Contact();    //constructor is created in contact class (empty)
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
}