package fr.ensai.library;

public class Main {

    public static void main(String[] args) {

        Library maBibliotheque = new Library("BU");
        maBibliotheque.loadBooksFromCSV("books.csv");
        Magazine magazine1 = new Magazine("5", "Sciences et vie", 10, 2000, 10);
        Magazine magazine2 = new Magazine("8", "Portes et vitrines", 100, 1985, 100);
        maBibliotheque.addItem(magazine1);
        maBibliotheque.addItem(magazine2);
        maBibliotheque.displayItem();
        Student student = new Student("Moi", 21, 15, false);
        maBibliotheque.loanItem(maBibliotheque.getBooksByAuthor(new Author("J.R.R. Tolkien")).get(1), student);
        maBibliotheque.getActiveLoans();
        maBibliotheque.renderItem(maBibliotheque.getBooksByAuthor(new Author("J.R.R. Tolkien")).get(1));
}
}