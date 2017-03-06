package study.spring.domain;

public class Teacher {

    private String number;

    private String name;

    private double salary;

    public Teacher() {
        super();
    }

    public Teacher(String number, String name, double salary) {
        super();
        this.number = number;
        this.name = name;
        this.salary = salary;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher [number=" + number + ", name=" + name + ", salary=" + salary + "]";
    }

}
