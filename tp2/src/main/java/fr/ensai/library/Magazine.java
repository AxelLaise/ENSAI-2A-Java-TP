package fr.ensai.library;

public class Magazine extends Item{
        // Attributes
        private String isbn;
        private int issueNumber;
    
        /**
         * Constructs a new Book object.
         */
        public Magazine(String isbn, String title, int issueNumber, int year, int pageCount) {
            super(title, year, pageCount);
            this.isbn = isbn;
            this.issueNumber = issueNumber;
        }
    
        @Override
        public String toString() {
            return "Magazine " + title + " issue number " + pageCount;
        }
}
