package fr.ensai.library;

/**
 * Represents a Student.
 */
public class Student extends Person {
    private int academicYear;
    private boolean isClassDelegate;

    /**
     * Constructs a new Student object.
     */
    public Student(String name, int age, int academicYear, boolean isClassDelegate) {
        super(name, age);
        this.academicYear = academicYear;
        this.isClassDelegate = isClassDelegate;
    }

    @Override
    public String toString() {
        return "Student " + name;
    }
}
