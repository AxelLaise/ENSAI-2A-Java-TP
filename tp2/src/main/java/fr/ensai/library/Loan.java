package fr.ensai.library;

import java.util.Date;

public class Loan {
    private Student student;
    private Item item;
    private Date startDate;
    private Date returnDate;
    
    /**
    * Constructs a new Loan object.
    */
    public Loan(Item item, Student student, Date starDate) {
        this.student = student;
        this.item = item;
        this.startDate = starDate;
        this.returnDate = null;
    }

    public Item getItem(){
        return item;
    }

    public void setReturnDate(Date date){
        returnDate = date;
    }

    public String toString(){
        return "Item " + item.toString() + "borrowed by " + student.toString();
    }
}
