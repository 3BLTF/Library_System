import java.util.Scanner;
public class LibrarySystem extends Library
{
    public LibrarySystem(int capacity) {
        super(capacity);
    }

    public void menue(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the library: ");
        int capacity = scanner.nextInt();
        Library lib = new Library(capacity);
        int choice;

        do
        {

            System.out.println();
            System.out.println("Library System Menu");
            System.out.println("--------------------");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. View library status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            if(choice==1)
            {
                lib.addBook();
            }
            else if(choice==2)
            {
                lib.removeBook();
            }
            else if (choice==3)
            {
                lib.borrowBook();
            }
            else if (choice== 4)
            {
                lib.returnBook();
            }
            else if (choice==5)
            {
                lib.viewLibraryStatus();
            }
            else if (choice==6)
            {
                System.out.println("Exiting the library system. Goodbye!");
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
            }

        }while(choice!=6);
        {
            scanner.close();
        }


    }
    }




