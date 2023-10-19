import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item " + id + ": " + name;
    }
}

public class ConsolePaginationWithArrayList {

    private static int itemsPerPage = 5;

    public static void main(String[] args) {
        List<Item> data = generateData();
        int currentPage = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int startIndex = currentPage * itemsPerPage;
            int endIndex = Math.min(startIndex + itemsPerPage, data.size());

            // Display the current page of data
            for (int i = startIndex; i < endIndex; i++) {
                System.out.println(data.get(i));
            }


            System.out.println("\nPage " + (currentPage + 1) + " of " + (int) Math.ceil((double) data.size() / itemsPerPage));

            System.out.println("Enter 'n' for next page, 'p' for previous page, 's' to set the number of rows per page, or 'q' to quit:");
            String input = scanner.nextLine();

            if (input.equals("n") && endIndex < data.size()) {
                currentPage++;
            } else if (input.equals("p") && currentPage > 0) {
                currentPage--;
            } else if (input.equals("s")) {
                setRowsPerPage(scanner);
            } else if (input.equals("q")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'n', 'p', 's', or 'q'.");
            }
        }

        scanner.close();
    }

    private static List<Item> generateData() {
        List<Item> data = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            data.add(new Item(i, "Name " + i));
        }
        return data;
    }

    private static void setRowsPerPage(Scanner scanner) {
        System.out.println("Enter the number of rows per page:");
        try {
            int newItemsPerPage = Integer.parseInt(scanner.nextLine());
            if (newItemsPerPage > 0) {
                itemsPerPage = newItemsPerPage;
            } else {
                System.out.println("Please enter a positive integer for rows per page.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a positive integer for rows per page.");
        }
    }
}
