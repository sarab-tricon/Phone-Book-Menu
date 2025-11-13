//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
  String name;
  String type;
  String phoneNumber;

  Contact(String name, String type, String phoneNumber) {
    this.name = name;
    this.type = type;
    this.phoneNumber = phoneNumber;
  }
}

public class PhoneBook {

  static ArrayList<Contact> contacts = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice;

    do {
      System.out.println("===== PHONE BOOK MENU =====");
      System.out.println("1. Add Contact");
      System.out.println("2. Search Contact");
      System.out.println("3. Delete Contact");
      System.out.println("4. Display All Contacts");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");

      choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          addContact(sc);
          break;
        case 2:
          searchContact(sc);
          break;
        case 3:
          deleteContact(sc);
          break;
        case 4:
          displayContacts();
          break;
        case 5:
          System.out.println("Exiting phone book...");
          break;
        default:
          System.out.println("Invalid choice! Please enter 1 to 5.");
      }
    } while (choice != 5);

  }

  private static void addContact(Scanner sc) {
    System.out.print("Enter name: ");
    String name = sc.nextLine();

    System.out.print("Enter Type: ");
    String type = sc.nextLine();

    System.out.print("Enter phone number: ");
    String phoneNumber = sc.nextLine();

    contacts.add(new Contact(name, type, phoneNumber));
    System.out.println("Contact added!");
    System.out.println();
  }

  private static void searchContact(Scanner sc) {
    System.out.print("Enter name to search: ");
    String searchName = sc.nextLine();
    boolean found = false;

    for (Contact c : contacts) {
      if (c.name.equalsIgnoreCase(searchName)) {
        System.out.println(c.name + ": " + c.phoneNumber + ", " + c.type);
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("Contact not found.");
    }
    System.out.println();
  }

  private static void deleteContact(Scanner sc) {
    System.out.print("Enter name to delete: ");
    String nameToDelete = sc.nextLine();
    boolean removed = false;

    for (int i = 0; i < contacts.size(); i++) {
      if (contacts.get(i).name.equalsIgnoreCase(nameToDelete)) {
        contacts.remove(i);
        System.out.println("Contact deleted.");
        removed = true;
        break;
      }
    }

    if (!removed) {
      System.out.println("Contact not found.");
    }
    System.out.println();
  }

  private static void displayContacts() {
    System.out.println("----- ALL CONTACTS -----");
    if (contacts.isEmpty()) {
      System.out.println("No contacts found.");
    } else {
      for (Contact c : contacts) {
        System.out.println(c.name + " : " + c.phoneNumber + " , " + c.type);
      }
    }
    System.out.println();
  }
}
