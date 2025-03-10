package fr.ensai.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a library.
 */
public class Library {
    // Attributes
    private String name;
    private List<Item> items;
    private List<Loan> activeLoans;
    private List<Loan> completedLoans;

    /**
     * Constructs a new Library object.
     */
    public Library(String name, List<Item> items, List<Loan> activeLoans, List<Loan> completedLoans) {
        this.name = name;
        this.items = items;
        this.activeLoans = activeLoans;
        this.completedLoans = completedLoans;
    }

    public Library(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.activeLoans = new ArrayList<>();
        this.completedLoans = new ArrayList<>();
    }

    /**
     * Adds an item to the library’s collection
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Print all books of the library
     */
    public void displayItem() {
        if (items.size() == 0) {
            System.out.println("There is no item in the library");
        } else {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName);
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addItem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public Loan findActiveLoanForItem(Item item) {
        for (Loan loan : activeLoans) {
            if (loan.getItem() == item) {
                return loan;
            }
        }
        return null;
    }

    public List<Loan> getActiveLoans() {
        return activeLoans;
    }

    public List<Book> getBooksByAuthor(Author author) {
        List<Book> books = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (author.equals(book.getAuthor())) {
                    books.add(book);
                }
            }
        }
        return books;
    }

    public boolean loanItem(Item item, Student student) {
        if (findActiveLoanForItem(item) != null) {
            return false;
        }
        Date date = new Date(System.currentTimeMillis());
        Loan nLoan = new Loan(item, student, date);
        activeLoans.add(nLoan);
        return true;
    }

    public boolean renderItem(Item item) {
        for (Loan loan : activeLoans) {
            if (loan.getItem() == item) {
                Date date = new Date(System.currentTimeMillis());
                loan.setReturnDate(date);
                activeLoans.remove(loan);
                completedLoans.add(loan);
                return true;
            }
        }
        return false;
    }

    public void displayActiveLoans() {
        System.out.println(activeLoans);
    }
}