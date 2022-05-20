import java.util.*;

public class AddressBookMain {
    static boolean isRunning = true;

    //ArrayList object is created
    List<Contacts> person = new ArrayList<Contacts>();
    Dictionary address = new Hashtable();

    //Taking input from the user
    static Scanner scanner = new Scanner(System.in);

    /*
     * console method create for taking input as per the User choice.
     */
    public void console() {
        System.out.println("-----------------");
        System.out.println("1. Create contact");
        System.out.println("2. Edit Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Print all contacts");
        System.out.println("5. Add multiple person to Address Book");
        System.out.println("6. Create another address book");
        System.out.println("7. Exit");
        System.out.println("Enter your choice: ");

        int option = scanner.nextInt();
            switch (option) {
                case 1:
                    createContacts();
                    break;

                case 2:
                    editContacts();
                    break;

                case 3:
                    deleteContact();
                    break;

                case 4:
                    printAllContacts();
                    break;

                case 5:
                    addMultiplePerson();
                    break;

                case 6:
                    addAddressBook();
                    break;

                case 7:
                    System.out.println("Exit...");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Enter valid option: ");
                    break;
        }
    }

    /*
     * createContacts method created to create contacts with the given fields.
     */
    public void createContacts() {
        Contacts contacts = new Contacts();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        contacts.setFirstName(firstName);

        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        contacts.setLastName(lastName);

        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        contacts.setAddress(address);

        System.out.println("Enter City: ");
        String city = scanner.nextLine();
        contacts.setCity(city);

        System.out.println("Enter State: ");
        String state = scanner.nextLine();
        contacts.setState(state);

        System.out.println("Enter zip: ");
        String zip = scanner.nextLine();
        contacts.setZip(zip);

        System.out.println("Enter PhoneNumber: ");
        String phoneNumber = scanner.nextLine();
        contacts.setPhoneNumber(phoneNumber);

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        contacts.setEmail(email);

        //Checks whether the contact with the same number is already existing in your Address Book.
        boolean isDuplicate = false;
        for (Contacts contact : person) {
            if (contact.getPhoneNumber().equals(contacts.getPhoneNumber())) {
                isDuplicate = true;
            }
        }
        //if the contact is already stored in Address book it will print message print.
        if (isDuplicate)
        {
            System.out.println("Contact existing in your Address Book");
        } else
        //if not then it will add the contact in your Address Book
        {
            person.add(contacts);
            System.out.println("Contact " +firstName+ " created Successfully");
            System.out.println(person.toString());
        }
    }

    /*
     * editContacts method created to update contacts with the given fields.
     */
    public void editContacts() {
        System.out.println("Enter the name to edit: ");
        String first = scanner.next();

        boolean isPerson = false;

        //for loop used to get the size of array to edit the contact
        for (int i = 0; i < person.size(); i++) {
            if (((ArrayList<Contacts>) person).get(i).getFirstName().equals(first)) {

                isPerson = true;
                System.out.println("Enter your choice to edit: 1. First Name\n2. Last Name\n3. Address\n4.City\n" +
                        "5. State\n6. Zip\n7. PhoneNumber\n8. Email\n9. Exit ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter First Name: ");
                        String firstName = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setFirstName(firstName);
                        break;

                    case 2:
                        System.out.println("Enter Last Name: ");
                        String lastName = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setLastName(lastName);
                        break;

                    case 3:
                        System.out.println("Enter Address: ");
                        String address = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setAddress(address);

                    case 4:
                        System.out.println("Enter City: ");
                        String city = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setCity(city);
                        break;

                    case 5:
                        System.out.println("Enter State: ");
                        String state = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setState(state);
                        break;

                    case 6:
                        System.out.println("Enter Zip: ");
                        String zip = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setZip(zip);
                        break;

                    case 7:
                        System.out.println("Enter PhoneNumber: ");
                        String phoneNumber = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setPhoneNumber(phoneNumber);
                        break;

                    case 8:
                        System.out.println("Enter Email: ");
                        String email = scanner.next();
                        ((ArrayList<Contacts>)person).get(i).setEmail(email);
                        break;

                    default:
                        System.out.println("Select valid option: ");

                } //end of switch
                System.out.println(person);
            }
        }
        if (!isPerson)
            System.out.println("Contact not found!!!");
    } // end of for loop

    /*
     * deleteContacts method created to remove specific contact.
     */
    public void deleteContact() {
        System.out.println("Enter the First Name of the contact that you want to delete: ");
        String firstName = scanner.next();

        for (int i = 0; i< person.size();i++) {
            if (((ArrayList<Contacts>) person).get(i).getFirstName().equals(firstName)) {
                person.remove(((ArrayList<Contacts>)person).get(i));
                System.out.println("Contact removed successfully!!!");
            } else
                System.out.println("Contact not found.");
        }
    }

    /*
     * addMultiplePerson method created to add multiple person to address Book
     */
    public void addMultiplePerson() {
        while (true) {
            System.out.println("Enter your choice \n1. Create Contact\n2. Edit Contact" + "\n3. To Delete Contact\n4. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> createContacts();
                case 2 -> editContacts();
                case 3 -> deleteContact();
                case 4 -> System.out.println("Exit..");
                default -> System.out.println("Invalid Choice");
            }
            if (option == 4)
                break;
        }
    }

    /*
     * addAddressBook method created to add new add multiple address book to the system.
     */
    public void addAddressBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of address Book you want: ");
        AddressBookMain addressBookMain = new AddressBookMain();
        String bookName = scanner.nextLine();
        address.put(bookName,addressBookMain);
        System.out.println("Address Book " +bookName+ " has been created.");
    }
    /*
     * printAllContacts method created to print all contacts of AddressBook
     */
    public void printAllContacts() {
        for (int i = 0; i < person.size();i++) {
            System.out.println(((ArrayList<Contacts>)person).get(i));
        }
    }

    public static void main(String[] args) {
        /*
         * Displaying Welcome to Address Book Program in AddressBookMain class
         */
        System.out.println("Welcome to Address Book Program!");
        //AddressBookMain object created
        AddressBookMain addressBookMain = new AddressBookMain();
        while (isRunning) {
            addressBookMain.console();
        }
    }
}
