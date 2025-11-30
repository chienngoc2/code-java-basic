
package colectiondemo;


public class Student implements Comparable<Student> {
    private int id;
    private  String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String toString(){
        return "id: "+ this.id+"-name "+this.name+"-gpa "+this.gpa;
    }

    @Override
    public int compareTo(Student other) {  
    if (this.gpa > other.gpa) {  
        return 1;  
    } else if (this.gpa < other.gpa) {  
        return -1;  
    } else {  
        if (this.id > other.id) {  
            return 1;  
        } else if (this.id < other.id) {  
            return -1;  
        } else {  
            return 0;  
        }  
    }  
}
}
