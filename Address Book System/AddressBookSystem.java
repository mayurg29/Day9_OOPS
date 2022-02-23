package com.bridgelabz.Day9;

import java.util.*;

public class AddressBookSystem {
    static Collection<Contacts> person = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AddressBookSystem ab = new AddressBookSystem();
        System.out.println("Welcome to Address Book Program");
        int choice = 0;
        while (choice != 4){
            choice = ab.menu();
            ab.console(choice);
        }
    }

    public int menu(){
        System.out.println("Choose an option:\n 1.Create Contact\n 2.Edit Contact\n " +
                           "3. Delete Contact\n 4.Exit");
        return sc.nextInt();
    }

    public void console(int choice) {
        switch (choice) {
            case 1:
                createContacts();
                break;
            case 2:
                editContact();
                break;
            case 3:
                toDelete();
                break;
            case 4:
                System.out.println("Exit....");
                break;
            default:
                System.out.println("Enter valid Option");
        }
    }


    // to create contact
    public void createContacts() {
        Contacts contacts = new Contacts();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Name: ");
        String firstName = sc.nextLine();
        contacts.setFirstName(firstName);

        System.out.println("Enter Last Name: ");
        String lastName = sc.nextLine();
        contacts.setLastName(lastName);

        System.out.println("Enter Address: ");
        String address = sc.nextLine();
        contacts.setAddress(address);

        System.out.println("Enter City: ");
        String city = sc.nextLine();
        contacts.setCity(city);

        System.out.println("Enter State: ");
        String state = sc.nextLine();
        contacts.setState(state);

        System.out.println("Enter Zip: ");
        String zip = sc.nextLine();
        contacts.setZip(zip);

        System.out.println("Enter phoneNumber:");
        String phoneNumber = sc.nextLine();
        contacts.setPhoneNumber(phoneNumber);

        System.out.println("Enter Email Id: ");
        String email = sc.nextLine();
        contacts.setEmail(email);

        person.add(contacts);
        System.out.println("Contact" + firstName + "created successfully");
    }

    // to edit contacts in AddressBook
    public void editContact() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first name you want to edit: ");
        String first = sc.next();

        boolean isPerson = false;

        for (int i = 0; i < person.size(); i++) {
            if (((ArrayList<Contacts>) person).get(i).getFirstname().equals(first)) {

                isPerson = true;

                ((ArrayList<Contacts>) person).get(i).setFirstName(first);

                System.out.print("Enter Last Name:");
                String lastName = sc.next();
                ((ArrayList<Contacts>) person).get(i).setLastName(lastName);

                System.out.print("Enter Address:");
                String address = sc.next();
                ((ArrayList<Contacts>) person).get(i).setAddress(address);

                System.out.print("Enter state:");
                String state = sc.next();
                ((ArrayList<Contacts>) person).get(i).setState(state);

                System.out.print("Enter zip:");
                String zip = sc.next();
                ((ArrayList<Contacts>) person).get(i).setZip(zip);

                System.out.print("Enter phoneNumber:");
                String phoneNumber = sc.next();
                ((ArrayList<Contacts>) person).get(i).setPhoneNumber(phoneNumber);

                System.out.print("Enter email:");
                String email = sc.next();
                ((ArrayList<Contacts>) person).get(i).setEmail(email);

                System.out.println("Contact edited successfully");
            }
        }
        if (!isPerson)
            System.out.println("Contact could not be found");
    }

    // to delete contact
    public void toDelete() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first name of the contact to be deleted");
        String firstName = sc.next();

        for (int i = 0; i < person.size(); i++) {
            if (((ArrayList<Contacts>) person).get(i).getFirstname().equals(firstName)) {
                person.remove(((ArrayList<Contacts>) person).get(i));
                System.out.println("Contact removed successfully");
            } else {
                System.out.println("Contact not found");
            }
        }
    }
}


