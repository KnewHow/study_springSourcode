package study.spring.domain;

public class Student {

    private String number;

    private String name;

    private int age;

    private String gender;

    private Teacher teacher;

    public Student() {
    }

    public Student(String number, String name, int age, String gender, Teacher teacher) {
        super();
        this.number = number;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.teacher = teacher;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student [number=" + number + ", name=" + name + ", age=" + age + ", gender=" + gender
                + ", teacher=" + teacher + "]";
    }

}
