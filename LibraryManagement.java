package Chapter10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        int count = 0;
        int num1 = 0;
        while (num1 == 0){
            System.out.println("********Welcome to library*********");
            System.out.println("How can i help you");
            num1++;
        }
        int selection;
        do {
            Library lib = new Library();
            System.out.println();
            System.out.println("***********MENU***********");
            System.out.println("1. Show Available books");
            System.out.println("2. Issue a book");
            System.out.println("3. Books issued");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your choice - ");
            selection = scan.nextInt();
            switch (selection) {
                case 1:
                    if (count != 0){
                        lib.subtractBook(lib.arrayBook,lib.getBookNo());
                        lib.DisplayNewArray();
                    }
                    else {
                        lib.showAvailableBooks();
                        count++;
                    }
                    break;
                case 2:
                    System.out.print("Write the number of book you want to issue: ");

                    int num = scan.nextInt();
                    lib.setBookNo(num);
                    lib.issueBook(lib.getBookNo());
                    //System.out.println(lib.getBookNo());
                    //lib.subtractBook(lib.arrayBook, lib.getBookNo());
                    //lib.DisplayNewArray();
                    break;
                case 3:
                    lib.issuedBooks(lib.arrayBook, lib.arrayOfBooksIssued, lib.getBookNo());
                    break;
                case 4:
                    lib.addElement(lib.newArray);
                    break;
                case 5:
                    System.out.println("Thank you for your visit!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice");
            }
        } while (selection != 5);

    }
}

class Library{
    String[] arrayBook = {"Ram", "Sita", "Ravan"}; // Created a library having books
    String[] arrayOfBooksIssued = {};
    int bookNo;

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    // This function is used to show the available books in library
    public void showAvailableBooks(){
        for (int i = 0; i < arrayBook.length; i++){
            System.out.print(i+1 + "." + arrayBook[i] + " ");
        }
    }

    // Used to display which book you issued
    public void issueBook(int a){
        System.out.println("You issued: " + arrayBook[a-1]);
    }

    // Creating a new array to store the updated elements after removing the issued book from library
    String[] newArray = new String[arrayBook.length - 1];

    // Function to remove issued element from library
    public String[] subtractBook(String[] arrayBook, int a){
        for (int i = 0, j = 0; i < arrayBook.length; i++){
            if(i != a+1){
                newArray[j++] = arrayBook[i];
            }
        }
        return newArray;
    }

    // To display new or updated array
    public void DisplayNewArray(){
        for (int i = 0; i < newArray.length; i++){
            System.out.println(i+1 + "." + newArray[i]);
        }
    }

    public void issuedBooks(String[] arrayBook,String[] arrayOfBooksIssued, int a){
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(arrayBook));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(arrayOfBooksIssued));
        String removedElement = list1.remove(a-1);
        list2.add(removedElement);

        arrayBook = list1.toArray(new String[0]);
        arrayOfBooksIssued = list2.toArray(new String[0]);

        for (int i = 0; i < arrayOfBooksIssued.length; i++){
            System.out.println("Issed books are" + arrayOfBooksIssued[i] + " ");
        }
    }

    public void addElement(String[] newArray){
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(newArray));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book you want to add: ");
        String input = sc.nextLine();

        list1.add(input);
        newArray = list1.toArray(new String[0]);

        for (int i = 0; i < newArray.length; i++){
            System.out.println("" + newArray[i] + " ");
        }
    }

}
