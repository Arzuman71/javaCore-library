import java.util.Scanner;


public class BookTest {

    private static Scanner scanner = new Scanner(System.in);
    private static DataStorage dataStorage = new DataStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            showCommands();
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addBook();
                    break;
                case "2":
                    searchBookByTitle();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }


    }

    private static void showCommands() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 for ADD BOOK");
        System.out.println("Please input 2 for SEARCH BOOK BY TITLE");
    }

    private static void addBook() {
        System.out.println("Please input Book data:");
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("authorName:");
        String authorName = scanner.nextLine();
               System.out.println("price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("count:");
        int count = Integer.parseInt(scanner.nextLine());
        Book book = new Book(title, authorName, price, count);
        dataStorage.add(book);
        System.out.println("Book was added");
    }

    private static void searchBookByTitle() {
        System.out.println("Please input title for search");
        String searchTitle = scanner.nextLine();
        Book searchedBook = dataStorage.getBookByTitle(searchTitle);
        if (searchedBook == null) {
            System.out.println("Book with " + searchTitle + " title does not exists");
        } else {
            System.out.println(searchedBook);
        }
    }

}
