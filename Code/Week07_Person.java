import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
/*
* Testcase
* Class Design
* */
public class Week07_Person {
    private String name,address,phone,email;

    public Week07_Person() {
        this("NONAME","NOADDRESS","0123456789","nomail@mail.com");
    }

    public Week07_Person(String name, String address, String phone, String email) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.length() <= 0){
            System.out.println("Name must contain at least 1 character");
            return;
        }
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) { //Try validating with regex first
        this.email = email.toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return "Week07_Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name,address,phoneNumber,email;
        System.out.print("Week07_Person\nName: ");
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Phone number: ");
        phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();

        Week07_Person Week07_Person = new Week07_Person(name,address,phoneNumber,email);
        System.out.println(Week07_Person);

        System.out.print("\nStudent\nName: ");
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Phone number: ");
        phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        Student student = new Student(name,address,phoneNumber,email,Student.FRESHMEN);
        System.out.println(student);

        String office;
        double salary;
        System.out.print("\nEmployee\nName: ");
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Phone number: ");
        phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Office: ");
        office = scanner.nextLine();
        System.out.print("Salary: ");
        salary = scanner.nextDouble();
        scanner.nextLine();//flush newline
        Employee employee = new Employee(name, address, phoneNumber, email, office, salary);
        employee.setDateHired("2000-12-09");
        System.out.println(employee);

        String title;
        System.out.print("\nStaff\nName: ");
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Phone number: ");
        phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Office: ");
        office = scanner.nextLine();
        System.out.print("Salary: ");
        salary = scanner.nextDouble();
        scanner.nextLine();//flush newline
        System.out.print("Title: ");
        title = scanner.nextLine();
        Staff staff = new Staff(name, address, phoneNumber, email, office, salary,title);
        System.out.println(staff);

        System.out.print("\nFaculty\nName: ");
        name = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Phone number: ");
        phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Office: ");
        office = scanner.nextLine();
        System.out.print("Salary: ");
        salary = scanner.nextDouble();
        scanner.nextLine();//flush newline
        System.out.print("Office Hours: ");
        String officeHours = scanner.nextLine();
        System.out.print("Rank: ");
        String rank = scanner.nextLine();
        Faculty faculty = new Faculty(name, address, phoneNumber, email, office, salary,officeHours,rank);
        System.out.println(faculty);
    }
}

class Student extends Week07_Person{
    public final static String FRESHMEN="FRESHMEN",SOPHOMORE="SOPHOMORE",JUNIOR="JUNIOR",SENIOR="SENIOR";
    private String status;


    public Student() {
        this.setStatus("FRESHMEN");
    }
    public Student(String status) {
        this.setStatus(status);
    }

    public Student(String name, String address, String phone, String email) {
        this(name, address, phone, email,"FRESHMEN");
    }
    public Student(String name, String address, String phone, String email, String status) {
        super(name, address, phone, email);
        this.setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status.equals(Student.FRESHMEN) || status.equals(Student.SOPHOMORE) || status.equals(Student.JUNIOR) || status.equals(Student.SENIOR)){
            this.status = status;
        }
        else{
            System.err.println("Please use static field to set the status value");
            this.status = "INVALIDSTATUS";
        }
    }

    @Override
    public String toString() {
        return  super.toString()+
                " Student{" +
                "status='" + status + '\'' +
                '}';
    }
}
class Employee extends Week07_Person{
    private String office;
    private Date dateHired;
    private double salary;

    public Employee() {
        this("NOOFFICE",5000);
    }

    public Employee(String office, double salary) {
        //super() is called automatically
        this.office = office;
        this.salary = salary;
        this.dateHired = new Date();
    }

    public Employee(String name, String address, String phone, String email, String office, double salary) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = new Date();
    }



    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setDateHired(String dateHired) {
        //Taken from https://stackoverflow.com/a/22326440
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            this.dateHired = sdf.parse(dateHired); // Handle the ParseException here
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Date getDateHired() {
        return dateHired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary <= 0){
            System.err.println("Salary must be positive");
            return;
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " Employee{" +
                "office='" + office + '\'' +
                ", dateHired=" + dateHired +
                ", salary=" + salary +
                '}';
    }
}

class Faculty extends Employee{
    private String officeHours, rank;

    public Faculty() {
        this.officeHours = "08.00-17.00";
        this.rank = "Instructor";
    }

    public Faculty(String officeHours, String rank) {
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public Faculty(String office, double salary, String officeHours, String rank) {
        super(office, salary);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public Faculty(String name, String address, String phone, String email, String office, double salary, String officeHours, String rank) {
        super(name, address, phone, email, office, salary);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " Faculty{" +
                "officeHours='" + officeHours + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
class Staff extends Employee{
    private String title;

    public Staff() {
        this("NOTITLE");
    }

    public Staff(String title) {
        this.title = title;
    }

    public Staff(String office, double salary, String title) {
        super(office, salary);
        this.title = title;
    }

    public Staff(String name, String address, String phone, String email, String office, double salary, String title) {
        super(name, address, phone, email, office, salary);
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
        return  super.toString() +
                " Staff{" +
                "title='" + title + '\'' +
                '}';
    }
}