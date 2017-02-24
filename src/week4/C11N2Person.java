package week4;

import java.time.LocalDate;

/**
 *
 * @author Hank Gontarz
 */
public class C11N2Person {
    private String name;
    private String address;
    private String phone;
    private String email;

    public C11N2Person() {
    }

    public C11N2Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person {" + "name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }
    
}

class Student extends C11N2Person {
    final String status;

    public Student(String status) {
        this.status = status;
    }

    public Student(String status, String name, String address, String phone, String email) {
        super(name, address, phone, email);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Student {" + "status=" + status + "; " + super.toString() + '}';
    }
    
}

class Employee extends C11N2Person {
    private String office;
    private double salary;
    private LocalDate hireDate;

    public Employee() {
    }

    public Employee(String office, double salary, LocalDate hireDate, 
            String name, String address, String phone, String email) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee {" + "office=" + office +
                ", salary=" + salary + ", hireDate=" + hireDate + 
                "; " + super.toString() + '}';
    }
    
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty() {
    }

    public Faculty(String officeHours, String rank, String office, 
            double salary, LocalDate hireDate, String name, String address, String phone, String email) {
        super(office, salary, hireDate, name, address, phone, email);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public String toString() {
        return "Faculty {" + getName() + "; " + super.toString() + '}';
    }
    
}

class Staff extends Employee {
    private String title;

    public Staff() {
    }

    public Staff(String title, String office, double salary, LocalDate hireDate, String name, String address, String phone, String email) {
        super(office, salary, hireDate, name, address, phone, email);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff {" + getName() + "; " + super.toString() + '}';
    }
    
}

class C11N2Test {
    public static void main(String[] args) {
        C11N2Person p1 = new C11N2Person("Joe", "55 Main St", "555-1212", "joe@gmail.com");
        Student s1 = new Student("Junior", "George", "13 Elm St", "444-1212", "george@gmail.com");
        Employee e1 = new Employee("207 Elliot", 90000, LocalDate.now(), "Dr. Pong", "15 Elmira St", "555-2121", "pong@mansfield.edu");
        Faculty f1 = new Faculty("M,W,F 10am-12pm", "Assistant", "108 Belknap", 75000, LocalDate.now(), "John Doe", "25 Main", "570-999-9090", "jdoe@mansfield.edu");
        Staff st1 = new Staff("Janitor", "5 Mansor", 40000, LocalDate.now(), "Fred Black", "55 Forest Ln", "570-666-5432", "fblack@gmail.com");
        System.out.println(p1);
        System.out.println(s1);
        System.out.println(e1);
        System.out.println(f1);
        System.out.println(st1);
    }
}