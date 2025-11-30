package model;

public class Main {

    public static void main(String[] args) {

        Inputter input = new Inputter();
        System.out.println("Please choose your Campus:");
        System.out.println("1. SE");
        System.out.println("2. HE");
        System.out.println("3. QE");
        System.out.println("4. DE");
        System.out.println("5. CE");
        System.out.println("Your choice: ");
        // Select Campus name
        String campus = input.getChoiceCampus();
        System.out.println("Your Campus is: " + campus);

        //ID
        
        String id =input.getID(campus);

        // Enter Name
        System.out.println("Please enter your name");
        String name = input.getName();

        // Enter Phone
        System.out.println("Please enter your Phone number");
        String phone = input.getNumPhone();

        // Enter Email
        System.out.println("Please enter your Email");
        String email = input.getEmail();

        // Data Mountain
        System.out.println("from the MountainList.csv file");
        String mountainCode = " Da Lat";
        // Tuition Fee
        System.out.println("Your tuition: ");
        int tuition = (int) input.getTuitionCal(phone);
        System.out.println(tuition);
        
        Student student = new Student(id, name,email, phone,mountainCode ,tuition );
        System.out.println("Student information: ");
        System.out.println(student.toString());
    }

}
